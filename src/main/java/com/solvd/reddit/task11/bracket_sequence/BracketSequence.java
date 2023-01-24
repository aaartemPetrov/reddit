package com.solvd.reddit.task11.bracket_sequence;

public class BracketSequence {

    public static void main(String[] args) {
        String sequence = "[(]{)}()";
        String sequence1 = "[](){}{[]()(){}}[[[[{}()({})[]]]]]";
        System.out.println(isValid(sequence));
        System.out.println(isValid(sequence1));
    }


    public static boolean isValid(String brackets) {
        if (brackets.length() % 2 != 0) return false;
        char[] chars = brackets.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '{') {
                int indexOfCloseBracket = indexOfCloseBracket(chars, '{', '}');
                if (indexOfCloseBracket == -1) return false;

                if (brackets.substring(i + 1, indexOfCloseBracket).length() % 2 == 0) {
                    chars[i] = '\0';
                    chars[indexOfCloseBracket] = '\0';
                } else return false;
            }
            if (chars[i] == '[') {
                int indexOfCloseBracket = indexOfCloseBracket(chars, '[', ']');
                if (indexOfCloseBracket == -1) return false;

                if (brackets.substring(i + 1, indexOfCloseBracket).length() % 2 == 0) {
                    chars[i] = '\0';
                    chars[indexOfCloseBracket] = '\0';
                } else return false;
            }
            if (chars[i] == '(') {
                int indexOfCloseBracket = indexOfCloseBracket(chars, '(', ')');
                if (indexOfCloseBracket == -1) return false;

                if (brackets.substring(i + 1, indexOfCloseBracket).length() % 2 == 0) {
                    chars[i] = '\0';
                    chars[indexOfCloseBracket] = '\0';
                } else return false;
            } else if (chars[i] == '\0') continue;
            else return false;
        }
        return true;
    }

    public static int indexOfCloseBracket(char[] brackets, char openBracket, char closeBracket) {
        int openBracketCount = 0;
        int closeBracketCount = 0;
        for (int i = 0; i < brackets.length; i++) {
            if (brackets[i] == openBracket) openBracketCount++;
            else if (brackets[i] == closeBracket) closeBracketCount++;
            else continue;

            if (openBracketCount - closeBracketCount == 0) return i;
        }
        return -1;
    }
}
