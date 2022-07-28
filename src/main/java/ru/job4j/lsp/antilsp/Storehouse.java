package ru.job4j.lsp.antilsp;

import java.util.ArrayList;
import java.util.List;

public class Storehouse {
    private List<String> depository = new ArrayList<>();
    public boolean checkStore () {
        return !depository.isEmpty();
    }
}
