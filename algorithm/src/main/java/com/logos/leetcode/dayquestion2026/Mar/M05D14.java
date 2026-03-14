package com.logos.leetcode.dayquestion2026.Mar;

/**
 * @author logos
 * date 2026/3/14 9:53
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M05D14 {

    /**
     * 1415. 长度为 n 的开心字符串中字典序第 k 小的字符串
     * <a href="https://leetcode.cn/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/"/>
     */

    class Solution {
        public String getHappyString(int n, int k) {
            if (k > 3 << (n - 1)) {
                return "";
            }
            k--;
            char[] ans = new char[n];
            ans[0] = (char) ('a' + (k >> (n - 1)));
            for (int i = 1; i < n; i++) {
                ans[i] = (char) ('a' + (k >> (n - 1 - i) & 1));
                if (ans[i] >= ans[i - 1]) {
                    ans[i]++;
                }
            }
            return new String(ans);
        }
    }

}
