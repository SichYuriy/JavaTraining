package com.gmail.at.sichyuriyy.javatraining.labwork2.textparser.impl;

import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Text;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.impl.PunctuationImpl;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.impl.SentenceImpl;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.impl.TextImpl;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.impl.WordImpl;

/**
 * Created by Yuriy on 28.02.2017.
 */
class TestData {

    private static final String TEXT_EXAMPLE = "Text example... The(hi), end!";
    private static final String TEXT_WITH_COMMA_START = ",. , , begin. ,end.";
    private static final String TEXT_WITH_POINT_START = ". a . end.";
    private static final String TEXT_WITH_EMPTY_END = "Word";

    static TestData getTextExample() {
        TestData testData = new TestData();
        testData.stringValue = TEXT_EXAMPLE;
        testData.fileName = "test.txt";
        TextImpl text = new TextImpl();
        SentenceImpl sentence1 = new SentenceImpl();
        sentence1.addWord(new WordImpl("Text"));
        sentence1.addPunctuation(new PunctuationImpl(' '));
        sentence1.addWord(new WordImpl("example"));
        sentence1.addPunctuation(new PunctuationImpl('.'));
        sentence1.addPunctuation(new PunctuationImpl('.'));
        sentence1.addPunctuation(new PunctuationImpl('.'));
        SentenceImpl sentence2 = new SentenceImpl();
        sentence2.addWord(new WordImpl("The"));
        sentence2.addPunctuation(new PunctuationImpl('('));
        sentence2.addWord(new WordImpl("hi"));
        sentence2.addPunctuation(new PunctuationImpl(')'));
        sentence2.addPunctuation(new PunctuationImpl(','));
        sentence2.addPunctuation(new PunctuationImpl(' '));
        sentence2.addWord(new WordImpl("end"));
        sentence2.addPunctuation(new PunctuationImpl('!'));
        text.addSentence(sentence1);
        text.addSentence(sentence2);
        testData.expectedText = text;
        return  testData;
    }

    static TestData getTextWithCommaStart() {
        TestData testData = new TestData();
        testData.stringValue = TEXT_WITH_COMMA_START;
        TextImpl text = new TextImpl();
        SentenceImpl sentence1 = new SentenceImpl();
        sentence1.addPunctuation(new PunctuationImpl(','));
        sentence1.addPunctuation(new PunctuationImpl('.'));
        SentenceImpl sentence2 = new SentenceImpl();
        sentence2.addPunctuation(new PunctuationImpl(','));
        sentence2.addPunctuation(new PunctuationImpl(' '));
        sentence2.addPunctuation(new PunctuationImpl(','));
        sentence2.addPunctuation(new PunctuationImpl(' '));
        sentence2.addWord(new WordImpl("begin"));
        sentence2.addPunctuation(new PunctuationImpl('.'));
        SentenceImpl sentence3 = new SentenceImpl();
        sentence3.addPunctuation(new PunctuationImpl(','));
        sentence3.addWord(new WordImpl("end"));
        sentence3.addPunctuation(new PunctuationImpl('.'));
        text.addSentence(sentence1);
        text.addSentence(sentence2);
        text.addSentence(sentence3);
        testData.expectedText = text;
        return testData;
    }

    static TestData getTextWithPointStart() {
        TestData testData = new TestData();
        testData.stringValue = TEXT_WITH_POINT_START;
        TextImpl text = new TextImpl();
        SentenceImpl sentence1 = new SentenceImpl();
        sentence1.addPunctuation(new PunctuationImpl('.'));
        SentenceImpl sentence2 = new SentenceImpl();
        sentence2.addWord(new WordImpl("a"));
        sentence2.addPunctuation(new PunctuationImpl(' '));
        sentence2.addPunctuation(new PunctuationImpl('.'));
        SentenceImpl sentence3 = new SentenceImpl();
        sentence3.addWord(new WordImpl("end"));
        sentence3.addPunctuation(new PunctuationImpl('.'));
        text.addSentence(sentence1);
        text.addSentence(sentence2);
        text.addSentence(sentence3);
        testData.expectedText = text;
        return testData;
    }

    static TestData getTextWithEmptyEnd() {
        TestData testData = new TestData();
        testData .stringValue = TEXT_WITH_EMPTY_END;
        TextImpl text = new TextImpl();
        SentenceImpl sentence = new SentenceImpl();
        sentence.addWord(new WordImpl("Word"));
        text.addSentence(sentence);
        testData.expectedText = text;
        return testData;
    }

    String stringValue;
    Text expectedText;
    String fileName;


}
