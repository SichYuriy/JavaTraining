package com.gmail.at.sichyuriyy.javatraining.homework4.task26;

/**
 * Created by Yuriy on 3/11/2017.
 */
public class Bacterium {

    public static Bacterium createBacterium(Type type, BacteriumDataFactory factory) {
        return new Bacterium(type, factory.createBacteriumData(type));
    }

    private Type type;
    private String bigData;

    private Bacterium(Type type, String bigData) {
        this.type = type;
        this.bigData = bigData;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getBigData() {
        return bigData;
    }

    public void setBigData(String bigData) {
        this.bigData = bigData;
    }
}
