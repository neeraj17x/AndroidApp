package com.neeraj.helloandroid;

public class Expense {

    private double amount;
    private String description;
    private String paymentType;
    private String date;

    public Expense(double amount, String description, String paymentType, String date) {
        this.amount = amount;
        this.description = description;
        this.paymentType = paymentType;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}