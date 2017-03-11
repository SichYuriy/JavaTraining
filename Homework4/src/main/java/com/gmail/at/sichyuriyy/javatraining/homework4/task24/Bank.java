package com.gmail.at.sichyuriyy.javatraining.homework4.task24;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class Bank {

    private static final Double DEFAULT_BANK_TAX = 0.01;

    private Map<Long, Double> accountMoneyMap;

    private Transfer normalTransfer;
    private Transfer bankTransfer;
    private Transfer governmentalTransfer;
    private Transfer specialTransfer;

    private Double bankTax = DEFAULT_BANK_TAX;

    public Bank() {
        normalTransfer = new FixedTransfer(null, this);
        normalTransfer = new GovernmentTaxableTransfer(normalTransfer, this);
        normalTransfer = new BankTaxableTransfer(normalTransfer, this);
        normalTransfer = new CheckedTransfer(normalTransfer, this);

        bankTransfer = new FixedTransfer(null, this);
        bankTransfer = new CheckedTransfer(bankTransfer, this);

        governmentalTransfer = new FixedTransfer(null, this);
        governmentalTransfer = new BankTaxableTransfer(governmentalTransfer, this);
        governmentalTransfer = new CheckedTransfer(governmentalTransfer, this);

        specialTransfer = new FixedTransfer(null, this);
        specialTransfer = new GovernmentTaxableTransfer(specialTransfer, this);
        specialTransfer = new CheckedTransfer(specialTransfer, this);

        accountMoneyMap = new HashMap<>();
    }

    public void makeNormalTransfer(long accountFrom, long accountTo, double moneyAmount) {
        normalTransfer.makeTransfer(accountFrom, accountTo, moneyAmount);
    }

    public void makeBankTransfer(long accountFrom, long accountTo, double moneyAmount) {
        bankTransfer.makeTransfer(accountFrom, accountTo, moneyAmount);
    }

    public void makeGovernmentalTransfer(long accountFrom, long accountTo, double moneyAmount) {
        governmentalTransfer.makeTransfer(accountFrom, accountTo, moneyAmount);
    }

    public void makeSpecialTransfer(long accountFrom, long accountTo, double moneyAmount) {
        specialTransfer.makeTransfer(accountFrom, accountTo, moneyAmount);
    }

    public void createAccount(long account, double moneyAmount) {
        accountMoneyMap.put(account, moneyAmount);
    }

    public Double getMoneyAmount(long account) {
        return accountMoneyMap.get(account);
    }

    public boolean exists(long account) {
        return accountMoneyMap.containsKey(account);
    }

    protected void increaseMoneyAmount(long account, Double moneyAmount) {
        double oldValue = accountMoneyMap.get(account);
        accountMoneyMap.put(account, oldValue + moneyAmount);
    }

    protected void decreaseMoneyAmount(long account, Double moneyAmount) {
        double oldValue = accountMoneyMap.get(account);
        accountMoneyMap.put(account, oldValue - moneyAmount);
    }

    public Double getBankTax() {
        return bankTax;
    }
}
