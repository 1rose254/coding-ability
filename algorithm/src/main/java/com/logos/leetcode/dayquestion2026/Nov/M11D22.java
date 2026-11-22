package com.logos.leetcode.dayquestion2026.Nov;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/22 11:45
 * @version v1.0
 */
public class M11D22 {

    /**
     * 2124. 检查是否所有 A 都在 B 之前
     * <a href="https://leetcode.cn/problems/check-if-all-as-appears-before-all-bs/description/"/>
     */

    class Solution {
        public boolean checkString(String s) {
            return !s.contains("ba");
        }
    }

}
