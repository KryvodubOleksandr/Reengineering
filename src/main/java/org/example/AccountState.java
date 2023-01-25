package org.example;

public class AccountState {
    private double money;

    private String currency;

    public AccountState(double money, String currency) {
        this.currency = currency;
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}