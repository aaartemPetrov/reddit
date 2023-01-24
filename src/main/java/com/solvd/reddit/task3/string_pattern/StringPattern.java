package com.solvd.reddit.task3.string_pattern;

public class StringPattern {

    public static String asdf(String pattern) {
        if(!pattern.contains("[")) return pattern;
        char[] patternInChars = pattern.toCharArray();
        String digitString = "";
        int multiplier = 0;
        String beforeBrackets = "";
        String result = pattern;
        for (int i = 0; i < patternInChars.length; i++) {
            if (Character.isDigit(patternInChars[i])) {
                digitString += patternInChars[i];
            } else {
                if (digitString.length() != 0) {
                    multiplier = Integer.parseInt(digitString);
                }

                if ('[' == patternInChars[i]) {
                    int indexOfCloseBracket = getIndexOfCloseBracket(pattern);
                    String betweenBrackets = pattern.substring(i + 1, indexOfCloseBracket);
                    String newPattern = beforeBrackets + multiplyString(betweenBrackets, multiplier) + pattern.substring(indexOfCloseBracket + 1);
                    result = asdf(newPattern);
                    return result;
                } else {
                    beforeBrackets += patternInChars[i];
                }
            }
        }
        return result;
    }

    static int getIndexOfCloseBracket(String string) {
        int openBracketCount = 0;
        int closeBracketCount = 0;
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (']' == (chars[i])) {
                closeBracketCount++;
            } else if ('[' == chars[i]) {
                openBracketCount++;
            } else {
                continue;
            }

            if ((openBracketCount - closeBracketCount) == 0) {
                return i;
            }
        }
        return -1;
    }

    static String multiplyString(String string, int multiplier) {
        String result = string;
        for (int i = 1; i < multiplier; i++) {
            result += string;
        }
        return result;
    }

}
