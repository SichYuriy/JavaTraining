package com.gmail.at.sichyuriyy.javatraining.labwork2.textparser.impl;

import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Sentence;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Text;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.impl.PunctuationImpl;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.impl.SentenceImpl;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.impl.TextImpl;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.impl.WordImpl;

/**
 * Created by Yuriy on 28.02.2017.
 */
public class TestData {

    public static TestData getTextExample() {
        TestData testData = new TestData();
        testData.stringValue = "Text example... The(hi), end!";
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

    public String stringValue;
    public Text expectedText;
    public String fileName;


}
