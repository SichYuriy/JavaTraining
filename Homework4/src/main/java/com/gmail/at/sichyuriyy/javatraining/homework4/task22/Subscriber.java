package com.gmail.at.sichyuriyy.javatraining.homework4.task22;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class Subscriber {

    private List<Edition> library;
    private String name;

    public Subscriber(String name) {
        this.name = name;
        library = new ArrayList<>();
    }

    public void update(Edition edition) {
        System.out.println(name + ": Hooray! I have just received new edition of " +
                edition.getSubscriptionSubject().getName());
        library.add(edition);
    }

    public String getName() {
        return name;
    }

    public List<Edition> getLibrary() {
        return library;
    }
}
