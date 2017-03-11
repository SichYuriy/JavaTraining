package com.gmail.at.sichyuriyy.javatraining.homework4.task18;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class FilmServiceTest {

    FilmService filmService = new FilmService();

    @Test
    public void getUkrainianFilm() {
        Film film = filmService.getFilm("film1", Language.UKRAINIAN);
        assertEquals( Language.UKRAINIAN, film.getAudio().getLanguage());
        assertEquals( Language.UKRAINIAN, film.getSubtitles().getLanguage());
    }

    @Test
    public void getEnglishFilm() {
        Film film = filmService.getFilm("film1", Language.ENGLISH);
        assertEquals(Language.ENGLISH, film.getAudio().getLanguage());
        assertEquals(Language.ENGLISH, film.getSubtitles().getLanguage());
    }

}