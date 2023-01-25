package org.example;

public class CompanyCustomer extends Customer {
    public CompanyCustomer(String name, String email, Account account, double companyOverDraft) {
        super(name, email, account, companyOverDraft);
    }

    protected double calculateMoneyFor(Account account, double sum) {
        if (account.getType().isPremium()) {
            this.companyOverdraftDiscount /= 2;
        }

        if (account.getAccountState().getMoney() < 0) {
            return (account.getAccountState().getMoney() - sum) - sum * account.overdraftFee() * this.companyOverdraftDiscount;
        }

        return account.getAccountState().getMoney() - sum;
    }
}
