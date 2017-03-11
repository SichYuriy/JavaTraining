package com.gmail.at.sichyuriyy.javatraining.homework4.task22;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class Main {

    public static void main(String[] args) {
        Magazine magazine = new Magazine("magazine1");
        Newspaper newspaper = new Newspaper("newspaper1");

        PostOffice postOffice = new PostOffice();

        Subscriber yuriy = new Subscriber("Yuriy");
        Subscriber sergiy = new Subscriber("Sergiy");

        magazine.addSubscriber(yuriy);
        magazine.addSubscriber(sergiy);

        newspaper.addSubscriber(sergiy);

        postOffice.sendToSubscribers(new Edition(magazine, "edition1"));
        System.out.println();
        postOffice.sendToSubscribers(new Edition(newspaper, "edition1"));
        System.out.println();
        postOffice.sendToSubscribers(new Edition(magazine, "edition2"));

    }
}
