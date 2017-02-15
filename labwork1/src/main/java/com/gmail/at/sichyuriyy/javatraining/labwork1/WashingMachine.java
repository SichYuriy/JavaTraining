package com.gmail.at.sichyuriyy.javatraining.labwork1;

/**
 * Created by Yuriy on 15.02.2017.
 */
public class WashingMachine extends Appliance {

    private static final String WORK_SUCCESS = "Clothe washing in process";
    private static final String WORK_FAIL = "Washing machine is unable to work without being turned on";

    private WashingMachine(int power, int weight) {
        super(power, weight);
    }

    public static WashingMachine getWashingMachine(int power, int weight) {
        validateApplianceProperties(power, weight);
        return new WashingMachine(power, weight);
    }

    @Override
    public String work() {
        if(isTurned()) {
            return WORK_SUCCESS;
        } else {
            return WORK_FAIL;
        }
    }

    @Override
    public String toString() {
        return "WashingMachine{power:" + getPower() + ", weight:" + getWeight()
                + ", turned:" + isTurned() + "}";
    }
}
