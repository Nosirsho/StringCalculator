package com.Nosirsho;

import static com.Nosirsho.Converter.arabicToRoman;
import static com.Nosirsho.Converter.romanToArabic;

public class Calculate {

    public static int getOperendType(String str) throws InvalidInputException {
        if(str.trim().matches("[0-9]+")){
            return 1;
        }else {
            if(romanToArabic(str) > 0){
                return 2;
            }
        }
        return 0;
    }

    public static boolean arithmeticOperationsIsValid(String str) throws InvalidInputException {
        int operationCount = str.length() - str.replaceAll("\\+", "")
                .replaceAll("-", "")
                .replaceAll("\\*", "")
                .replaceAll("/", "").length();
        if(operationCount > 1){
            throw new InvalidInputException("Формат математической операции не удовлетворяет заданию - один оператор");
        }else if(operationCount == 0){
            throw new InvalidInputException("Строка не является математической операцией");
        }
        return true;
    }

    public static String[] getOperends(String str) throws InvalidInputException {
        String[] strArr;
        strArr = str.split("[\\+-/*]");
        if (strArr.length != 2){
            throw new InvalidInputException("Формат математической операции не удовлетворяет заданию - два операнда");
        }
        return strArr;
    }

    public static boolean operendIsValid(String a, String b) throws InvalidInputException {
        if(getOperendType(a)==getOperendType(b) && getOperendType(a) != 0){
            return true;
        }
        throw new InvalidInputException("Используются одновременно разные системы счисления");
    }

    public static int[] parseOperendToInt(String[] strArr, int operendType) throws InvalidInputException {
        int[] result=new int[strArr.length];
        if (operendType==1){
            for (int i = 0; i < strArr.length; i++) {
                result[i]=Integer.parseInt(strArr[i].trim());
                if(result[i] > 10 || result[i] < 1 ) throw new InvalidInputException("Калькулятор должен принимать на вход числа от 1 до 10 включительно");
            }
        }else if (operendType==2){
            for (int i = 0; i < strArr.length; i++) {
                result[i]=Converter.romanToArabic(strArr[i]);
            }
        }

        return result;
    }

    public static String getOperation(String str){
        if(str.indexOf("+") > 0){
            return "+";
        }else if(str.indexOf("-") > 0){
            return "-";
        }if(str.indexOf("*") > 0){
            return "*";
        }else{
            return "/";
        }
    }
    public static String calculate(int[] operends, String operation, int operendsType) throws InvalidInputException {
        int result = 0;
        switch (operation){
            case "+": result = operends[0] + operends[1];break;
            case "-": result = operends[0] - operends[1];break;
            case "*": result = operends[0] * operends[1];break;
            case "/": result = operends[0] / operends[1];break;
        }
        if(operendsType==1){
            return Integer.toString(result);
        }else if(operendsType==2){
            if (result < 1){
                throw new InvalidInputException("Результат меньше еденицы");
            }
            return arabicToRoman(result);
        }
        return "";
    }

}
