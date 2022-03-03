package com.example.expensetrackingapplication;

import java.io.Serializable;
import java.util.ArrayList;

public class Expense implements Serializable {
    String expenseName;
    double expenseAmount;
    String expenseDate;
   String expenseCatogory;

    @Override
    public String toString() {
        return "Expense{" +
                "expenseName='" + expenseName + '\'' +
                ", expenseAmount='" + expenseAmount + '\'' +
                ", expenseDate='" + expenseDate + '\'' +
                ", expenseCatogory='" + expenseCatogory + '\'' +
                '}';
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getExpenseCatogory() {
        return expenseCatogory;
    }

    public void setExpenseCatogory(String expenseCatogory) {
        this.expenseCatogory = expenseCatogory;
    }

    public Expense(String expenseName, double expenseAmount, String expenseDate, String expenseCatogory) {
        this.expenseName = expenseName;
        this.expenseAmount = expenseAmount;
        this.expenseDate = expenseDate;
        this.expenseCatogory = expenseCatogory;
    }
}
