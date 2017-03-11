package com.gmail.at.sichyuriyy.javatraining.homework4.task24;

/**
 * Created by Yuriy on 3/10/2017.
 */
public abstract class Transfer {

    private Transfer transfer;

    public Transfer(Transfer transfer) {
        this.transfer = transfer;
    }

    public void makeTransfer(long accountFrom, long accountTo, double moneyAmount) {
        if (transfer != null) {
            transfer.makeTransfer(accountFrom, accountTo, moneyAmount);
        }
    }
}
