package ru.job4j.lsp.parking;

import java.util.Objects;

public abstract class Transport {
    private String name;
    private String number;
    private int size;

    public Transport(String name, String number, int size) {
        this.name = name;
        this.number = number;
        this.size = size;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }


    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Transport{" + "name='" + name
                + '\'' + ", number='"
                + number + '\'' + ", size="
                + size + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transport transport = (Transport) o;
        return Objects.equals(name, transport.name) && Objects.equals(number, transport.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }
}
