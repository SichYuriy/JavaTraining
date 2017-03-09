package com.gmail.at.sichyuriyy.javatraining.labwork2.textparser;

import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Text;

import java.io.File;
import java.io.IOException;

/**
 * Created by Yuriy on 28.02.2017.
 */
public interface TextParser {

    Text parseText(File filePath) throws IOException;
    Text parseText(String text);
}
