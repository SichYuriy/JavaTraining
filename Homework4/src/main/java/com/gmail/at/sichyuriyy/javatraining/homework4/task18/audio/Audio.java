package com.gmail.at.sichyuriyy.javatraining.homework4.task18.audio;

import com.gmail.at.sichyuriyy.javatraining.homework4.task18.Language;

/**
 * Created by Yuriy on 3/10/2017.
 */
public abstract class Audio {

    private Language language;
    private String data;

    public Audio(Language language, String data) {
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
