package com.logos.leetcode.hot100.greedy_algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logos
 * date 2026/3/11 16:42
 * @version v1.0
 * @Package com.logos.leetcode.hot100.greedy_algorithm
 */
public class Q04 {

    /**
     * 763. 划分字母区间
     */

    class Solution {
        public List<Integer> partitionLabels(String s) {
            List<Integer> ans = new ArrayList<>();
            char[] sArr = s.toCharArray();
            int n = sArr.length;
            int[] last = new int[26];
            for (int i = 0; i < n; i++) {
                last[sArr[i] - 'a'] = i;
            }
            int start = 0;
            int end = 0;
            for (int i = 0; i < n; i++) {
                end = Math.max(end, last[sArr[i] - 'a']);
                if (i == end) {
                    ans.add(end - start + 1);
                    start = i + 1;
                }
            }
            return ans;
        }
    }

}
