package com.logos.leetcode.dayquestion2026.Apr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author logos
 * date 2026/4/23 10:13
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D23 {

    /**
     * 2615. 等值距离和
     * <a href="https://leetcode.cn/problems/sum-of-distances/description/"/>
     */

    class Solution {
        public long[] distance(int[] nums) {
            int n = nums.length;
            var groups = new HashMap<Integer, List<Integer>>();
            for (int i = 0; i < n; ++i) {
                groups.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            }
            var ans = new long[n];
            var s = new long[n + 1];
            for (var a : groups.values()) {
                int m = a.size();
                for (int i = 0; i < m; ++i){
                    s[i + 1] = s[i] + a.get(i);
                }
                for (int i = 0; i < m; ++i) {
                    int target = a.get(i);
                    long left = (long) target * i - s[i];
                    long right = s[m] - s[i] - (long) target * (m - i);
                    ans[target] = left + right;
                }
            }
            return ans;
        }
    }

}
