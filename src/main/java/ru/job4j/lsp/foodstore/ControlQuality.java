package ru.job4j.lsp.foodstore;

import ru.job4j.lsp.foodstore.model.Food;
import ru.job4j.lsp.foodstore.storages.Store;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private final List<Store> storages;

    public ControlQuality(List<Store> storages) {
        this.storages = storages;
    }

    public void addFood(Food food) {
        for (Store stores : storages) {
            stores.add(food);
        }
    }

    public void resort() {
        List<Food> tempFood = new ArrayList<>();
        for (Store stores : storages) {
            List<Food> temp =  stores.getStore();
            tempFood.addAll(temp);
            stores.empty();
        }
        for (Food food : tempFood) {
            addFood(food);
        }

    }
}

