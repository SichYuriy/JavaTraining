package com.gmail.at.sichyuriyy.javatraining.labwork2.textparser.impl;

import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Text;
import com.gmail.at.sichyuriyy.javatraining.labwork2.textparser.TextParser;
import java.io.File;
import java.io.IOException;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

/**
 * Created by Yuriy on 28.02.2017.
 */
public class TextParserImplTest {

    TextParser textParser = new TextParserImpl();


    @Test
    public void parseTextFromStringStructure() {
        TestData testData = TestData.getTextExample();
        String str = testData.stringValue;
        Text text = textParser.parseText(str);
        Text expected = testData.expectedText;
        assertEquals(expected, text);
    }

    @Test
    public void parseTextFromFileStructure() throws IOException{
        TestData testData = TestData.getTextExample();
        File file = new File(testData.fileName);
        Text text = textParser.parseText(file);
        Text expected = testData.expectedText;

        assertEquals(expected, text);
    }

    @Test
    public void parseTextString() {
        TestData testData = TestData.getTextExample();
        String str = testData.stringValue;
        Text text = textParser.parseText(str);
        assertEquals(str, text.getStringValue());
    }

    @Test
    public void parseTextCommaStart() {
        TestData testData = TestData.getTextWithCommaStart();
        String str = testData.stringValue;
        Text text = textParser.parseText(str);
        Text expected = testData.expectedText;
        assertEquals(expected, text);
    }

    @Test
    public void parseTextPointStart() {
        TestData testData = TestData.getTextWithPointStart();
        String str = testData.stringValue;
        Text text = textParser.parseText(str);
        Text expected = testData.expectedText;
        assertEquals(expected, text);
    }

    @Test
    public void parseTextWithEmptyEnd() {
        TestData testData = TestData.getTextWithEmptyEnd();
        String str = testData.stringValue;
        Text text = textParser.parseText(str);
        Text expected = testData.expectedText;
        assertEquals(expected, text);
    }

}