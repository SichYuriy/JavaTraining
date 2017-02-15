package com.gmail.at.sichyuriyy.javatraining.homework2.task4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 14.02.2017.
 */
public class PaymentTest {

    @Test
    public void addProduct() throws Exception {
        Product product1 = new Product("product1", 10);
        Product product2 = new Product("product2", 20);
        Payment payment = new Payment();
        payment.addProduct(product1, 2);
        payment.addProduct(product2, 1);
        payment.addProduct(product2, 1);
        int expectedTotalPrice = 60;
        int actualTotalPrice = payment.getTotalPrice();
        assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    @Test
    public void removeProduct() throws Exception {
        Product product1 = new Product("product1", 10);
        Product product2 = new Product("product2", 20);
        Payment payment = new Payment();
        payment.addProduct(product1, 2);
        payment.addProduct(product2, 1);
        payment.removeProduct(product1);
        int expectedTotalPrice = 20;
        int actualTotalPrice = payment.getTotalPrice();
        assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addProductNull() throws Exception {

        Payment payment = new Payment();
        payment.addProduct(null, 2);
    }
}