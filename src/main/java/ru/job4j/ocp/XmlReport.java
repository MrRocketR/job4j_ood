package ru.job4j.ocp;

import ru.job4j.design.srp.report.Employee;
import ru.job4j.design.srp.report.Report;

import java.util.function.Predicate;

public class XmlReport implements Report {
    @Override
    public String generate(Predicate<Employee> filter) {
        return null;
    }
}
