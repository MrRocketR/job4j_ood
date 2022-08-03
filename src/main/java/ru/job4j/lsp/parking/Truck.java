package ru.job4j.lsp.parking;

public class Truck extends Transport {

    private int size;

    public Truck(String name, int size) {
        super(name);
        this.size = size;
    }


    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

}
