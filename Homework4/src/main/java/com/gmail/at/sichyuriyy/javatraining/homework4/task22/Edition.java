package com.gmail.at.sichyuriyy.javatraining.homework4.task22;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class Edition {

   private SubscriptionSubject subscriptionSubject;
   private String data;

    public Edition(SubscriptionSubject subscriptionSubject, String data) {
        this.subscriptionSubject = subscriptionSubject;
        this.data = data;
    }

    public SubscriptionSubject getSubscriptionSubject() {
        return subscriptionSubject;
    }

    public String getData() {
        return data;
    }
}
