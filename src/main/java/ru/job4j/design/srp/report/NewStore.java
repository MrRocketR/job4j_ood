package ru.job4j.design.srp.report;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NewStore implements Store {

    private final List<Employee> employees = new ArrayList<>();

    @Override
    public void add(Employee em) {
        employees.add(em);
    }

    @Override
    public List<Employee> findBy(Predicate<Employee> filter) {
        return employees.stream().filter(filter)
                .sorted((Employee o1, Employee o2) -> (int) (o2.getSalary() - o1.getSalary()))
                .collect(Collectors.toList());
    }
}
