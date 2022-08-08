package ru.job4j.lsp.parking;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MoscowParking implements Parking {
    private int passenderlots;
    private int trucklots;
    private Set<Transport> passengerParking;
    private Set<Transport> truckParking;

    public MoscowParking(int passenger, int trucks) {
        this.passenderlots = passenger;
        this.trucklots = trucks;
        passengerParking = new HashSet<>();
        truckParking = new HashSet<>();
    }

    @Override
    public boolean park(Transport car) {
        boolean result = false;
        if (car.getSize() == 1) {
            if (passenderlots >= passengerParking.size()) {
                result = passengerParking.add(car);
                passenderlots--;
            }
        } else {
            result = setTruckParking(car);
        }
        return result;
    }

    private boolean setTruckParking(Transport car) {
        boolean result = false;
        if (trucklots >= truckParking.size()) {
            result = truckParking.add(car);
            trucklots--;
        }
        if (!result) {
            int passengerParkSize = passenderlots - car.getSize();
            if (passengerParkSize >= 0) {
                result = passengerParking.add(car);
                passenderlots--;
            }
        }
        return result;
    }

}
