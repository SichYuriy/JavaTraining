package com.gmail.at.sichyuriyy.javatraining.homework4.task18.audiosubtitlesfactory;

import com.gmail.at.sichyuriyy.javatraining.homework4.task18.audio.Audio;
import com.gmail.at.sichyuriyy.javatraining.homework4.task18.audio.UkrainianAudio;
import com.gmail.at.sichyuriyy.javatraining.homework4.task18.subtitles.Subtitles;
import com.gmail.at.sichyuriyy.javatraining.homework4.task18.subtitles.UkrainianSubtitles;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class UkrainianAudioSubtitlesFactory extends AudioSubtitlesFactory {

    @Override
    public Audio getAudio(String filmName) {
        return new UkrainianAudio(filmName + " ukrainian audio");
    }

    @Override
    public Subtitles getSubtitles(String filmName) {
        return new UkrainianSubtitles(filmName + " ukrainian subtitles");
    }
}
