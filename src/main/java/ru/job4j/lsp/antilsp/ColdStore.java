package ru.job4j.lsp.antilsp;

import java.util.ArrayList;
import java.util.List;

public class ColdStore extends Storehouse {
    private List<String> ColdDepository = new ArrayList<>();
    @Override
    public boolean checkStore() {
        if (ColdDepository.isEmpty()) {
            throw new IllegalArgumentException("Store is empty");
        }
        return true;
    }
}
