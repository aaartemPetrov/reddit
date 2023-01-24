package com.solvd.reddit.task8.anagram;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(isAnagram("qwe", "ewq"));
        System.out.println(isAnagram("qweqwe", "ewqewq"));
        System.out.println(isAnagram("qqwwee", "qewewq"));
        System.out.println(isAnagram("teat", "eatt"));
        System.out.println(isAnagram("teatq", "eattt"));
    }

    public static boolean isAnagram(String first, String second) {
        if(first.length() != second.length()) return false;
        Map<Character, Integer> firstMap = letterCount(first);
        Map<Character, Integer> secondMap = letterCount(second);
        if(firstMap.size() != secondMap.size()) return false;
        for(Map.Entry<Character, Integer> entry : firstMap.entrySet()) {
            if(entry.getValue() != secondMap.get(entry.getKey())) return false;
        }
        return true;
    }

    public static Map<Character, Integer> letterCount(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        Map<Character, Integer> result = new HashMap<>();
        for(int i = 0; i < chars.length; i++) {
            if(result.get(chars[i]) == null) result.put(chars[i], 1);
            else result.put(chars[i], result.get(chars[i]) + 1);
        }
        return result;
    }
}
