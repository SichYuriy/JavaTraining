package com.gmail.at.sichyuriyy.javatraining.labwork2.text;

import java.util.List;

/**
 * Created by Yuriy on 28.02.2017.
 */
public interface Text {

    String getStringValue();

    List<Sentence> getSentences();

    List<Word> sortWordsByLetterCount(Letter letter);
    List<Word> sortWordsByLetterCount(char letter);

}
