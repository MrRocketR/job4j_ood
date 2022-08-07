package ru.job4j.antisolid.antilsp;

import java.util.ArrayList;
import java.util.List;

public class ColdStore extends Storehouse {
    private List<String> coldDepository = new ArrayList<>();
    @Override
    public boolean checkStore() {
        if (coldDepository.isEmpty()) {
            throw new IllegalArgumentException("Store is empty");
        }
        return true;
    }
}
