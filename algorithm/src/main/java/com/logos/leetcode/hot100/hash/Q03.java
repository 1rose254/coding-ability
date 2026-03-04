package com.logos.leetcode.hot100.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author logos
 * date 2026/3/4 11:03
 * @version v1.0
 * @Package com.logos.leetcode.hot100.hash
 */
public class Q03 {

    /**
     * 128. 最长连续序列
     */

    class Solution {
        public int longestConsecutive(int[] nums) {
            int ans = 0;
            Set<Integer> st = new HashSet<>();
            for (int x : nums) {
                st.add(x);
            }
            for (int x : st) {
                if (st.contains(x - 1)) {
                    continue;
                }
                int y = x + 1;
                while (st.contains(y)) {
                    y++;
                }
                ans = Math.max(ans, y - x);
            }
            return ans;
        }
    }

}
