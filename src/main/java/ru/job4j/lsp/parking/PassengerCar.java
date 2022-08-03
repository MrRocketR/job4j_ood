package ru.job4j.lsp.parking;

public class PassengerCar extends Transport {
    private static final int SIZE = 1;

    public PassengerCar(String name) {
        super(name);
    }

    public static int getSIZE() {
        return SIZE;
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
