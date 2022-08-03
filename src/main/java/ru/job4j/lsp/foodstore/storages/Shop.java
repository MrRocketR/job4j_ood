package ru.job4j.lsp.foodstore.storages;


import ru.job4j.lsp.foodstore.model.Food;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    private final List<Food> shopStore = new ArrayList<>();
    public static final int QUARTER = 25;
    public static final int MORE = 75;

    @Override
    public boolean add(Food food) {
        boolean accepted = accept(food);
        boolean r = false;
        if (accepted) {
            shopStore.add(food);
            r = true;
        }
        return r;
    }


    @Override
    public boolean accept(Food food) {
        double percent = getPercentLifeExpired(food);
        boolean result = false;
        if (percent >= QUARTER && percent <= MORE) {
            result = true;
        }
        if (percent > MORE) {
            food.setPrice(food.getPrice() - food.getDiscount());
            result = true;
        }
        return result;
    }

    @Override
    public List<Food> getStore() {
        return List.copyOf(shopStore);
    }


}
