package com.gmail.at.sichyuriyy.javatraining.homework4.task22;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuriy on 3/10/2017.
 */
public abstract class SubscriptionSubject {

    private String name;
    private List<Subscriber> subscribers;

    public SubscriptionSubject(String name) {
        this.name = name;
        subscribers = new ArrayList<>();
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public String getName() {
        return name;
    }
}
