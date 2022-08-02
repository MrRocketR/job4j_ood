package ru.job4j.lsp.foodstore.storages;



import ru.job4j.lsp.foodstore.model.Food;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    private final List<Food> shopStore = new ArrayList<>();
    @Override
    public boolean add(Food food) {
        boolean accepted = accept(food);
        if (accepted) {
            shopStore.add(food);
            return true;
        }
        return false;
    }
    private void newPrice(Food food) {
       food.setPrice(food.getPrice() - food.getDiscount());
    }

    @Override
    public boolean accept(Food food) {
        double percent = getPercentLifeExpired(food);
        boolean result = false;
        if (percent >= 25 && percent <= 75) {
            result = true;
        }
        if (percent > 75) {
           newPrice(food);
           result = true;
        }
        return result;
    }

    @Override
    public List<Food> getStore() {
        return List.copyOf(shopStore);
    }


}
