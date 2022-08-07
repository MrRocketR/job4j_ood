package ru.job4j.lsp.foodstore.storages;

import ru.job4j.lsp.foodstore.model.Food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public interface Store {
    boolean add(Food food);

    boolean accept(Food food);

    default double getPercentLifeExpired(Food food) {
        double lifeTime = ChronoUnit.DAYS.between(food
                .getCreateDate(), food.getExpiryDate());
        double remain = ChronoUnit.DAYS.between(LocalDate
                .now(), food.getExpiryDate());
        return remain / lifeTime * 100;

    }

    List<Food> getStore();

    void empty();


}
