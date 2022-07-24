package ru.job4j.ocp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.design.srp.report.Employee;
import ru.job4j.design.srp.report.Report;
import ru.job4j.design.srp.report.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class JSONReportEngine implements Report {
    private Store store;

    public JSONReportEngine(Store store) {
        this.store = store;
    }


    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        final Gson gson = new GsonBuilder().create();
        for (Employee employee : store.findBy(filter)) {
            text.append(gson.toJson(employee))
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
