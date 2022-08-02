package ru.job4j.lsp.foodstore.storages;

import ru.job4j.lsp.foodstore.model.Food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    private List<Food> trashStore = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean accepted = accept(food);
        if (accepted) {
            trashStore.add(food);
            return true;
        }
        return false;
    }

    @Override
    public boolean accept(Food food) {
        double percent = getPercentLifeExpired(food);
        return percent <= 0;

    }

    @Override
    public List<Food> getStore() {
        return List.copyOf(trashStore);
    }

}
