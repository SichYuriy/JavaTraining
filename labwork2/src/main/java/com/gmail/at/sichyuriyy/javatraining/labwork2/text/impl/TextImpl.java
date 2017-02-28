package com.gmail.at.sichyuriyy.javatraining.labwork2.text.impl;

import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Letter;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Sentence;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Text;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuriy on 28.02.2017.
 */
public class TextImpl implements Text {

    private List<Sentence> sentences;

    public TextImpl() {
        sentences = new ArrayList<>();
    }

    @Override
    public String getStringValue() {
        StringBuilder result = new StringBuilder();
        for (Sentence sentence: sentences) {
            result.append(sentence.getStringValue()).append(" ");
        }
        return result.substring(0, result.length() - 1);
    }

    @Override
    public List<Sentence> getSentences() {
        return new ArrayList<>(sentences);
    }

    @Override
    public List<Word> sortWordsByLetterCount(Letter letter) {
        if (letter == null) {
            throw new IllegalArgumentException();
        }
        List<Word> result = new ArrayList<>();
        for (Sentence sentence: sentences) {
            result.addAll(sentence.getWords());
        }
        result.sort((word1, word2) -> {
            int cmp = word1.letterCount(letter) - word1.letterCount(letter);
            if (cmp != 0) {
                return cmp;
            }
            return word1.getStringValue().compareTo(word2.getStringValue());
        });
        return result;
    }


    @Override
    public List<Word> sortWordsByLetterCount(char letter) {
        return sortWordsByLetterCount(new LetterImpl(letter));
    }

    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextImpl)) return false;

        TextImpl text = (TextImpl) o;

        return sentences.equals(text.sentences);
    }

    @Override
    public int hashCode() {
        return sentences.hashCode();
    }
}
