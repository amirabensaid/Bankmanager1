package com.example.springsecurity.controller.DTO;

public class AmountDto {

    private double amount;

    public AmountDto() {
    }

    public AmountDto(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
