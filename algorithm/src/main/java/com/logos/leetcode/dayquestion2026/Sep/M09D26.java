package com.logos.leetcode.dayquestion2026.Sep;

import java.util.HashMap;
import java.util.List;

/**
 * @Package com.logos.leetcode.dayquestion2026.Sep
 * @author logos
 * date 2026/9/26 09:28
 * @version v1.0
 */
public class M09D26 {

    /**
     * 1807. 替换字符串中的括号内容
     * <a href="https://leetcode.cn/problems/evaluate-the-bracket-pairs-of-a-string/description/"/>
     */

    class Solution {
        public String evaluate(String s, List<List<String>> knowledge) {
            HashMap<String, String> mp = HashMap.newHashMap(knowledge.size());
            for (List<String> kv : knowledge) {
                mp.put(kv.get(0), kv.get(1));
            }
            StringBuilder ans = new StringBuilder();
            int n = s.length();
            int left = -1;
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    left = i;
                } else if (ch == ')') {
                    String t = s.substring(left + 1, i);
                    t = mp.getOrDefault(t, "?");
                    ans.append(t);
                    left = -1;
                } else if (left < 0) {
                    ans.append(ch);
                }
            }
            return ans.toString();
        }
    }

}
