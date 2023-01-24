package com.solvd.reddit.task4.palindrome;

import java.util.Objects;

public class Palindrome {

    public static boolean isPalindrome(String first, String second, boolean keySensitive) {
        if (keySensitive) return Objects.hash(first) == Objects.hash(reverse(second));
        else return Objects.hash(first.toLowerCase()) == Objects.hash(reverse(second).toLowerCase());
    }

    public static String reverse(String string) {
        char[] chars = string.toCharArray();
        String result = "";
        for(int i = chars.length - 1; i >= 0; i--) {
            result += chars[i];
        }
        return result;
    }

}