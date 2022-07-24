package ru.job4j.design.srp.report;

import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public class NewEngine implements Report {

    private Store store;

    public NewEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(" ")
                    .append(employee.getSalary() * 12)
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}

