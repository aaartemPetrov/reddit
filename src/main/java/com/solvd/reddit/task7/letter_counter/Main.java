package com.solvd.reddit.task7.letter_counter;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String string = "Hello i'm fucking 911 cop, housekeeper do me a coffee.";
        Map<Character, Integer> result = countLettersInString(string);
        result.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }

    public static Map<Character, Integer> countLettersInString(String string) {
        Map<Character, Integer> result = new HashMap<>();
        string = string.toLowerCase();
        for(int i = 0; i < string.length(); i++) {
            if(Character.isLetter(string.charAt(i))) {
                if(result.get(string.charAt(i)) == null) result.put(string.charAt(i), 1);
                else result.put(string.charAt(i), result.get(string.charAt(i)) + 1);
            }
        }
        return result;
    }

}
