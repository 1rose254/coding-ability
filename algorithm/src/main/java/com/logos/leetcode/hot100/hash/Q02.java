package com.logos.leetcode.hot100.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author logos
 * date 2026/3/4 10:58
 * @version v1.0
 * @Package com.logos.leetcode.hot100.hash
 */
public class Q02 {

    /**
     * 49. 字母异位词分组
     */

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String,List<String>> map = new HashMap<>();
            for(String str : strs){
                char[] charArr = str.toCharArray();
                Arrays.sort(charArr);
                String tmp = new String(charArr);
                List<String> list = map.getOrDefault(tmp,new ArrayList());
                list.add(str);
                map.put(tmp,list);
            }
            return new ArrayList<>(map.values());
        }
    }

}
