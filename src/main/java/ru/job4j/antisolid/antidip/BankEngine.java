package ru.job4j.antisolid.antidip;

public class BankEngine {
    private  int money;
    Register reg = new Register();
    Transaction transaction;

    public void initUser(int money, String name) {
        this.money = money;
        reg.registrate(name);
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}

