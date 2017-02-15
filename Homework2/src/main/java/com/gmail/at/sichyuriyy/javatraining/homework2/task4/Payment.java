package com.gmail.at.sichyuriyy.javatraining.homework2.task4;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yuriy on 14.02.2017.
 */
public class Payment {

    Map<Product, PaymentRecord> products;

    public Payment() {
        products = new HashMap<>();
    }

    void addProduct(Product product, int count) {
        if (product == null || count <= 0) {
            throw new IllegalArgumentException();
        }
        PaymentRecord paymentRecord = products.get(product);
        if (paymentRecord == null) {
            products.put(product, new PaymentRecord(product, count));
        } else {
            paymentRecord.addCount(count);
        }
    }

    void removeProduct(Product product) {
        products.remove(product);
    }

    int getTotalPrice() {
        int totalPrice = 0;
        for (PaymentRecord paymentRecord: products.values()) {
            totalPrice += paymentRecord.getTotalPrice();
        }
        return totalPrice;
    }

    private class PaymentRecord {

        Product product;
        int count;
        int totalPrice;

        public PaymentRecord(Product product, int count) {
            this.product = product;
            this.count = count;
            totalPrice = product.getPrice() * count;
        }

        int getTotalPrice() {
            return totalPrice;
        }

        void addCount(int count) {
            this.count += count;
            totalPrice += product.getPrice() * count;

        }

    }

}
