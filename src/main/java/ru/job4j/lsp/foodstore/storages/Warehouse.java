package ru.job4j.lsp.foodstore.storages;

import ru.job4j.lsp.foodstore.model.Food;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {
    private List<Food> warehouseStore = new ArrayList<>();
    public static final int ZERO = 0;
    public static final int QUARTER = 25;

    @Override
    public boolean add(Food food) {
        boolean accepted = accept(food);
        boolean result = false;
        if (accepted) {
            warehouseStore.add(food);
            result = true;
        }
        return result;
    }

    @Override
    public boolean accept(Food food) {
        double percent = getPercentLifeExpired(food);
        return percent > ZERO && percent < QUARTER;
    }

    @Override
    public List<Food> getStore() {
        return List.copyOf(warehouseStore);
    }
}
