package com.logos.leetcode.hot100.skill;

/**
 * @author logos
 * date 2026/3/17 16:16
 * @version v1.0
 * @Package com.logos.leetcode.hot100.skill
 */
public class Q05 {

    /**
     * 287. 寻找重复数
     */

    class Solution {
        public int findDuplicate(int[] nums) {
            int fast = 0;
            int slow = 0;
            do {
                fast = nums[nums[fast]];
                slow = nums[slow];
            } while (fast != slow);
            fast = 0;
            while (fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
    }

}
