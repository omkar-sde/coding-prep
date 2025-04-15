package org.neetcode150.binarySearch;

import java.util.*;
public class TimeBasedKeyValueStore_987 {

    /*
        Problem Statement: Design time based key value structure. Where for a key value is timestamp and value. Define ctor, get and set methods. When getting value, if timestamp is not available, latest timestamp is picked.
        Intuition: HashMap<String, List<Pair<K,V>>. A pair class is required. Using binary search find value smaller than the timestamp and get the value associated with it.
        Time Complexity: O(1) to set, O(logn) to get
        Space Complexity: O(m*n)
     */
    static class TimeMap {

        Map<String, List<Pair<Integer, String>>> mapStore;

        public TimeMap() {
            mapStore = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            mapStore.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
        }

        public String get(String key, int timestamp) {
            List<Pair<Integer, String>> pairs = mapStore.getOrDefault(key, new ArrayList<>());

            String ans = "";
            int left = 0, right = pairs.size() - 1;

            while(left <= right){
                int mid = (left + right)/2;

                if(pairs.get(mid).getKey() <= timestamp){
                    ans = pairs.get(mid).getValue();
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }

            return ans;
        }

        private static class Pair<K, V>{
            private final K key;
            private final V value;

            Pair(K key, V value){
                this.key = key;
                this.value = value;
            }

            public K getKey(){
                return key;
            }

            public V getValue(){
                return value;
            }
        }
    }


    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1));  // Output: bar
        System.out.println(timeMap.get("foo", 3));  // Output: bar
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4));  // Output: bar2
        System.out.println(timeMap.get("foo", 5));  // Output: bar2
    }
}
