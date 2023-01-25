package org.example;

public class PersonCustomer extends Customer {
    public PersonCustomer(String name, String surname, String email, Account account) {
        super(name, surname, email, account);
    }


    protected double calculateMoneyFor(Account account, double sum) {
        if (account.getMoney() < 0) {
            return (account.getMoney() - sum) - sum * account.overdraftFee();
        }

        return account.getMoney() - sum;
    }
}