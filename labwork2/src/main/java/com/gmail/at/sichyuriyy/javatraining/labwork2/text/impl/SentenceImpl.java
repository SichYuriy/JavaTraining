package com.gmail.at.sichyuriyy.javatraining.labwork2.text.impl;

import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Punctuation;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Sentence;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.SentencePart;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuriy on 28.02.2017.
 */
public class SentenceImpl implements Sentence {

    private List<SentencePart> parts;

    public SentenceImpl() {
        parts = new ArrayList<>();
    }

    @Override
    public List<Word> getWords() {
        List<Word> result = new ArrayList<>();
        for (SentencePart part: parts) {
            if (part.isWord()) {
                result.add((Word) part);
            }
        }
        return result;
    }

    @Override
    public List<SentencePart> getParts() {
        return new ArrayList<>(parts);
    }

    @Override
    public String getStringValue() {
        StringBuilder result = new StringBuilder();
        for (SentencePart part: parts) {
            result.append(part.getStringValue());
        }
        return result.toString();

    }

    public void addPunctuation(Punctuation punctuation) {
        parts.add(punctuation);
    }

    public void addWord(Word word) {
        parts.add(word);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SentenceImpl)) return false;

        SentenceImpl sentence = (SentenceImpl) o;

        if (!parts.equals(sentence.parts)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return parts.hashCode();
    }
}
