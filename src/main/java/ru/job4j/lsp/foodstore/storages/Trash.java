package ru.job4j.lsp.foodstore.storages;

import ru.job4j.lsp.foodstore.model.Food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {

    private List<Food> trashStore = new ArrayList<>();
    public static final int ZERO = 0;

    @Override
    public boolean add(Food food) {
        boolean accepted = accept(food);
        boolean result = false;
        if (accepted) {
            trashStore.add(food);
            result = true;
        }
        return result;
    }

    @Override
    public boolean accept(Food food) {
        double percent = getPercentLifeExpired(food);
        return percent <= ZERO;

    }

    @Override
    public List<Food> getStore() {
        return List.copyOf(trashStore);
    }

}
