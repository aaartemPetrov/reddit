package com.solvd.reddit.task9.pairs;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        List<List<Integer>> pairs = doPairs(arr);
        pairs.forEach(list -> {
            list.forEach(integer -> System.out.print(integer + " "));
            System.out.println();
        });
    }

    public static List<List<Integer>> doPairs(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[j]);
                result.add(pair);
            }
        }
        return result;
    }

}
