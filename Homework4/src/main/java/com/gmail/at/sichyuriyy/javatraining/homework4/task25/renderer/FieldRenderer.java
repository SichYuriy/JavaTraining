package com.gmail.at.sichyuriyy.javatraining.homework4.task25.renderer;

import com.gmail.at.sichyuriyy.javatraining.homework4.task25.model.Cell;
import com.gmail.at.sichyuriyy.javatraining.homework4.task25.model.Field;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yuriy on 3/11/2017.
 */
public class FieldRenderer {

    private static final int FIELD_SIZE = 3;

    private Map<Cell, Character> cellCharacterMap;

    public FieldRenderer() {
        cellCharacterMap = new HashMap<>();
        cellCharacterMap.put(Cell.CROSS, 'X');
        cellCharacterMap.put(Cell.NOUGHT, '0');
        cellCharacterMap.put(Cell.EMPTY, ' ');
    }

    public void renderField(Field field) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            System.out.println("-------------");
            for (int j = 0; j < FIELD_SIZE; j++) {
                System.out.print("| " + cellCharacterMap.get(field.getCell(i, j)) + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }
}
