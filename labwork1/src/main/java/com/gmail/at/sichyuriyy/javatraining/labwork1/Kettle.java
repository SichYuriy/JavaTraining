package com.gmail.at.sichyuriyy.javatraining.labwork1;

/**
 * Created by Yuriy on 15.02.2017.
 */
public class Kettle extends Appliance {

    private static final String WORK_SUCCESS = "Kettle is working";
    private static final String WORK_FAIL = "Kettle is unable to work without being turned on";

    private Kettle(int power, int weight) {
        super(power, weight);
    }

    public static Kettle getKettle(int power, int weight) {
        validateApplianceProperties(power, weight);
        return new Kettle(power, weight);
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
        return "Kettle{power:" + getPower() + ", weight:" + getWeight()
                + ", turned:" + isTurned() + "}";
    }
}
