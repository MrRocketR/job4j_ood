package ru.job4j.lsp.parking;

public class PassengerCar extends Transport {
    public static final int SIZE = 1;


    public PassengerCar(String name, String number) {
        super(name, number, SIZE);
    }
}
