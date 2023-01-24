package com.solvd.reddit.task3.string_pattern;

public class Main {

    public static void main(String[] args) {
        String a = "[asdf][qwerty]3[z]";
        String b = "3[a]4[b]";
        String c = "3[a2[b]]";
        String d = "x22qwe2[a3[b]2[c]]y4[d]";

        System.out.println(getStringFromPattern(a));
        System.out.println(getStringFromPattern(b));
        System.out.println(getStringFromPattern(c));
        System.out.println(getStringFromPattern(d));
    }

    public static String getStringFromPattern(String stringPattern) {
        char[] chars = stringPattern.toCharArray();
        String numbersBeforeBrackets = "";
        String symbolsBeforeBrackets = "";
        int multiplier = 1;
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] != '[') {
                if(chars[i] == ']') return "BAD PATTERN!";

                if(Character.isDigit(chars[i])) {
                    numbersBeforeBrackets += chars[i];
                    if(i + 1 < chars.length && chars[i + 1] == '[') {
                        multiplier = Integer.parseInt(numbersBeforeBrackets);
                    } else if(i + 1 < chars.length && !Character.isDigit(chars[i + 1])) {
                        symbolsBeforeBrackets += numbersBeforeBrackets;
                        numbersBeforeBrackets = "";
                    }
                } else {
                    symbolsBeforeBrackets += chars[i];
                }
            } else {
                int indexOfCloseBracket = getIndexOfCloseBracket(chars);
                if(indexOfCloseBracket == -1) return "BAD PATTERN!";
                String newPattern = symbolsBeforeBrackets + multiplyString(stringPattern.substring(i + 1, indexOfCloseBracket), multiplier)
                        + stringPattern.substring(indexOfCloseBracket + 1);
                return getStringFromPattern(newPattern);
            }
        }
        return stringPattern;
    }

    public static int getIndexOfCloseBracket(char[] chars) {
        int countOpen = 0;
        int countClose = 0;
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '[') countOpen++;
            else if(chars[i] == ']') countClose++;
            else continue;

            if(countOpen - countClose == 0) return i;
        }

        return -1;
    }

    public static String multiplyString(String string, int multiplier) {
        String result = string;
        for(int i = 1; i < multiplier; i++) {
            result += string;
        }
        return result;
    }
}
