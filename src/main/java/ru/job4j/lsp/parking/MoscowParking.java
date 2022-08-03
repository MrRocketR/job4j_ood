package ru.job4j.lsp.parking;

import java.util.HashSet;
import java.util.Set;

public class MoscowParking implements Parking {

    private Set<Transport> passengerParking = new HashSet<>();
    private Set<Truck> truckParking = new HashSet<>();

    @Override
    public boolean park(Transport car) {
        return false;
    }
}
