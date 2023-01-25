package org.example;

public class Main {
    public static void main(String[] args) {
        PersonCustomer personCustomer = new PersonCustomer("Oleksandr", "Kryvodub", "777@gmail.com", new Account());
        System.out.println(personCustomer.getFullName());
    }
}