package ru.job4j.tdd;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class CinemaTest {

    @Ignore
    public void whenBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Ignore
    public void whenFind() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenAlreadyBoughtTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket1 = cinema.buy(account, 1, 1, date);
        Ticket ticket2 = cinema.buy(account, 1, 1, date);
        }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenInvalidPlace() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, -1, -1, date);

    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenInvalidDate() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(1900, 13, 40, 40, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
    }
}

