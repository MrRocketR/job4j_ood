package ru.job4j.lsp.parking;

public interface Parking {
    int[] generateLots(int i);
    int findFreeSpace(Car car);

}
