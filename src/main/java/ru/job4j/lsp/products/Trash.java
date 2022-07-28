package ru.job4j.lsp.products;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    private List<Food> trashStore = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        return false;
    }

    @Override
    public boolean accept(Food food) {
        return false;
    }

    @Override
    public List<Food> createListOfProducts() {
        return trashStore;
    }
}
