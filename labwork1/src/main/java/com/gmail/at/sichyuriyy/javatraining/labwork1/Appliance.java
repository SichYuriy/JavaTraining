package com.gmail.at.sichyuriyy.javatraining.labwork1;

/**
 * Created by Yuriy on 15.02.2017.
 */
public abstract class Appliance {

    private int power;
    private boolean turned;
    private int weight;

    public Appliance(int power, int weight) {
        this.power = power;
        this.weight = weight;
    }

    public abstract String work();

    public void turnOn() {
        turned = true;
    }

    public void turnOf() {
        turned = false;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isTurned() {
        return turned;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    protected static void validateApplianceProperties(int power, int weight) {
        if (power < 0 || weight < 0) {
            throw new IllegalArgumentException();
        }
    }
}
