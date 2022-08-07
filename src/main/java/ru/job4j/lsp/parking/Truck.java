package ru.job4j.lsp.parking;

public class Truck extends Transport {

    private int size;

    public Truck(String name, int size) {
        super(name);
        if (size < 1) {
            throw new IllegalArgumentException("wrong size of the truck!");
        }
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
