package com.logos.leetcode.dayquestion2026.Sep;

/**
 * @Package com.logos.leetcode.dayquestion2026.Sep
 * @author logos
 * date 2026/9/13 10:27
 * @version v1.0
 */
public class M09D13 {

    /**
     * 835. 图像重叠
     * <a href="https://leetcode.cn/problems/image-overlap/description/"/>
     */

    class Solution {
        public int largestOverlap(int[][] img1, int[][] img2) {
            int n = img1.length;
            int ans = 0;
            for (int dx = 1 - n; dx < n; dx++) {
                for (int dy = 1 - n; dy < n; dy++) {
                    int cnt1 = 0;
                    for (int i = Math.max(-dx, 0); i < Math.min(n - dx, n); i++) {
                        for (int j = Math.max(-dy, 0); j < Math.min(n - dy, n); j++) {
                            cnt1 += img1[i][j] * img2[i + dx][j + dy];
                        }
                    }
                    ans = Math.max(ans, cnt1);
                }
            }
            return ans;
        }
    }

}
