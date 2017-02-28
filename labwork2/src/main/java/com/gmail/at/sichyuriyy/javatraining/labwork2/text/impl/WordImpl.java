package com.gmail.at.sichyuriyy.javatraining.labwork2.text.impl;

import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Letter;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuriy on 28.02.2017.
 */
public class WordImpl implements Word {

    private List<Letter> letters;

    public WordImpl() {
        letters = new ArrayList<>();
    }

    public WordImpl(String word) {
        this();
        for (char symbol: word.toCharArray()) {
            letters.add(new LetterImpl(symbol));
        }
    }

    @Override
    public String getStringValue() {
        StringBuilder result = new StringBuilder();
        for (Letter letter: letters) {
            result.append(letter.getCharValue());
        }
        return result.toString();
    }

    @Override
    public int letterCount(Letter letter) {
        return letters.stream()
                .filter(temp -> temp.getCharValue() == letter.getCharValue())
                .mapToInt(temp -> 1)
                .sum();
    }

    public void addLetter(Letter letter) {
        letters.add(letter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WordImpl)) return false;

        WordImpl word = (WordImpl) o;

        return letters.equals(word.letters);
    }

    @Override
    public int hashCode() {
        return letters.hashCode();
    }
}
