package com.gmail.at.sichyuriyy.javatraining.homework4.task18;

import com.gmail.at.sichyuriyy.javatraining.homework4.task18.audio.Audio;
import com.gmail.at.sichyuriyy.javatraining.homework4.task18.audiosubtitlesfactory.AudioSubtitlesFactory;
import com.gmail.at.sichyuriyy.javatraining.homework4.task18.audiosubtitlesfactory.EnglishAudioSubtitlesFactory;
import com.gmail.at.sichyuriyy.javatraining.homework4.task18.audiosubtitlesfactory.UkrainianAudioSubtitlesFactory;
import com.gmail.at.sichyuriyy.javatraining.homework4.task18.subtitles.Subtitles;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class FilmService {

    Map<Language, AudioSubtitlesFactory> audioSubtitlesFactoryMap;

    public FilmService() {
        audioSubtitlesFactoryMap = new HashMap<>();
        audioSubtitlesFactoryMap.put(Language.ENGLISH, new EnglishAudioSubtitlesFactory());
        audioSubtitlesFactoryMap.put(Language.UKRAINIAN, new UkrainianAudioSubtitlesFactory());
    }

    public Film getFilm(String name, Language language) {
        Subtitles subtitles = audioSubtitlesFactoryMap.get(language).getSubtitles(name);
        Audio audio = audioSubtitlesFactoryMap.get(language).getAudio(name);
        return new Film(name, audio, subtitles);
    }
}
