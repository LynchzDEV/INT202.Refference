package com.example.demo1.models;

import java.util.regex.Pattern;

public class RandomNumber {
    private int num1 = (int)(Math.random() * 100);
    private int num2 = (int)(Math.random() * 100);
    private int answer = num1 + num2;

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public int getAnswer() {
        return answer;
    }

    public boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
