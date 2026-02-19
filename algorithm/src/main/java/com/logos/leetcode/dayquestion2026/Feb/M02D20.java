package com.logos.leetcode.dayquestion2026.Feb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author logos
 * date 2026/2/19 23:50
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D20 {

    /**
     * 761. 特殊的二进制字符串
     * <a href="https://leetcode.cn/problems/special-binary-string/description/"/>
     */

    class Solution {
        public String makeLargestSpecial(String s) {
            if (s.length() == 0) {
                return s;
            }
            List<String> list = new ArrayList<>();
            char[] cs = s.toCharArray();
            for (int i = 0, j = 0, k = 0; i < cs.length; i++) {
                k += cs[i] == '1' ? 1 : -1;
                if (k == 0) {
                    list.add("1" + makeLargestSpecial(s.substring(j + 1, i)) + "0");
                    j = i + 1;
                }
            }
            Collections.sort(list, (a, b)->(b + a).compareTo(a + b));
            StringBuilder sb = new StringBuilder();
            for (String str : list) {
                sb.append(str);
            }
            return sb.toString();
        }
    }

}
