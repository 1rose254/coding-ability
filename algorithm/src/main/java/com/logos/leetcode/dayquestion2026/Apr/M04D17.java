package com.logos.leetcode.dayquestion2026.Apr;

import java.util.HashMap;
import java.util.Map;

/**
 * @author logos
 * date 2026/4/17 11:22
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D17 {

    /**
     * 3761. 镜像对之间最小绝对距离
     * <a href="https://leetcode.cn/problems/minimum-absolute-distance-between-mirror-pairs/description/"/>
     */

    class Solution {
        public int minMirrorPairDistance(int[] nums) {
            int n = nums.length;
            int ans = n;
            Map<Integer, Integer> lastIndex = new HashMap<>(n, 1);

            for (int j = 0; j < n; j++) {
                int x = nums[j];
                Integer i = lastIndex.get(x);
                if (i != null) {
                    ans = Math.min(ans, j - i);
                }

                int rev = 0;
                for (; x > 0; x /= 10) {
                    rev = rev * 10 + x % 10;
                }
                lastIndex.put(rev, j);
            }

            return ans < n ? ans : -1;
        }
    }

}
