package com.Nosirsho;

public class Converter {
    public static String arabicToRoman(int arabic) {
        String roman = "";

        for (ArabicToRoman arabicToRoman : ArabicToRoman.values()) {
            while (arabic >= arabicToRoman.arabic) {
                roman += arabicToRoman.roman;
                arabic -= arabicToRoman.arabic;
            }
        }
        return roman;
    }
    public static int romanToArabic(String roman) throws InvalidInputException {
        switch (roman.toUpperCase().trim()){
            case "I": return 1;
            case "II": return 2;
            case "III": return 3;
            case "IV": return 4;
            case "V": return 5;
            case "VI": return 6;
            case "VII": return 7;
            case "VIII": return 8;
            case "IX": return 9;
            case "X": return 10;
        }
        throw new InvalidInputException("Неправильный фопмат римского числа или оперенд должен быть <= 10");
    }

    enum ArabicToRoman {
        THOUSAND(1000, "M"),
        NINE_HUNDRED(900, "CM"),
        FIVE_HUNDRED(500, "D"),
        FOUR_HUNDRED(400, "CD"),
        HUNDRED(100, "C"),
        NINETY(90, "XC"),
        FIFTY(50, "L"),
        FORTY(40, "XL"),
        TEN(10, "X"),
        NINE(9, "IX"),
        FIVE(5, "V"),
        FOUR(4, "IV"),
        ONE(1, "I");

        private final int arabic;
        private final String roman;

        ArabicToRoman(int arabic, String roman) {
            this.arabic = arabic;
            this.roman = roman;
        }
    }

}