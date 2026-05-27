package com.logos.leetcode.dayquestion2026.May;

/**
 * @author logos
 * date 2026/5/27 8:24
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D27 {

    /**
     * 3121. 统计特殊字母的数量 II
     * <a href="https://leetcode.cn/problems/count-the-number-of-special-characters-ii/description/"/>
     */

    class Solution {
        public int numberOfSpecialChars(String word) {
            int ans = 0;
            int[] state = new int[27];
            for (char c : word.toCharArray()) {
                int x = c & 31;
                if ((c & 32) > 0) {
                    if (state[x] == 0) {
                        state[x] = 1;
                    } else if (state[x] == 2) {
                        state[x] = -1;
                        ans--;
                    }
                } else {
                    if (state[x] == 0) {
                        state[x] = -1;
                    } else if (state[x] == 1) {
                        state[x] = 2;
                        ans++;
                    }
                }
            }
            return ans;
        }
    }

}
