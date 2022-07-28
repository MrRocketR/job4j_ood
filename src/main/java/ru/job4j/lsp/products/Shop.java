package ru.job4j.lsp.products;



import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    private final List<Food> store = new ArrayList<>();
    @Override
    public boolean add(Food food) {
        boolean accepted = accept(food);
        if (accepted) {
            store.add(food);
            return true;
        }
        return false;
    }

    @Override
    public boolean accept(Food food) {
        double percent = getPercentLifeExpired(food);
        return percent < 25 || percent < 75;
    }


    @Override
    public List<Food> createListOfProducts() {
        return store;
    }
}
