package ru.job4j.lsp.parking;

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


    @Before
    public void initParking() {
        parking = new MoscowParking(2, 1);
        redCar = new PassengerCar("redCar", "101");
        blueCar = new PassengerCar("blueCar", "222");
        cyberTruck = new Truck("cyberTruck", "666", 4);
        superTruck = new Truck("superTruck", "555", 3);
        smallTruck = new Truck("smallTruck", "000", 2);
        tinyPorsche = new PassengerCar("tinyPorsche", "007");
    }

    @Test
    public void whenSuccessParkTwoSmallAndOneTruck() {
        assertTrue(parking.park(redCar));
        assertTrue(parking.park(blueCar));
        assertTrue(parking.park(cyberTruck));
    }


    @Test
    public void whenSuccessParkOnlyTrucks() {
        assertTrue(parking.park(superTruck));
        assertTrue(parking.park(smallTruck));
    }

    @Test
    public void whenFalseParkTrucks() {
        assertTrue(parking.park(superTruck));
        assertTrue(parking.park(smallTruck));
        assertFalse(parking.park(cyberTruck));
    }

    @Test
    public void whenNoPlaceForCars() {
        assertTrue(parking.park(redCar));
        assertTrue(parking.park(blueCar));
        assertFalse(parking.park(tinyPorsche));
    }

    @Test
    public void whenNoEmptyParkSpaces() {
        assertTrue(parking.park(redCar));
        assertTrue(parking.park(blueCar));
        assertTrue(parking.park(cyberTruck));
        assertFalse(parking.park(tinyPorsche));
    }


    @Test
    public void whenAlreadyParked() {
        assertTrue(parking.park(redCar));
        assertFalse(parking.park(redCar));
    }

}
