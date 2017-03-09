package com.gmail.at.sichyuriyy.javatraining.labwork2;

import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Text;
import com.gmail.at.sichyuriyy.javatraining.labwork2.textparser.TextParser;
import com.gmail.at.sichyuriyy.javatraining.labwork2.textparser.impl.TextParserImpl;

import java.io.File;
import java.io.IOException;

/**
 * Created by Yuriy on 03.03.2017.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        TextParser textParser = new TextParserImpl();
        Text text = textParser.parseText(new File("textExample.txt"));

        System.out.println("text:");
        System.out.println(text.getStringValue());
        System.out.println("sorted words");
        System.out.println(text.sortWordsByLetterCount('a'));
    }
}
