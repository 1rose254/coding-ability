package com.logos.leetcode.hot100.heap;

/**
 * @author logos
 * date 2026/3/9 16:44
 * @version v1.0
 * @Package com.logos.leetcode.hot100.heap
 */
public class Q01 {

    /**
     * 215. 数组中的第K个最大元素
     */
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return randomSelect(nums, nums.length - k);
        }

        private static int randomSelect(int[] nums, int k) {
            int ans = 0;
            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {
                int num = nums[l + (int) (Math.random() * (r - l + 1))];
                partition(nums, l, r, num);
                if (k < first) {
                    r = first - 1;
                } else if (k > last) {
                    l = last + 1;
                } else {
                    ans = nums[first];
                    break;
                }
            }
            return ans;
        }

        private static int first, last;

        private static void partition(int[] nums, int l, int r, int x) {
            first = l;
            last = r;
            int i = l;
            while (i <= last) {
                if (x == nums[i]) {
                    i++;
                } else if (nums[i] < x) {
                    swap(nums, i, first);
                    first++;
                    i++;
                } else {
                    swap(nums, i, last);
                    last--;
                }
            }
        }

        private static void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

}
