package com.logos.leetcode.dayquestion2026.Aug;

import java.util.HashSet;
import java.util.Set;

/**
 * @author logos
 * date 2026/8/11 19:45
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Aug
 */
public class M08D11 {

    /**
     * 2996. 大于等于顺序前缀和的最小缺失整数
     * <a href="https://leetcode.cn/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/description/"/>
     */

    class Solution {
        public int missingInteger(int[] nums) {
            int sum = nums[0];
            for (int i = 1; i < nums.length && nums[i] == nums[i - 1] + 1; i++) {
                sum += nums[i];
            }
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            while (set.contains(sum)) {
                sum++;
            }
            return sum;
        }
    }

}
