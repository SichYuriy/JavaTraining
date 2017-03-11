package com.gmail.at.sichyuriyy.javatraining.homework4.task24;

/**
 * Created by Yuriy on 3/11/2017.
 */
public class FixedTransfer extends Transfer {

    private Bank bank;

    public FixedTransfer(Transfer transfer, Bank bank) {
        super(transfer);
        this.bank = bank;
    }

    @Override
    public void makeTransfer(long accountFrom, long accountTo, double moneyAmount) {
        bank.decreaseMoneyAmount(accountFrom, moneyAmount);
        bank.increaseMoneyAmount(accountTo, moneyAmount);
        super.makeTransfer(accountFrom, accountTo, moneyAmount);
    }
}
