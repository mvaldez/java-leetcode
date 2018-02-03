package com.sandbox.collections;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class AllOne {
    private Map<String, Integer> map;
    private Map<Integer, HashSet<String>> vals;
    private String maxKey;
    private String minKey;
    private int max;
    private int min;

    /** Initialize your data structure here. */
    public AllOne() {
        map = new HashMap<>();
        vals = new HashMap<>();
        maxKey = "";
        minKey = "";
        max = 0;
        min = 0;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        // update key map
        map.put(key, map.getOrDefault(key, 0) + 1);


        int val = map.get(key);

        // init hashset
        if(vals.get(val) == null) {
            vals.put(val, new HashSet<>());
        }

        // add new key to value map
        vals.get(val).add(key);

        // if value map contains prior to update value
        int prev = val -1;
        if(vals.containsKey(prev)){
            // remove that key from set
            vals.get(prev).remove(key);

            // is no more keys in the set then remove the value set
            if(vals.get(prev).size() == 0) {
                vals.remove(prev);
            }
        }

        // update max with key map
        if(map.get(key) > max){
            max = map.get(key);
            maxKey = key;
        }

        // if before the update the key was the min
        if(map.get(key) - 1 == min){

            // if the value set is empty or null
            if(vals.get(min) == null || vals.get(min).size() == 0){
                min++;
                minKey = key;
            }
            else {
                minKey = vals.get(min).iterator().next();
            }
        }

        // I'm 1 and the last update so make me the min
        if(map.get(key) == 1){
            min = 1;
            minKey = key;
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (map.containsKey(key)) {
            if (map.get(key) == 1) {
                map.remove(key);
                vals.get(1).remove(key);
                if (vals.get(1).size() > 0) {
                    min = 1;
                    minKey = vals.get(1).iterator().next();
                    if (max == 1) maxKey = minKey;
                } else {
                    vals.remove(1);
                    if (map.size() > 0) {
                        int tempMin = Integer.MAX_VALUE;
                        for (Map.Entry<Integer, HashSet<String>> e : vals.entrySet()) {
                            if (e.getValue().size() > 0)
                                tempMin = Math.min(tempMin, e.getKey());
                        }
                        min = tempMin;
                        minKey = vals.get(min).iterator().next();
                    } else {
                        min = 0;
                        max = 0;
                    }
                }
            } else {
                map.put(key, map.get(key) - 1);
                int val = map.get(key);
                vals.get(val + 1).remove(key);
                if (vals.get(val + 1).size() == 0) vals.remove(val + 1);
                if (vals.get(val) == null) vals.put(val, new HashSet<>());
                vals.get(val).add(key);
                if (val + 1 == max) {
                    if (vals.get(max) == null || vals.get(max).size() == 0) max--;
                    else maxKey = vals.get(max).iterator().next();
                }
                if (val + 1 == min) {
                    min--;
                    minKey = key;
                }
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(map.size() == 0) return "";
        return maxKey;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(map.size() == 0) return "";
        return minKey;
    }
}