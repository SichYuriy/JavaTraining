package com.gmail.at.sichyuriyy.javatraining.homework4.task19;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuriy on 3/9/2017.
 */
public class Article {

    private String name;
    private List<String> parts;

    public Article(String name) {
        this.name = name;
        parts = new ArrayList<>();
    }

    public Article(String name, List<String> parts) {
        this.name = name;
        this.parts = new ArrayList<>(parts);
    }

    public String getName() {
        return name;
    }

    public List<String> getParts() {
        return new ArrayList<>(parts);
    }

    public void addPart(String part) {
        parts.add(part);
    }

    public void removePart(int index) {
        parts.remove(index);
    }

    public void clear() {
        parts.clear();
    }

    public Article cloneArticle() {
        return new Article(name, parts);
    }
}
