package com.gmail.at.sichyuriyy.javatraining.labwork2.textparser.impl;

import com.gmail.at.sichyuriyy.javatraining.labwork2.textparser.TextBuilder;
import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Text;
import com.gmail.at.sichyuriyy.javatraining.labwork2.textparser.TextParser;

import java.io.*;

/**
 * Created by Yuriy on 28.02.2017.
 */
public class TextParserImpl implements TextParser {

    @Override
    public Text parseText(File file) throws IOException {
        TextBuilder textBuilder = new TextBuilderImpl();
        textBuilder.createNewText();

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                parseContent(textBuilder, line);
                line = reader.readLine();
            }
        }

        textBuilder.buildEndText();
        return textBuilder.getText();
    }

    @Override
    public Text parseText(String text) {
        TextBuilder textBuilder = new TextBuilderImpl();
        textBuilder.createNewText();

        parseContent(textBuilder, text);

        textBuilder.buildEndText();
        return textBuilder.getText();
    }

    private void parseContent(TextBuilder textBuilder, String text) {
        String []content = text.split("\\s+");

        for (String part: content) {
            textBuilder.buildSpace();
            for (char symbol: part.toCharArray()) {
                textBuilder.buildSymbol(symbol);
            }
        }
    }
}
