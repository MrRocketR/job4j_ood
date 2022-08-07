package ru.job4j.lsp.foodstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.lsp.parking.MoscowParking;
import ru.job4j.lsp.parking.PassengerCar;
import ru.job4j.lsp.parking.Truck;

public class ParkingTests {
    private MoscowParking parking;
    private  PassengerCar redCar;
    private PassengerCar blueCar;
    private Truck cyberTruck;
    private  Truck superTruck;

    @Ignore
    @Before
    public void initParking() {
        parking = new MoscowParking(2, 1);
        redCar = new PassengerCar("Small red car");
        blueCar = new PassengerCar("Small blue car");
        cyberTruck = new Truck("that's big", 2);
        superTruck = new Truck("truck", 3);
    }

    @Ignore
    @Test
    public void whenSuccessParkTwoSmallAndOneTruck() {
        parking.park(redCar);
        parking.park(blueCar);
        parking.park(cyberTruck);
    }

    @Ignore
    @Test
    public void whenSuccessParkOnlyTrucks() {
        parking.park(superTruck);
        parking.park(cyberTruck);
    }
}
