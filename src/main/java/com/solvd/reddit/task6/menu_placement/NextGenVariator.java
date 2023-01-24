package com.solvd.reddit.task6.menu_placement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NextGenVariator {

    public static void main(String[] args) {
        List<MenuItem> menu = List.of(
                new MenuItem("coffee", 1100),
                new MenuItem("cheese", 150),
                new MenuItem("chocolate", 190),
                new MenuItem("meet", 300),
                new MenuItem("fish", 350),
                new MenuItem("water", 125)
//                new MenuItem("potato", 70),
//                new MenuItem("bread", 50),
//                new MenuItem("chicken", 250),
//                new MenuItem("milk", 80)
        );

        List<List<MenuItem>> result = getVariatons(menu,1000);

        result.forEach(list -> {
            list.forEach(element -> {
                System.out.print(element.getName() + "(" + element.getPrice() + ")" + "  ");
            });
            System.out.println();
        });

        System.out.println(result.size());
    }

    public static int getMaxDeepness(List<MenuItem> menu, int moneyAmount) {
       return moneyAmount / menu.stream().map(item -> item.getPrice()).min(Integer::compareTo).get();
    }

    public static List<List<MenuItem>> getVariatons(List<MenuItem> menu, int moneyAmount) {
        List<List<MenuItem>> result = new ArrayList<>();
        for (MenuItem item : menu) {
            result.add(List.of(item));
        }
        int n = 1;
        int maxDeepneess = getMaxDeepness(menu, moneyAmount);

        while (n < maxDeepneess) {
            int resultSize = result.size();
            for (int i = 0; i < resultSize; i++) {
                for (int j = 0; j < menu.size(); j++) {
                    List<MenuItem> menuVariation = deepCopy(result.get(i));
                    menuVariation.add(menu.get(j));
                    result.add(menuVariation);
                }
            }
            n++;
        }

        result = result.stream().distinct().collect(Collectors.toList());
        List<List<MenuItem>> toRemove = new ArrayList<>();
        for(List<MenuItem> variation : result) {
            int moneySum = 0;
          for(MenuItem menuItem : variation) {
              moneySum += menuItem.getPrice();
          }
          if(moneySum > moneyAmount) toRemove.add(variation);
        }

        for(List<MenuItem> variation : toRemove) {
            result.remove(variation);
        }
        return result;
    }

    public static List<MenuItem> deepCopy(List<MenuItem> from) {
        List<MenuItem> to = new ArrayList<>();
        for (MenuItem item : from) {
            to.add(item);
        }
        return to;
    }

}
