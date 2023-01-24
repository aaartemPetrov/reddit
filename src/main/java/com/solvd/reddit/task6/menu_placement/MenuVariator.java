package com.solvd.reddit.task6.menu_placement;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuVariator {

    public static void main(String[] args) {
        List<MenuItem> menu = List.of(
                new MenuItem("coffee", 100),
                new MenuItem("cheese", 150),
                new MenuItem("chocolate", 90),
                new MenuItem("meet", 300),
                new MenuItem("fish", 350),
                new MenuItem("water", 30),
                new MenuItem("potato", 70),
                new MenuItem("bread", 50),
                new MenuItem("chicken", 250),
                new MenuItem("milk", 80)
        );

        getResult(menu).forEach(list -> {
            list.forEach(element -> {
                System.out.print(element.getName() + "(" + element.getPrice() + ")" +"  ");
            });
            System.out.println();
        });

        System.out.println(getResult(menu).size());

    }

    public static List<List<MenuItem>> getResult(List<MenuItem> menu) {
        List<List<MenuItem>> resultList = new ArrayList<>();
        while (resultList.size() != numberOfVariations(menu.size())) {
            int randNumberOfElementsToDelete = (int) (Math.random() * (menu.size() + 1));
            List<MenuItem> variation = copyList(menu);
            for(int i = randNumberOfElementsToDelete; i > 0; i--) {
                int randomIndex = (int) (Math.random() * (variation.size()));
                variation.remove(randomIndex);
            }
            resultList.add(variation);
            resultList = resultList.stream().distinct().collect(Collectors.toList());
        }
        return resultList;
    }

    public static int numberOfVariations(int numberOfElements) {
        int result = 0;
        for (int i = 0; i < numberOfElements; i++) {
            if (i == 0) {
                result += 1;
            } else {
                result += Math.pow(2, i);
            }
        }
        return result;
    }

    public static List<MenuItem> returnListWithoutElement(List<MenuItem> list, int index) {
        List<MenuItem> newList = new ArrayList<>(list.size() - 1);
        for (int i = 0; i < list.size(); i++) {
            if (i != index) {
                newList.set(i, list.get(i));
            }
        }
        return newList;
    }

    public static List<MenuItem> copyList(List<MenuItem> list) {
        List<MenuItem> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            newList.add(list.get(i));
        }
        return newList;
    }

}
