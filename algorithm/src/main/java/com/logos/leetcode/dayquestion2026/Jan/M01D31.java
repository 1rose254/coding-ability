package com.logos.leetcode.dayquestion2026.Jan;

/**
 * @author logos
 * date 2026/1/31 12:08
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jan
 */
public class M01D31 {

    /**
     * 744. 寻找比目标字母大的最小字母
     * <a href="https://leetcode.cn/problems/find-smallest-letter-greater-than-target/description/"/>
     */

    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int n = letters.length;
            int l = 0;
            int r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (letters[mid] > target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return letters[r] > target ? letters[r] : letters[0];
        }
    }

}
