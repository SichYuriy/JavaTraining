package com.gmail.at.sichyuriyy.javatraining.homework4.task26;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yuriy on 3/11/2017.
 */
public class BacteriumDataFactory {

    private Map<Type, String> typeDataMap = new HashMap<>();

    public String createBacteriumData(Type type) {
        if (!typeDataMap.containsKey(type)) {
            String data = Database.getInstance().getData(type);
            typeDataMap.put(type, data);
        }
        return typeDataMap.get(type);
    }
}
