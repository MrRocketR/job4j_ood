package ru.job4j.lsp.parking;

public abstract class Transport {
    private String name;

    public Transport(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
