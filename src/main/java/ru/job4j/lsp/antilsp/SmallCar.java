package ru.job4j.lsp.antilsp;

public class SmallCar {
    Engine engine;

    public void start(Engine e) {
        this.engine = e;
        checkEngine(e.getFuel());
    }
    public void checkEngine(int fuel) {
        if (engine.fuel == engine.capacity) {
            throw new IllegalArgumentException("No fuel, engine can't start");
        }
    }
}
