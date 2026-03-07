package com.logos.leetcode.hot100.linked_list;

import java.util.LinkedHashMap;

/**
 * @author logos
 * date 2026/3/7 20:05
 * @version v1.0
 * @Package com.logos.leetcode.hot100.linked_list
 */
public class Q14 {

    /**
     * 146. LRU缓存
     */

    class LRUCache {
        private LinkedHashMap<Integer, Integer> map;

        private int capacity;

        public LRUCache(int capacity) {
            map = new LinkedHashMap<>(capacity);
            this.capacity = capacity;
        }

        public int get(int key) {
            Integer value = map.remove(key);
            if (value != null) {
                map.put(key, value);
                return value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.remove(key) != null) {
                map.put(key, value);
                return;
            }
            if (map.size() == capacity) {
                Integer lastKey = map.keySet().iterator().next();
                map.remove(lastKey);
            }
            map.put(key, value);
        }
    }

}
