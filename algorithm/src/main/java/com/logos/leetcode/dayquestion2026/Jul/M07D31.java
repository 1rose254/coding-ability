package com.logos.leetcode.dayquestion2026.Jul;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/7/30 23:16
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jul
 */
public class M07D31 {

    /**
     * 3016. 输入单词需要的最少按键次数 II
     * <a href="https://leetcode.cn/problems/minimum-number-of-pushes-to-type-word-ii/description/"/>
     */

    class Solution {
        public int minimumPushes(String word) {
            int[] cnt = new int[26];
            for (char b : word.toCharArray()) {
                cnt[b - 'a']++;
            }
            Arrays.sort(cnt);
            int ans = 0;
            for (int i = 0; i < 26; i++) {
                ans += cnt[25 - i] * (i / 8 + 1);
            }
            return ans;
        }
    }

}
