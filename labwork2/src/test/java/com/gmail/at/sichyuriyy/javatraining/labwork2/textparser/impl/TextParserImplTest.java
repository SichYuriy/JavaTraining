package com.gmail.at.sichyuriyy.javatraining.labwork2.textparser.impl;

import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Sentence;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Text;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.impl.SentenceImpl;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.impl.TextImpl;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.impl.WordImpl;
import com.gmail.at.sichyuriyy.javatraining.labwork2.textparser.TextParser;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 28.02.2017.
 */
public class TextParserImplTest {

    TestData testData = TestData.getTextExample();
    TextParser textParser = new TextParserImpl();

    @Test
    public void parseTextString() {
        String str = testData.stringValue;
        Text text = textParser.parseText(str);
        Text expected = testData.expectedText;
        assertEquals(expected, text);
        assertEquals(str, text.getStringValue());
    }

    @Test
    public void parseText1() throws Exception {

    }

}