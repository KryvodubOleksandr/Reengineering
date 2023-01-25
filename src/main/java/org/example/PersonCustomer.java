package org.example;

public class PersonCustomer extends Customer {
    public PersonCustomer(String name, String surname, String email, Account account) {
        super(name, surname, email, account);
    }


    protected double calculateMoneyFor(Account account, double sum) {
        if (account.getAccountState().getMoney() < 0) {
            return (account.getAccountState().getMoney() - sum) - sum * account.overdraftFee();
        }

        return account.getAccountState().getMoney() - sum;
    }
}