package com.logos.leetcode.dayquestion2026.May;

import java.util.HashSet;
import java.util.Set;

/**
 * @author logos
 * date 2026/5/21 8:20
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D21 {

    /**
     * 3043. 最长公共前缀的长度
     * <a href="https://leetcode.cn/problems/find-the-length-of-the-longest-common-prefix/description/"/>
     */

    class Solution {
        public int longestCommonPrefix(int[] arr1, int[] arr2) {
            Set<String> st = new HashSet<>();
            for (int x : arr1) {
                String s = Integer.toString(x);
                for (int i = 1; i <= s.length(); i++) {
                    st.add(s.substring(0, i));
                }
            }

            int ans = 0;
            for (int x : arr2) {
                String s = Integer.toString(x);
                for (int i = 1; i <= s.length(); i++) {
                    if (!st.contains(s.substring(0, i))) {
                        break;
                    }
                    ans = Math.max(ans, i);
                }
            }
            return ans;
        }
    }

}
