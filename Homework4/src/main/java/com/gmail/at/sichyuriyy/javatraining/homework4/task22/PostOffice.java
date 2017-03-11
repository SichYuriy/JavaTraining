package com.gmail.at.sichyuriyy.javatraining.homework4.task22;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class PostOffice {

    public void sendToSubscribers(Edition edition) {
        for (Subscriber subscriber: edition.getSubscriptionSubject().getSubscribers()) {
            subscriber.update(edition);
        }
    }
}
