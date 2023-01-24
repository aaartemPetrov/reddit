package com.solvd.reddit.task6.menu_placement;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<MenuItem> menu = List.of(
                new MenuItem("coffee", 900),
                new MenuItem("cheese", 370),
                new MenuItem("chocolate", 290),
                new MenuItem("meet", 300),
                new MenuItem("fish", 350),
                new MenuItem("water", 335),
                new MenuItem("potato", 140)
//                new MenuItem("bread", 50),
//                new MenuItem("chicken", 250),
//                new MenuItem("milk", 80)
        );

        List<List<MenuItem>> result = getVariants(menu, 1000);

        result.forEach(list -> {
            list.forEach(element -> {
                System.out.print(element.getName() + "(" + element.getPrice() + ")" + "  ");
            });
            System.out.println();
        });

        System.out.println(result.size());
    }

    public static List<List<MenuItem>> getVariants(List<MenuItem> menu, int moneyAmount) {
        List<List<MenuItem>> result = new ArrayList<>();
        int maxK = getMaxK(menu, moneyAmount);
        int n = menu.size();
        for (int k = 1; k <= maxK; k++) {
            result.addAll(permutationsKofN(menu, k, n));
        }
        deleteHigherThenAmount(result, moneyAmount);
        return result;
    }

    public static int getMaxK(List<MenuItem> menu, int moneyAmount) {
        return moneyAmount / menu.stream().map(item -> item.getPrice()).min((x, y) -> x.compareTo(y)).get();
    }

    public static List<List<MenuItem>> permutationsKofN(List<MenuItem> menu, int k, int n) {
        List<List<MenuItem>> variations = new ArrayList<>();
        int[] permutation = new int[k];
        while(true) {
            variations.add(createVariation(menu, permutation));
            int i = k - 1;
            while(i >= 0) {
                if(permutation[i] < n - 1) break;
                i--;
            }
            if(i == -1) break;

            permutation[i]++;
            i++;
            while(i < k) {
                permutation[i] = 0;
                i++;
            }
        }
        return variations;
    }

    public static List<MenuItem> createVariation(List<MenuItem> menu, int[] permutation) {
        List<MenuItem> variation = new ArrayList<>();
        for(int i = 0; i < permutation.length; i++) {
            variation.add(menu.get(permutation[i]));
        }
        return variation;
    }

    public static void deleteHigherThenAmount(List<List<MenuItem>> result, int moneyAmount) {
        List<List<MenuItem>> toDelete = new ArrayList<>();
        for(List<MenuItem> variation : result) {
            int sum = variation.stream().map(item -> item.getPrice()).reduce((x,y) -> x + y).get();
            if(sum > moneyAmount) toDelete.add(variation);
        }

        for(List<MenuItem> delete : toDelete) {
            result.remove(delete);
        }
    }

}
