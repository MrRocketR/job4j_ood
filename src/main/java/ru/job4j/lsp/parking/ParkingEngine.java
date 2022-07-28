package ru.job4j.lsp.parking;

public class ParkingEngine implements Parking{
    private int[] lots;

    @Override
    public int[] generateLots(int i) {
        return new int[0];
    }

    @Override
    public int findFreeSpace(Car car) {
        return 0;
    }
}
