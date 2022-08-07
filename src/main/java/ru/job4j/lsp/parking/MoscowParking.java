package ru.job4j.lsp.parking;

import java.util.HashSet;
import java.util.Set;

public class MoscowParking implements Parking {
    private int passenderlots;
    private int trucklots;
    private Set<Transport> passengerParking;
    private Set<Truck> truckParking;

    public MoscowParking(int  passenger, int trucks) {
        this.passenderlots = passenger;
        this.trucklots = trucks;
        passengerParking = new HashSet<>(passenger);
        truckParking = new HashSet<>(trucks);
    }

    @Override
    public boolean park(Transport car) {
        return false;
    }
}
