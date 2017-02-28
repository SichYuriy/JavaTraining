package com.gmail.at.sichyuriyy.javatraining.labwork2.textparser.impl;

import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Text;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.impl.*;
import com.gmail.at.sichyuriyy.javatraining.labwork2.textparser.TextBuilder;

/**
 * Created by Yuriy on 28.02.2017.
 */
public class TextBuilderImpl implements TextBuilder {

    private final static char SPACE = ' ';

    private TextImpl text;
    private SentenceImpl tempSentence;
    private WordImpl tempWord;

    private State tempState;

    private final State NEW_SENTENCE_STATE = new NewSentenceState();
    private final State INSIDE_WORD_STATE = new InsideWordState();
    private final State AFTER_SIMPLE_PUNCTUATION_STATE = new AfterSimplePunctuationState();
    private final State AFTER_END_PUNCTUATION_STATE = new AfterEndPunctuationState();

    private final String END_PUNCTUATIONS = ".!?";

    @Override
    public void createNewText() {
        text = new TextImpl();
        tempSentence = new SentenceImpl();
        tempState = NEW_SENTENCE_STATE;
    }

    @Override
    public void buildSymbol(char symbol) {
        if (isEndPunctuationSymbol(symbol)) {
            tempState.buildEndPunctuationSymbol(symbol);
        } else if (isWordLetter(symbol)) {
            tempState.buildWordSymbol(symbol);
        } else {
            tempState.buildSimplePunctuationSymbol(symbol);
        }

    }

    @Override
    public void buildSpace() {
        tempState.buildSpace();
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
            tempState = INSIDE_WORD_STATE;
        }

        @Override
        public void buildSimplePunctuationSymbol(char symbol) {
            tempSentence.addPunctuation(new PunctuationImpl(symbol));
            tempState = AFTER_SIMPLE_PUNCTUATION_STATE;
        }

        @Override
        public void buildEndPunctuationSymbol(char symbol) {
            tempSentence.addPunctuation(new PunctuationImpl(symbol));
            tempState = AFTER_END_PUNCTUATION_STATE;
        }

        @Override
        public void buildSpace() {
        }

        @Override
        public void buildEndText() {
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
            tempState = AFTER_SIMPLE_PUNCTUATION_STATE;
        }

        @Override
        public void buildEndPunctuationSymbol(char symbol) {
            tempSentence.addWord(tempWord);
            tempSentence.addPunctuation(new PunctuationImpl(symbol));
            tempState = AFTER_END_PUNCTUATION_STATE;
        }

        @Override
        public void buildSpace() {
            tempSentence.addWord(tempWord);
            tempSentence.addPunctuation(new PunctuationImpl(SPACE));
            tempState = AFTER_SIMPLE_PUNCTUATION_STATE;
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
            tempState = INSIDE_WORD_STATE;
        }

        @Override
        public void buildSimplePunctuationSymbol(char symbol) {
            tempSentence.addPunctuation(new PunctuationImpl(symbol));
        }

        @Override
        public void buildEndPunctuationSymbol(char symbol) {
            tempSentence.addPunctuation(new PunctuationImpl(symbol));
            tempState = AFTER_END_PUNCTUATION_STATE;
        }

        @Override
        public void buildSpace() {
            tempSentence.addPunctuation(new PunctuationImpl(SPACE));
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
            tempState = INSIDE_WORD_STATE;
        }

        @Override
        public void buildSimplePunctuationSymbol(char symbol) {
            text.addSentence(tempSentence);
            text.addSentence(tempSentence);
            tempSentence = new SentenceImpl();
            tempSentence.addPunctuation(new PunctuationImpl(symbol));
            tempState = AFTER_SIMPLE_PUNCTUATION_STATE;
        }

        @Override
        public void buildEndPunctuationSymbol(char symbol) {
            tempSentence.addPunctuation(new PunctuationImpl(symbol));
        }

        @Override
        public void buildSpace() {
        }

        @Override
        public void buildEndText() {
            text.addSentence(tempSentence);
        }
    }
}
