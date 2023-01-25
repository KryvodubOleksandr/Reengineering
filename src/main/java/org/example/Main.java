package org.example;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(true, 10);
        PersonCustomer personCustomer = new PersonCustomer("Oleksandr", "Kryvodub", "777@gmail.com", account);
        System.out.println(personCustomer.getFullName());
    }
}