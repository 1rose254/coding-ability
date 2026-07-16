package com.logos.leetcode.dayquestion2026.Jul;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/7/16 19:44
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jul
 */
public class M07D16 {

    /**
     * 3867. 数对的最大公约数之和
     * <a href="https://leetcode.cn/problems/sum-of-gcd-of-formed-pairs/description/"/>
     */

    class Solution {
        public long gcdSum(int[] nums) {
            int n = nums.length;
            int[] pre = new int[n];
            int mx = 0;
            for (int i = 0; i < n; i++) {
                int x = nums[i];
                mx = Math.max(mx, x);
                pre[i] = gcd(x, mx);
            }
            Arrays.sort(pre);
            long ans = 0;
            for (int i = 0; i < n / 2; i++) {
                ans += gcd(pre[i], pre[n - 1 - i]);
            }
            return ans;
        }

        private int gcd(int a, int b) {
            while (a != 0) {
                int tmp = a;
                a = b % a;
                b = tmp;
            }
            return b;
        }
    }

}
