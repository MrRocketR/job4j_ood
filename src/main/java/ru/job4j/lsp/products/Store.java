package ru.job4j.lsp.products;

import ru.job4j.design.srp.report.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public interface Store {
    boolean add(Food food);

    boolean accept(Food food);

    default double getPercentLifeExpired(Food food) {
        return food.getCreateDate() / food.getExpiryDate() * 1.0;
    }

    List<Food> createListOfProducts();


}
