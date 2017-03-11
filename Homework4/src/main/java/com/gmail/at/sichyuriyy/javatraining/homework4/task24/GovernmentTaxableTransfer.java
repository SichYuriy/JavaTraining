package com.gmail.at.sichyuriyy.javatraining.homework4.task24;

/**
 * Created by Yuriy on 3/11/2017.
 */
public class GovernmentTaxableTransfer extends Transfer {

    private static final Double GOVERNMENT_TAX = 0.02;

    private Bank bank;

    public GovernmentTaxableTransfer(Transfer transfer, Bank bank) {
        super(transfer);
        this.bank = bank;
    }

    @Override
    public void makeTransfer(long accountFrom, long accountTo, double moneyAmount) {
        bank.decreaseMoneyAmount(accountFrom, moneyAmount * GOVERNMENT_TAX);
        moneyAmount *= (1 - GOVERNMENT_TAX);
        super.makeTransfer(accountFrom, accountTo, moneyAmount);
    }
}
