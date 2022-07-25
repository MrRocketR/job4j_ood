package ru.job4j.design.srp.report;

import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public class CAOEngine implements Report {

    private Store store;

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    public static final int COEF = 12;

    public CAOEngine(Store store) {
        this.store = store;
    }


    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary() * COEF).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}

