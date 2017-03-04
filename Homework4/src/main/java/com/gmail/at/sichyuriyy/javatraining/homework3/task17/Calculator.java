package com.gmail.at.sichyuriyy.javatraining.homework3.task17;

import javafx.util.Pair;

import java.util.*;
import java.util.function.BiFunction;

/**
 * Created by Yuriy on 04.03.2017.
 */
public class Calculator {

    private static final char SUM_SYMBOL = '+';
    private static final char DIFFERENCE_SYMBOL = '-';
    private static final char PRODUCT_SYMBOL = '*';
    private static final char DIVISION_SYMBOL = '/';

    private static final char DOT_SYMBOL = '.';


    private static final char BEGIN_BRACE_SYMBOL = '(';
    private static final char END_BRACE_SYMBOL = ')';

    private static final String ERROR_MASSAGE = "Expression is not correct";

    private Map<Character, Token> characterTokenMap;

    private Map<Token.Type, BiFunction<ArithmeticExpression, ArithmeticExpression, ArithmeticExpression>> typeExpressionMap;


    public Calculator() {
        characterTokenMap = new HashMap<>();
        characterTokenMap.put(SUM_SYMBOL, new Token(Token.Type.SUM, 1));
        characterTokenMap.put(DIFFERENCE_SYMBOL, new Token(Token.Type.DIFFERENCE, 1));
        characterTokenMap.put(PRODUCT_SYMBOL, new Token(Token.Type.PRODUCT, 2));
        characterTokenMap.put(DIVISION_SYMBOL, new Token(Token.Type.DIVISION, 2));

        characterTokenMap.put(BEGIN_BRACE_SYMBOL, new Token(Token.Type.BEGIN_BRACE));
        characterTokenMap.put(END_BRACE_SYMBOL, new Token(Token.Type.END_BRACE));

        typeExpressionMap = new HashMap<>();
        typeExpressionMap.put(Token.Type.SUM, Sum::new);
        typeExpressionMap.put(Token.Type.DIFFERENCE, Difference::new);
        typeExpressionMap.put(Token.Type.PRODUCT, Product::new);
        typeExpressionMap.put(Token.Type.DIVISION, Division::new);
    }

    public double calculate(String expression) {
        ArithmeticExpression arithmeticExpression = parse(expression);
        return arithmeticExpression.getValue();
    }

    private ArithmeticExpression parse(String expression) {
        List<Token> tokens = splitExpression(expression);

        normalizeTokens(tokens);

        Deque<ArithmeticExpression> outputStack = new LinkedList<>();
        Deque<Token> operatorStack = new LinkedList<>();

        for (Token token: tokens) {
            if (token.type.equals(Token.Type.CONSTANT)) {
                outputStack.addLast(new Constant(token.value));
            } else if (token.isOperator) {
                addOperator(outputStack, operatorStack, token);
            }else if (token.type.equals(Token.Type.BEGIN_BRACE)) {
                operatorStack.addLast(token);
            } else if (token.type.equals(Token.Type.END_BRACE)) {
                removeLastBeginBrace(outputStack, operatorStack);
            }
        }

        while(operatorStack.size() > 0) {
            if (operatorStack.getLast().isOperator) {
                moveToOutput(outputStack, operatorStack);
            } else {
                throw new IllegalArgumentException(ERROR_MASSAGE);
            }
        }

        return outputStack.pollLast();
    }

    private void addOperator(Deque<ArithmeticExpression> outputStack,
                             Deque<Token> operatorStack,
                             Token operator) {
        while (operatorStack.size() > 0
                && operatorStack.getLast().isOperator
                && operator.precedence <= operatorStack.getLast().precedence) {
            moveToOutput(outputStack, operatorStack);
        }
        operatorStack.add(operator);
    }

    private void moveToOutput(Deque<ArithmeticExpression> outputStack,
                         Deque<Token> operatorStack) {
        if (outputStack.size() < 2) {
            throw new IllegalArgumentException(ERROR_MASSAGE);
        }
        Token moveOperator = operatorStack.pollLast();
        ArithmeticExpression right = outputStack.pollLast();
        ArithmeticExpression left = outputStack.pollLast();
        outputStack.addLast(typeExpressionMap.get(moveOperator.type).apply(left, right));
    }

    private void removeLastBeginBrace(Deque<ArithmeticExpression> outputStack,
                                      Deque<Token> operatorStack) {
        while (operatorStack.size() > 0 && operatorStack.getLast().isOperator) {
            moveToOutput(outputStack, operatorStack);
        }
        if (operatorStack.size() == 0) {
            throw new IllegalArgumentException(ERROR_MASSAGE);
        }
        operatorStack.pollLast();
    }

    private List<Token> splitExpression(String expression) {
        List<Token> result = new ArrayList<>();
        int tokenBeginIndex;
        int tokenEndIndex;
        int tempIndex = 0;
        char[] symbols = expression.toCharArray();
        while (tempIndex < symbols.length) {
            tokenBeginIndex = tempIndex;
            char tempSymbol = symbols[tempIndex];
            if (Character.isDigit(tempSymbol)) {
                tokenEndIndex = getEndIndexOfNumber(symbols, tempIndex);
                String constantStr = expression.substring(tokenBeginIndex, tokenEndIndex);
                result.add(new Token(Token.Type.CONSTANT, Double.valueOf(constantStr)));
            } else if(characterTokenMap.containsKey(tempSymbol)) {
                tokenEndIndex = tempIndex + 1;
                result.add(characterTokenMap.get(tempSymbol));
            } else if (Character.isWhitespace(tempSymbol)) {
                tempIndex++;
                continue;
            } else {
                throw new IllegalArgumentException(ERROR_MASSAGE);
            }
            tempIndex = tokenEndIndex;
        }
        return result;
    }

    private int getEndIndexOfNumber(char[] symbols, int start) {
        boolean dotPresent = false;
        for (int i = start + 1; i < symbols.length; i++) {
            char tempSymbol = symbols[i];
            if (tempSymbol == DOT_SYMBOL) {
                if (dotPresent) {
                    throw new IllegalArgumentException(ERROR_MASSAGE);
                }
                dotPresent = true;
            } else if(!Character.isDigit(tempSymbol) && !Character.isWhitespace(tempSymbol)) {
                return i;
            }
        }
        return symbols.length;
    }

    private void normalizeTokens(List<Token> tokens) {
        for (int i = 0; i < tokens.size(); i++) {
            Token tempToken = tokens.get(i);
            if (tempToken.isOperator
                    && (i == 0 || tokens.get(i - 1).type.equals(Token.Type.BEGIN_BRACE))) {
                tokens.add(i, new Token(Token.Type.CONSTANT, 0d));
                i++;
            }
        }
    }

    private static class Token {
        private enum Type {
            CONSTANT, SUM, DIFFERENCE, DIVISION, PRODUCT, BEGIN_BRACE, END_BRACE
        }

        private Type type;
        private Double value;
        private int precedence;
        private boolean isOperator;

        private Token(Type type) {
            this.type = type;
        }

        private Token(Type type, int precedence) {
            this(type);
            this.precedence = precedence;
            isOperator = true;
        }

        private Token(Type type, Double value) {
            this(type);
            this.value = value;
        }

    }

}
