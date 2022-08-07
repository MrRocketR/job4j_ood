package ru.job4j.lsp.foodstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.lsp.parking.MoscowParking;
import ru.job4j.lsp.parking.PassengerCar;
import ru.job4j.lsp.parking.Truck;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParkingTests {
    private MoscowParking parking;
    private PassengerCar redCar;
    private PassengerCar blueCar;
    private Truck cyberTruck;
    private Truck superTruck;
    private Truck smallTruck;
    private PassengerCar tinyPorsche;


    @Ignore
    @Before
    public void initParking() {
        parking = new MoscowParking(2, 1);
        redCar = new PassengerCar("Small red car");
        blueCar = new PassengerCar("Small blue car");
        cyberTruck = new Truck("that's big", 2);
        superTruck = new Truck("truck", 3);
        smallTruck = new Truck("TinyTrack", 1);
        tinyPorsche = new PassengerCar("bip bip");


    }

    @Ignore
    @Test
    public void whenSuccessParkTwoSmallAndOneTruck() {
        assertTrue(parking.park(redCar));
        assertTrue(parking.park(blueCar));
        assertTrue(parking.park(cyberTruck));
    }

    @Ignore
    @Test
    public void whenSuccessParkOnlyTrucks() {
        assertTrue(parking.park(superTruck));
        assertTrue(parking.park(cyberTruck));
    }

    @Ignore
    @Test
    public void whenFalseParkTrucks() {
        assertTrue(parking.park(superTruck));
        assertTrue(parking.park(cyberTruck));
        assertFalse(parking.park(smallTruck));
    }

    @Ignore
    @Test
    public void whenNoPlaceForCars() {
        assertTrue(parking.park(redCar));
        assertTrue(parking.park(blueCar));
        assertFalse(parking.park(tinyPorsche));
    }

    @Ignore
    @Test
    public void whenNoEmptyParkSpaces() {
        assertTrue(parking.park(redCar));
        assertTrue(parking.park(blueCar));
        assertTrue(parking.park(cyberTruck));
        assertFalse(parking.park(tinyPorsche));
    }


}
