package com.gmail.at.sichyuriyy.javatraining.labwork1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Yuriy on 15.02.2017.
 */
public class Apartment {

    private List<Appliance> appliances = new ArrayList<>();

    public void addAppliance(Appliance appliance) {
        if (!appliances.contains(appliance)) {
            appliances.add(appliance);
        }
    }

    public List<Appliance> getAppliances() {
        return appliances;
    }

    public List<Appliance> sortByPower() {
        appliances.sort(Comparator.comparingInt(Appliance::getPower));
        return  appliances;
    }

    public List<Appliance> findByPower(int powerFrom, int powerTo) {
        return appliances.stream()
                .filter(app -> app.getPower() >= powerFrom && app.getPower() <= powerTo)
                .collect(Collectors.toList());
    }

    public int getPowerOfTurnedDevices() {
        return appliances.stream()
                .filter(Appliance::isTurned)
                .map(Appliance::getPower)
                .reduce(0, (a, b) -> a + b);
    }

}
