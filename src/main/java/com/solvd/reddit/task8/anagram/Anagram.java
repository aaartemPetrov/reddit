package com.solvd.reddit.task8.anagram;

import com.solvd.reddit.task7.letter_counter.LetterCounter;

import java.util.Map;

public class Anagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("qwe", "ewq"));
        System.out.println(isAnagram("qweqwe", "ewqewq"));
        System.out.println(isAnagram("qqwwee", "qewewq"));
        System.out.println(isAnagram("teat", "eatt"));
        System.out.println(isAnagram("teatq", "eattt"));
    }

    public static boolean isAnagram(String str1, String str2) {
        if( str1.length() != str2.length()) return false;
        Map<Character, Integer> str1Map = LetterCounter.countLettersInString(str1);
        Map<Character, Integer> str2Map = LetterCounter.countLettersInString(str2);
        for(Map.Entry<Character, Integer> entry1 : str1Map.entrySet()) {
            if(entry1.getValue() != str2Map.get(entry1.getKey())) return false;
        }
        return true;
    }

}
