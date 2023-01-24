package com.solvd.reddit.task12;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class Main {

    public static void main(String[] args) {

        Map<String, Map<String, Integer>> map = Map.ofEntries(
                entry("trans_act_1", Map.ofEntries(entry("user_id", 1), entry("payment", 300), entry("receive", 200), entry("action", 230))),
                entry("trans_act_2", Map.ofEntries(entry("user_id", 2), entry("payment", 100), entry("receive", 50), entry("action", 0))),
                entry("trans_act_3", Map.ofEntries(entry("user_id", 1), entry("payment", 222), entry("receive", 232), entry("action", 12)))
        );

        Map<Integer, Map<String, Integer>> newMap = calculateFieldAmountForUser(map);

        newMap.forEach((userID, stringIntegerMap) -> {
            System.out.println("user_id: " + userID);
            stringIntegerMap.forEach((field, value) -> {
                System.out.println(field + ": " + value);
            });
            System.out.println("-------------------");
        });

    }

    public static Map<Integer, Map<String, Integer>> calculateFieldAmountForUser(Map<String, Map<String, Integer>> map) {
        Map<Integer, Map<String, Integer>> result = new HashMap<>();
        List<Map<String, Integer>> list = map.values().stream().toList();
        for(Map<String, Integer> innerMap : list) {
            int userId = innerMap.get("user_id");
            if(result.get(userId) == null) {
                Map<String, Integer> newMap = new HashMap<>();
                for(Map.Entry<String, Integer> entry : innerMap.entrySet()) {
                    if(entry.getKey() != "user_id") newMap.put(entry.getKey(), entry.getValue());
                }
                result.put(userId, newMap);
            } else {
                Map<String, Integer> newMap = new HashMap<>();
                for(Map.Entry<String, Integer> entry : innerMap.entrySet()) {
                    if(entry.getKey() != "user_id") newMap.put(entry.getKey(), result.get(userId).get(entry.getKey()) + entry.getValue());
                }
                result.put(userId, newMap);
            }
        }
        return result;
    }


//    public static Map<Integer, Map<String, Integer>> calculateFieldAmountForUser(Map<String, Map<String, Integer>> map) {
//        List<Map<String, Integer>> list = map.values().stream().toList();
//        Map<Integer, Map<String, Integer>> resultMap = new HashMap<>();
//        for (Map<String, Integer> innerMap : list) {
//            int userID = innerMap.get("user_id");
//            if (resultMap.get(userID) == null) {
//                Map<String, Integer> newInnerMap = new HashMap<>();
//                for (String key : innerMap.keySet()) {
//                    if (key != "user_id") newInnerMap.put(key, innerMap.get(key));
//                }
//                resultMap.put(userID, newInnerMap);
//            } else {
//                Map<String, Integer> newInnerMap = new HashMap<>();
//                for (String key : innerMap.keySet()) {
//                    if (key != "user_id") newInnerMap.put(key, resultMap.get(userID).get(key) + innerMap.get(key));
//                }
//                resultMap.put(userID, newInnerMap);
//            }
//        }
//        return resultMap;
//    }
}
