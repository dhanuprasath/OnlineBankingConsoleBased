package org.example.model;

public class Customer {
    private int customerId;
    private char pickup;
    private char drop;

    public Customer(char pickup, char drop,int customerId) {
        this.customerId = customerId;
        this.pickup = pickup;
        this.drop = drop;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public char getPickup() {
        return pickup;
    }

    public void setPickup(char pickup) {
        this.pickup = pickup;
    }

    public char getDrop() {
        return drop;
    }

    public void setDrop(char drop) {
        this.drop = drop;
    }
}
