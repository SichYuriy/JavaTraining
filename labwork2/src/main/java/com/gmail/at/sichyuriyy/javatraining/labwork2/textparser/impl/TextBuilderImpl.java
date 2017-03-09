package com.gmail.at.sichyuriyy.javatraining.labwork2.textparser.impl;

import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Text;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.impl.*;

/**
 * Created by Yuriy on 28.02.2017.
 */
public class TextBuilderImpl implements TextBuilder {

    private static final char SPACE = ' ';
    private static final String END_PUNCTUATIONS = ".!?";

    private TextImpl text;
    private SentenceImpl tempSentence;
    private WordImpl tempWord;

    private State tempState;
    private boolean lastSpace;

    private final State newSentenceState = new NewSentenceState();
    private final State insideWordState = new InsideWordState();
    private final State afterSimplePunctuationState = new AfterSimplePunctuationState();
    private final State afterEndPunctuationState = new AfterEndPunctuationState();

    @Override
    public void createNewText() {
        text = new TextImpl();
        tempSentence = new SentenceImpl();
        tempState = newSentenceState;
    }

    @Override
    public void buildSymbol(char symbol) {
        if (isEndPunctuationSymbol(symbol)) {
            tempState.buildEndPunctuationSymbol(symbol);
            lastSpace = false;
        } else if (isWordLetter(symbol)) {
            tempState.buildWordSymbol(symbol);
            lastSpace = false;
        } else {
            tempState.buildSimplePunctuationSymbol(symbol);
            lastSpace = false;
        }
    }

    @Override
    public void buildSpace() {
        tempState.buildSpace();
        lastSpace = true;
    }

    @Override
    public void buildEndText() {
        tempState.buildEndText();
    }

    @Override
    public Text getText() {
        return text;
    }

    private boolean isEndPunctuationSymbol(char symbol) {
        return END_PUNCTUATIONS.indexOf(symbol) != -1;
    }

    private boolean isWordLetter(char symbol) {
        return Character.isAlphabetic(symbol);
    }

    private interface State{
        void buildWordSymbol(char symbol);
        void buildSimplePunctuationSymbol(char symbol);
        void buildEndPunctuationSymbol(char symbol);
        void buildSpace();
        void buildEndText();
    }

    private class NewSentenceState implements State {

        @Override
        public void buildWordSymbol(char symbol) {
            tempWord = new WordImpl();
            tempWord.addLetter(new LetterImpl(symbol));
            tempState = insideWordState;
        }

        @Override
        public void buildSimplePunctuationSymbol(char symbol) {
            tempSentence.addPunctuation(new PunctuationImpl(symbol));
            tempState = afterSimplePunctuationState;
        }

        @Override
        public void buildEndPunctuationSymbol(char symbol) {
            tempSentence.addPunctuation(new PunctuationImpl(symbol));
            tempState = afterEndPunctuationState;
        }

        @Override
        public void buildSpace() {
            // Do nothing because sentence can not have space as first symbol
        }


        @Override
        public void buildEndText() {
            // Do nothing because there is no sentences to add to text
        }
    }

    private class InsideWordState implements State {

        @Override
        public void buildWordSymbol(char symbol) {
            tempWord.addLetter(new LetterImpl(symbol));
        }

        @Override
        public void buildSimplePunctuationSymbol(char symbol) {
            tempSentence.addWord(tempWord);
            tempSentence.addPunctuation(new PunctuationImpl(symbol));
            tempState = afterSimplePunctuationState;
        }

        @Override
        public void buildEndPunctuationSymbol(char symbol) {
            tempSentence.addWord(tempWord);
            tempSentence.addPunctuation(new PunctuationImpl(symbol));
            tempState = afterEndPunctuationState;
        }

        @Override
        public void buildSpace() {
            tempSentence.addWord(tempWord);
            tempSentence.addPunctuation(new PunctuationImpl(SPACE));
            tempState = afterSimplePunctuationState;
        }

        @Override
        public void buildEndText() {
            tempSentence.addWord(tempWord);
            text.addSentence(tempSentence);
        }
    }

    private class AfterSimplePunctuationState implements State {

        @Override
        public void buildWordSymbol(char symbol) {
            tempWord = new WordImpl();
            tempWord.addLetter(new LetterImpl(symbol));
            tempState = insideWordState;
        }

        @Override
        public void buildSimplePunctuationSymbol(char symbol) {
            tempSentence.addPunctuation(new PunctuationImpl(symbol));
        }

        @Override
        public void buildEndPunctuationSymbol(char symbol) {
            tempSentence.addPunctuation(new PunctuationImpl(symbol));
            tempState = afterEndPunctuationState;
        }

        @Override
        public void buildSpace() {
            if (!lastSpace) {
                tempSentence.addPunctuation(new PunctuationImpl(SPACE));
                tempState = afterSimplePunctuationState;
            }
        }

        @Override
        public void buildEndText() {
            text.addSentence(tempSentence);
        }
    }

    private class AfterEndPunctuationState implements State {

        @Override
        public void buildWordSymbol(char symbol) {
            text.addSentence(tempSentence);
            tempSentence = new SentenceImpl();
            tempWord = new WordImpl();
            tempWord.addLetter(new LetterImpl(symbol));
            tempState = insideWordState;
        }

        @Override
        public void buildSimplePunctuationSymbol(char symbol) {
            text.addSentence(tempSentence);
            tempSentence = new SentenceImpl();
            tempSentence.addPunctuation(new PunctuationImpl(symbol));
            tempState = afterSimplePunctuationState;
        }

        @Override
        public void buildEndPunctuationSymbol(char symbol) {
            tempSentence.addPunctuation(new PunctuationImpl(symbol));
        }

        @Override
        public void buildSpace() {
            // Sentence can not have space as first symbol
        }

        @Override
        public void buildEndText() {
            text.addSentence(tempSentence);
        }
    }


}
