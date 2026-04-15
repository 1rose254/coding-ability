package com.logos.leetcode.dayquestion2026.Apr;

/**
 * @author logos
 * date 2026/4/15 10:20
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D15 {

    /**
     * 2515. 到目标字符串的最短距离
     * <a href="https://leetcode.cn/problems/shortest-distance-to-target-string-in-a-circular-array/description/"/>
     */

    class Solution {
        public int closestTarget(String[] words, String target, int startIndex) {
            int n = words.length;
            int ans = n;
            for (int i = 0; i < n; i++) {
                if (words[i].equals(target)) {
                    int d = Math.abs(i - startIndex);
                    ans = Math.min(ans, Math.min(d, n - d));
                }
            }
            return ans == n ? -1 : ans;
        }
    }

}
