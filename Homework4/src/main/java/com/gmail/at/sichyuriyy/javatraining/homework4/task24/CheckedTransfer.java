package com.gmail.at.sichyuriyy.javatraining.homework4.task24;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class CheckedTransfer extends Transfer {

    private Bank bank;

    public CheckedTransfer(Transfer parent, Bank bank) {
        super(parent);
        this.bank = bank;
    }

    @Override
    public void makeTransfer(long accountFrom, long accountTo, double moneyAmount) {
        if (!bank.exists(accountFrom)
                || !bank.exists(accountTo)) {
            throw new IllegalArgumentException("can not find account");
        }
        if (bank.getMoneyAmount(accountFrom) < moneyAmount || moneyAmount <= 0) {
            throw new IllegalArgumentException("not enough money");
        }

        super.makeTransfer(accountFrom, accountTo, moneyAmount);
    }
}
