package ru.job4j.antisolid.antilsp;

public class BankPassword extends Password {
    int pass;

    @Override
    public int getPass() {
        return pass;
    }

    @Override
    public void setPass(int pass) {
        this.pass = pass;
    }

    @Override
    public String validate(int pass) {
        if (pass <= 3) {
            return "Password is too short";
        }
            return "Valid";
    }
}
