package com.gmail.at.sichyuriyy.javatraining.labwork1;

/**
 * Created by Yuriy on 15.02.2017.
 */
public class CoffeeMachine extends Appliance {

    private static final String WORK_SUCCESS = "Coffee making in process";
    private static final String WORK_FAIL = "Coffee machine is unable to work without being turned on";

    private CoffeeMachine(int power, int weight) {
        super(power, weight);
    }

    public static CoffeeMachine getCoffeeMachine(int power, int weight) {
        validateApplianceProperties(power, weight);
        return new CoffeeMachine(power, weight);
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
        return "CoffeeMachine{power:" + getPower() + ", weight:" + getWeight()
                + ", turned:" + isTurned() + "}";
    }
}
