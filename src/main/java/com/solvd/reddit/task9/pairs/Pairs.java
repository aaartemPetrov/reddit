package com.solvd.reddit.task9.pairs;

import java.util.ArrayList;
import java.util.List;

public class Pairs {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        List<List<Integer>> pairs = doPairs(arr);
        pairs.forEach(list -> {
            list.forEach(integer -> System.out.print(integer + " "));
            System.out.println();
        });
    }

    public static List<List<Integer>> doPairs(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i < array.length; i++) {
            for(int j = i + 1; j < array.length; j++) {
                List<Integer> pair = new ArrayList<>();
                pair.add((array[i]));
                pair.add(array[j]);
                result.add(pair);
            }
        }
        return result;
    }

}
