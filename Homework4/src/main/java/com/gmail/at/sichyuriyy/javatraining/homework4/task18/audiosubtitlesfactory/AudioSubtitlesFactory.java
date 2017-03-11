package com.gmail.at.sichyuriyy.javatraining.homework4.task18.audiosubtitlesfactory;

import com.gmail.at.sichyuriyy.javatraining.homework4.task18.audio.Audio;
import com.gmail.at.sichyuriyy.javatraining.homework4.task18.audio.EnglishAudio;
import com.gmail.at.sichyuriyy.javatraining.homework4.task18.subtitles.EnglishSubtitles;
import com.gmail.at.sichyuriyy.javatraining.homework4.task18.subtitles.Subtitles;

/**
 * Created by Yuriy on 3/10/2017.
 */
public abstract class AudioSubtitlesFactory {

    public Audio getAudio(String filmName) {
        return new EnglishAudio(filmName + " english audio");
    }

    public Subtitles getSubtitles(String filmName) {
        return new EnglishSubtitles(filmName + "english subtitles");
    }
}
