package com.gmail.at.sichyuriyy.javatraining.labwork2.textparser;

import com.gmail.at.sichyuriyy.javatraining.labwork2.text.Text;

/**
 * Created by Yuriy on 28.02.2017.
 */
public interface TextBuilder {

    void createNewText();

    void buildSymbol(char symbol);
    void buildSpace();
    void buildEndText();

    Text getText();

}
