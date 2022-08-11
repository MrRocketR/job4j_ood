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
        passengerParking = new HashSet<>(passenger);
        truckParking = new HashSet<>(trucks);
    }

    @Override
    public boolean park(Transport car) {
        boolean result = false;
        if (PassengerCar.SIZE == car.getSize()) {
            if (passenderlots != 0) {
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
        if (trucklots > 0) {
            result = truckParking.add(car);
            trucklots--;
        }
        if (!result && passenderlots - car.getSize() >= 0) {
            result = passengerParking.add(car);
            passenderlots--;
        }
        return result;
    }

}
