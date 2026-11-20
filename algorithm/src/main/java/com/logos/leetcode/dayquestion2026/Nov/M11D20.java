package com.logos.leetcode.dayquestion2026.Nov;

import java.util.Arrays;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/20 11:57
 * @version v1.0
 */
public class M11D20 {

    /**
     * 3041. 修改数组后最大化数组中的连续元素数目
     * <a href="https://leetcode.cn/problems/maximize-consecutive-elements-in-an-array-after-modification/description/"/>
     */

    class Solution {
        public int maxSelectedElements(int[] nums) {
            Arrays.sort(nums);
            int f0 = 0;
            int f1 = 0;
            int f2 = 0;
            int pre = 0;
            int ans = 0;
            for (int x : nums) {
                if (x == pre + 1) {
                    f0 = f1;
                    f1 = f2;
                } else if (x == pre + 2) {
                    f0 = f2;
                    f1 = 0;
                } else if (x > pre + 2) {
                    f0 = 0;
                    f1 = 0;
                }
                f2 = f1 + 1;
                f1 = f0 + 1;
                ans = Math.max(ans, Math.max(f1, f2));
                pre = x;
            }
            return ans;
        }
    }

}
