package org.example;

public abstract class Customer {
    private String name;
    private String surname;
    private String email;
    private Account account;
    protected double companyOverdraftDiscount = 1;

    public Customer(String name, String surname, String email, Account account) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.account = account;
    }

    // use only to create companies
    public Customer(String name, String email, Account account, double companyOverdraftDiscount) {
        this.name = name;
        this.email = email;
        this.account = account;
        this.companyOverdraftDiscount = companyOverdraftDiscount;
    }

    protected abstract double calculateMoneyFor(Account account, double sum);

    public void withdraw(double sum, String currency) {
        if (!account.getCurrency().equals(currency)) {
            throw new RuntimeException("Can't extract withdraw " + currency);
        }

        account.setMoney(calculateMoneyFor(account, sum));
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return name + " " + surname + " ";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String printCustomerDaysOverdrawn() {
        String accountDescription = "Account: IBAN: " + account.getIban() + ", Days Overdrawn: " + account.getDaysOverdrawn();
        return getFullName() + accountDescription;
    }

    public String printCustomerMoney() {
        String accountDescription = "";
        accountDescription += "Account: IBAN: " + account.getIban() + ", Money: " + account.getMoney();
        return getFullName() + accountDescription;
    }

    public String printCustomerAccount() {
        return "Account: IBAN: " + account.getIban() + ", Money: "
                + account.getMoney() + ", Account type: " + account.getType();
    }
}