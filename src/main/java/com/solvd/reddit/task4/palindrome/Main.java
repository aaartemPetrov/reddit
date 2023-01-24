package com.solvd.reddit.task4.palindrome;

import java.util.Locale;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        System.out.println(isPalindrome("asd", "dsa", false));
        System.out.println(isPalindrome("asDsa", "asdsa", false));
        System.out.println(isPalindrome("qwe", "ewa", false));
    }

    public static boolean isPalindrome(String first, String second, boolean keySensitive) {
        if(keySensitive) return Objects.hash(first) == Objects.hash(reverse(second));
        return Objects.hash(first.toLowerCase()) == Objects.hash(reverse(second.toLowerCase()));
    }

    public static String reverse(String string) {
        String result = "";
        for(int i = string.length() - 1; i >= 0; i--) {
            result += string.charAt(i);
        }
        return result;
    }

}
