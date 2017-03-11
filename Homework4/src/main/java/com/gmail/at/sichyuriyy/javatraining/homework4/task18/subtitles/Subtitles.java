package com.gmail.at.sichyuriyy.javatraining.homework4.task18.subtitles;

import com.gmail.at.sichyuriyy.javatraining.homework4.task18.Language;

/**
 * Created by Yuriy on 3/10/2017.
 */
public abstract class Subtitles {

    private Language language;
    private String data;

    public Subtitles(Language language, String data) {
        this.language = language;
        this.data = data;
    }

    public Language getLanguage() {
        return language;
    }

    public String getData() {
        return data;
    }
}
