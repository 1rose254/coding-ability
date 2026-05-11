package com.logos.leetcode.dayquestion2026.May;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author logos
 * date 2026/5/11 9:17
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D11 {

    /**
     * 2553. 分割数组中数字的数位
     * <a href="https://leetcode.cn/problems/separate-the-digits-in-an-array/description/"/>
     */

    class Solution {
        public int[] separateDigits(int[] nums) {
            List<Integer> digits = new ArrayList<>();
            for (int x : nums) {
                for (char ch : String.valueOf(x).toCharArray()) {
                    digits.add(ch - '0');
                }
            }
            int m = digits.size();
            int[] ans = new int[m];
            for (int i = 0; i < m; i++) {
                ans[i] = digits.get(i);
            }
            return ans;
        }
    }

}
