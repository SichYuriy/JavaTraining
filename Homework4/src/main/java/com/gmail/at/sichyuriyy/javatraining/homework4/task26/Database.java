package com.gmail.at.sichyuriyy.javatraining.homework4.task26;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yuriy on 3/11/2017.
 */
public class Database {
    private static Database ourInstance = new Database();

    public static Database getInstance() {
        return ourInstance;
    }

    private Map<Type, String> typeDataMap = new HashMap<>();

    private Database() {
        typeDataMap.put(Type.TYPE1, "type1 inf");
        typeDataMap.put(Type.TYPE2, "type2 inf");
        typeDataMap.put(Type.TYPE3, "type3 inf");
        typeDataMap.put(Type.TYPE4, "type4 inf");
    }

    public String getData(Type type) {
        return typeDataMap.get(type);
    }
}
