package com.solvd.reddit.task11.bracket_sequence;

public class Main {

    public static void main(String[] args) {
        String sequence = "[(]{)}()";
        String sequence1 = "[](){}{[]()(){}}[[[[{}()({})[]]]]]";
        System.out.println(isValid(sequence));
        System.out.println(isValid(sequence1));
    }

    public static boolean isValid(String string) {
        if (string.length() % 2 != 0) return false;
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '[') {
                int indexOfCloseBracket = getIndexOfCloseBracket(chars, '[', ']');
                if (indexOfCloseBracket == -1) return false;

                if (string.substring(i + 1, indexOfCloseBracket).length() % 2 == 0) {
                    chars[i] = '\0';
                    chars[indexOfCloseBracket] = '\0';
                } else return false;
            } else if (chars[i] == '(') {
                int indexOfCloseBracket = getIndexOfCloseBracket(chars, '(', ')');
                if (indexOfCloseBracket == -1) return false;

                if (string.substring(i + 1, indexOfCloseBracket).length() % 2 == 0) {
                    chars[i] = '\0';
                    chars[indexOfCloseBracket] = '\0';
                } else return false;
            } else if (chars[i] == '{') {
                int indexOfCloseBracket = getIndexOfCloseBracket(chars, '{', '}');
                if (indexOfCloseBracket == -1) return false;

                if (string.substring(i + 1, indexOfCloseBracket).length() % 2 == 0) {
                    chars[i] = '\0';
                    chars[indexOfCloseBracket] = '\0';
                } else return false;
            } else if (chars[i] == '\0') continue;
            else return false;
        }
        return true;
    }


    public static int getIndexOfCloseBracket(char[] brackets, char open, char close) {
        int openCount = 0;
        int closeCount = 0;
        for (int i = 0; i < brackets.length; i++) {
            if (brackets[i] == open) openCount++;
            else if (brackets[i] == close) closeCount++;
            else continue;

            if (openCount - closeCount == 0) return i;
        }

        return -1;
    }

}
