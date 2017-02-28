package com.gmail.at.sichyuriyy.javatraining.labwork2.text;

import java.util.List;

/**
 * Created by Yuriy on 28.02.2017.
 */
public interface Sentence {

    List<Word> getWords();
    List<SentencePart> getParts();

    String getStringValue();
}
