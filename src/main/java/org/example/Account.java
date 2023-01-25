package org.example;

public class Account {

    private String iban;

    private AccountType type;

    private int daysOverdrawn;

    private Customer customer;

    private AccountState accountState;

    public AccountState getAccountState() {
        return accountState;
    }

    public void setAccountState(AccountState accountState) {
        this.accountState = accountState;
    }

    public Account(boolean isPremiumAccount, int daysOverdrawn) {
        super();
        this.type = new AccountType(isPremiumAccount);
        this.daysOverdrawn = daysOverdrawn;
    }

    public double bankcharge() {
        double result = 4.5;

        result += overdraftCharge();

        return result;
    }

    private double overdraftCharge() {
        if (type.isPremium()) {
            double result = 10;
            if (getDaysOverdrawn() > 7)
                result += (getDaysOverdrawn() - 7) * 1.0;
            return result;
        } else
            return getDaysOverdrawn() * 1.75;
    }

    public double overdraftFee() {
        if (type.isPremium()) {
            return 0.10;
        } else {
            return 0.20;
        }
    }

    public int getDaysOverdrawn() {
        return daysOverdrawn;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AccountType getType() {
        return type;
    }

    public String printCustomer() {
        return customer.getName() + " " + customer.getEmail();
    }

    public String printCustomerDaysOverdrawn(String fullName) {
        String accountDescription = "Account: IBAN: " + getIban() + ", Days Overdrawn: " + getDaysOverdrawn();
        return fullName + accountDescription;
    }

    public String printCustomerMoney(String fullName) {
        String accountDescription = "Account: IBAN: " + getIban() + ", Money: " + getAccountState().getMoney();
        return fullName + accountDescription;
    }

    public String printCustomerAccount() {
        return "Account: IBAN: " + getIban() + ", Money: " + getAccountState().getMoney() + ", Account type: " + getType();
    }

    public static class AccountType {
        private boolean premium;

        AccountType(boolean premium) {
            this.premium = premium;
        }

        public boolean isPremium() {
            return premium;
        }

        @Override
        public String toString() {
            return premium ? "premium" : "normal";
        }
    }
}