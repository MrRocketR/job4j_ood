package ru.job4j.lsp.parking;

public class Truck extends Transport {

    public Truck(String name, String number, int size) {
        super(name, number, size);
        if (size <= 1) {
            throw new IllegalArgumentException("wrong size of the truck!");
        }
    }
}
