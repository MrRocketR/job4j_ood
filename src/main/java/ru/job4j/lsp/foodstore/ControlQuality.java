package ru.job4j.lsp.foodstore;

import ru.job4j.lsp.foodstore.model.Food;
import ru.job4j.lsp.foodstore.storages.Store;

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
    }

