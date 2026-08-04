package com.logos.leetcode.dayquestion2026.Aug;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author logos
 * date 2026/8/3 22:58
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Aug
 */
public class M08D04 {

    /**
     * 3731. 找出缺失的元素
     * <a href="https://leetcode.cn/problems/find-missing-elements/description/"/>
     */

    class Solution {
        public List<Integer> findMissingElements(int[] nums) {
            int mn = Integer.MAX_VALUE;
            int mx = Integer.MIN_VALUE;
            Set<Integer> st = new HashSet<>();
            for (int x : nums) {
                mn = Math.min(mn, x);
                mx = Math.max(mx, x);
                st.add(x);
            }

            List<Integer> ans = new ArrayList<>();
            for (int i = mn + 1; i < mx; i++) {
                if (!st.contains(i)) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }

}
