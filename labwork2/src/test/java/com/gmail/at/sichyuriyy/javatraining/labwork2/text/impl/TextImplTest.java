package com.gmail.at.sichyuriyy.javatraining.labwork2.text.impl;

import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Text;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Word;
import com.gmail.at.sichyuriyy.javatraining.labwork2.textparser.TextParser;
import com.gmail.at.sichyuriyy.javatraining.labwork2.textparser.impl.TextParserImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 01.03.2017.
 */
public class TextImplTest {


    @Test
    public void sortWordsByLetterCount() {
        String str = "This is a text example. Lets check sorting by" +
                " letter 'e' count";
        TextParser textParser = new TextParserImpl();
        Text text = textParser.parseText(str);
        List<Word> actual = text.sortWordsByLetterCount('e');
        List<Word> expected = new ArrayList<>();
        expected.add(new WordImpl("This"));
        expected.add(new WordImpl("a"));
        expected.add(new WordImpl("by"));
        expected.add(new WordImpl("count"));
        expected.add(new WordImpl("is"));
        expected.add(new WordImpl("sorting"));

        expected.add(new WordImpl("Lets"));
        expected.add(new WordImpl("check"));
        expected.add(new WordImpl("e"));
        expected.add(new WordImpl("text"));

        expected.add(new WordImpl("example"));
        expected.add(new WordImpl("letter"));

        assertEquals(expected, actual);
    }

    @Test
    public void sortWordsByLetterCountEmptyText() throws Exception {
        String str = "";
        TextParser textParser = new TextParserImpl();
        Text text = textParser.parseText(str);
        List<Word> actual = text.sortWordsByLetterCount('w');

        assertTrue(actual.isEmpty());
    }
}