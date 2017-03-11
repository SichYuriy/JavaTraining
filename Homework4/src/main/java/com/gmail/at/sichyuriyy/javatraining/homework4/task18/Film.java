package com.gmail.at.sichyuriyy.javatraining.homework4.task18;

import com.gmail.at.sichyuriyy.javatraining.homework4.task18.audio.Audio;
import com.gmail.at.sichyuriyy.javatraining.homework4.task18.subtitles.Subtitles;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class Film {

    private String name;
    private Audio audio;
    private Subtitles subtitles;

    public Film(String name, Audio audio, Subtitles subtitles) {
        this.name = name;
        this.audio = audio;
        this.subtitles = subtitles;
    }

    public String getName() {
        return name;
    }

    public Audio getAudio() {
        return audio;
    }

    public Subtitles getSubtitles() {
        return subtitles;
    }
}
