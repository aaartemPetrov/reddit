package com.solvd.reddit.task7.letter_counter;

import java.util.HashMap;
import java.util.Map;

public class LetterCounter {

    public static void main(String[] args) {
        String string = "Hello i'm fucking 911 cop, housekeeper do me a coffee.";
        Map<Character, Integer> result = countLettersInString(string);
        for (Map.Entry<Character, Integer> letterCount : result.entrySet()) {
            System.out.println(letterCount.getKey() + "  " + letterCount.getValue());
        }
    }

    public static Map<Character, Integer> countLettersInString(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                if (result.get(chars[i]) == null) result.put(chars[i], 1);
                else result.put(chars[i], result.get(chars[i]) + 1);
            }
        }
        return result;
    }
}
