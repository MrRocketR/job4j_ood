package ru.job4j.antisolid.antilsp;

public class Password {
    int pass;

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public String validate(int pass) {
        if (pass == 0) {
           return "Password is invalid";
        }
            return "Valid!";
    }
}
