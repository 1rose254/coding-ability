package com.logos.leetcode.dayquestion2026.Sep;

/**
 * @Package com.logos.leetcode.dayquestion2026.Sep
 * @author logos
 * date 2026/9/17 09:49
 * @version v1.0
 */
public class M09D17 {

    /**
     * 1477. 找两个和为目标值且不重叠的子数组
     * <a href="https://leetcode.cn/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/description/"/>
     */

    class Solution {
        public int minSumOfLengths(int[] arr, int target) {
            int n = arr.length;
            int[] sufMin = new int[n];
            int minLen = n + 1;
            int sum = 0;
            int r = n - 1;
            for (int l = n - 1; l > 0; l--) {
                sum += arr[l];
                while (sum > target) {
                    sum -= arr[r];
                    r--;
                }
                if (sum == target) {
                    minLen = Math.min(minLen, r - l + 1);
                }
                sufMin[l] = minLen;
            }
            int ans = n + 1;
            sum = 0;
            int l = 0;
            for (r = 0; r < n - 1; r++) {
                sum += arr[r];
                while (sum > target) {
                    sum -= arr[l];
                    l++;
                }
                if (sum == target) {
                    ans = Math.min(ans, r - l + 1 + sufMin[r + 1]);
                }
            }
            return ans > n ? -1 : ans;
        }
    }

}
