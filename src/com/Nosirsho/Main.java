package com.Nosirsho;

import java.util.Scanner;

import static com.Nosirsho.Calculate.*;

public class Main {
    public static void main(String[] args) {
        String str;
        String result;
        String[] strOperendsArr;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическую операцию:");
        str = scanner.nextLine();
        int operendsType;

        try {
            arithmeticOperationsIsValid(str);
            strOperendsArr = getOperends(str);
            operendIsValid(strOperendsArr[0], strOperendsArr[1]);
            operendsType = getOperendType(strOperendsArr[0]);

            result = calculate(parseOperendToInt(strOperendsArr, operendsType), getOperation(str), operendsType);
            System.out.println("Результат: " + result);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }
}
