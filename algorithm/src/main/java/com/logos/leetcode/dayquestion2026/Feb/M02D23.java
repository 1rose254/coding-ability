package com.logos.leetcode.dayquestion2026.Feb;

/**
 * @author logos
 * date 2026/2/23 0:02
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D23 {

    /**
     * 1461. 检查一个字符串是否包含所有长度为 K 的二进制子串
     * <a href="https://leetcode.cn/problems/check-if-a-string-contains-all-binary-codes-of-size-k/description/"/>
     */

    class Solution {
        public boolean hasAllCodes(String s, int k) {
            final int MASK = (1 << k) - 1;
            boolean[] has = new boolean[1 << k];
            int cnt = 0;
            int x = 0;
            for (int i = 0; i < s.length() && cnt < (1 << k); i++) {
                char ch = s.charAt(i);
                x = (x << 1 & MASK) | (ch & 1);
                if (i >= k - 1 && !has[x]) {
                    has[x] = true;
                    cnt++;
                }
            }
            return cnt == (1 << k);
        }
    }

}
