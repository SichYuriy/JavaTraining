package com.gmail.at.sichyuriyy.javatraining.homework4.task17;

import java.util.Scanner;

/**
 * Created by Yuriy on 3/11/2017.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        Calculator calculator = new Calculator();

        System.out.println(calculator.calculate(str));
    }
}
