package org.example;

public class Customer {
    private String name;
    private String surname;
    private String email;
    private CustomerType customerType;
    private Account account;
    private double companyOverdraftDiscount = 1;

    public Customer(String name, String surname, String email, CustomerType customerType, Account account) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.customerType = customerType;
        this.account = account;
    }

    // use only to create companies
    public Customer(String name, String email, Account account, double companyOverdraftDiscount) {
        this.name = name;
        this.email = email;
        this.customerType = CustomerType.COMPANY;
        this.account = account;
        this.companyOverdraftDiscount = companyOverdraftDiscount;
    }

    private void calculate(double sum, double multiplicator) {
        if (account.getMoney() < 0) {
            account.setMoney((account.getMoney() - sum) - sum * multiplicator);
        } else {
            account.setMoney(account.getMoney() - sum);
        }
    }

    public void withdraw(double sum, String currency) {
        if (!account.getCurrency().equals(currency)) {
            throw new RuntimeException("Can't extract withdraw " + currency);
        }
        if (account.getType().isPremium()) {
            switch (customerType) {
                case COMPANY:
                    calculate(sum, account.overdraftFee() * companyOverdraftDiscount / 2);
                    break;
                case PERSON:
                    calculate(sum, account.overdraftFee());
                    break;
            }
        } else {
            switch (customerType) {
                case COMPANY:
                    calculate(sum, account.overdraftFee() * companyOverdraftDiscount);
                    break;
                case PERSON:
                    calculate(sum, account.overdraftFee());
                    break;
            }
        }
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
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