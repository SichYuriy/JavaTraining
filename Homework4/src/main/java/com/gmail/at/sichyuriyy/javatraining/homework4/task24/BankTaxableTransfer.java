package com.gmail.at.sichyuriyy.javatraining.homework4.task24;

/**
 * Created by Yuriy on 3/11/2017.
 */
public class BankTaxableTransfer extends Transfer {

    private Bank bank;
    private Double bankTax;

    public BankTaxableTransfer(Transfer transfer, Bank bank) {
        super(transfer);
        this.bank = bank;
        bankTax = bank.getBankTax();
    }

    @Override
    public void makeTransfer(long accountFrom, long accountTo, double moneyAmount) {
        bank.decreaseMoneyAmount(accountFrom, moneyAmount * bankTax);
        moneyAmount *= (1 - bankTax);
        super.makeTransfer(accountFrom, accountTo, moneyAmount);
    }
}
