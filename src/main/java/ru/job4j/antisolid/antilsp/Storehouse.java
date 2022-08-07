package ru.job4j.antisolid.antilsp;

import java.util.ArrayList;
import java.util.List;

public class Storehouse {
    private List<String> depository = new ArrayList<>();
    public boolean checkStore() {
        return !depository.isEmpty();
    }
}
