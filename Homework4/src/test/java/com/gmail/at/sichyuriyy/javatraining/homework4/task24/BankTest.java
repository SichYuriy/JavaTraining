package com.gmail.at.sichyuriyy.javatraining.homework4.task24;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 3/11/2017.
 */
public class BankTest {

    private static final double DELTA = 10e-7;

    private Bank bank;
    private long accountFrom = 1;
    private long accountTo = 2;

    private long accountFromMoneyAmount = 100;
    private long accountToMoneyAmount = 0;

    @Before
    public void setUp() {
        bank = new Bank();
        bank.createAccount(accountFrom, accountFromMoneyAmount);
        bank.createAccount(accountTo, accountToMoneyAmount);
    }

    @Test
    public void makeNormalTransfer() {
        double moneyAmount = 100;
        bank.makeNormalTransfer(accountFrom, accountTo, moneyAmount);

        double expectedAccountFromMoneyAmount = 0;
        double expectedAccountToMoneyAmount = 97.02;
        assertEquals(expectedAccountFromMoneyAmount, bank.getMoneyAmount(accountFrom), DELTA);
        assertEquals(expectedAccountToMoneyAmount, bank.getMoneyAmount(accountTo), DELTA);
    }

    @Test
    public void makeBankTransfer() {
        double moneyAmount = 100;
        bank.makeBankTransfer(accountFrom, accountTo, moneyAmount);

        double expectedAccountFromMoneyAmount = 0;
        double expectedAccountToMoneyAmount = 100;

        assertEquals(expectedAccountFromMoneyAmount, bank.getMoneyAmount(accountFrom), DELTA);
        assertEquals(expectedAccountToMoneyAmount, bank.getMoneyAmount(accountTo), DELTA);
    }

    @Test
    public void makeGovernmentalTransfer() {
        double moneyAmount = 100;
        bank.makeGovernmentalTransfer(accountFrom, accountTo, moneyAmount);

        double expectedAccountFromMoneyAmount = 0;
        double expectedAccountToMoneyAmount = 99;

        assertEquals(expectedAccountFromMoneyAmount, bank.getMoneyAmount(accountFrom), DELTA);
        assertEquals(expectedAccountToMoneyAmount, bank.getMoneyAmount(accountTo), DELTA);
    }

    @Test
    public void makeSpecialTransfer() {
        double moneyAmount = 100;
        bank.makeSpecialTransfer(accountFrom, accountTo, moneyAmount);

        double expectedAccountFromMoneyAmount = 0;
        double expectedAccountToMoneyAmount = 98;

        assertEquals(expectedAccountFromMoneyAmount, bank.getMoneyAmount(accountFrom), DELTA);
        assertEquals(expectedAccountToMoneyAmount, bank.getMoneyAmount(accountTo), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void makeTransferIllegalAccount() {
        long illegalAccount = 3;
        bank.makeSpecialTransfer(illegalAccount, accountTo, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void makeTransferIllegalMoneyAmount() {
        long illegalMoneyAmount = 103;
        bank.makeSpecialTransfer(accountFrom, accountTo, illegalMoneyAmount);
    }
}