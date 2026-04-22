package com.logos.leetcode.dayquestion2026.Apr;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logos
 * date 2026/4/22 10:08
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D22 {

    /**
     * 2452. 距离字典两次编辑以内的单词
     * <a href="https://leetcode.cn/problems/words-within-two-edits-of-dictionary/description/"/>
     */

    class Solution {
        public List<String> twoEditWords(String[] queries, String[] dictionary) {
            List<String> ans = new ArrayList<>();
            for (String q : queries) {
                for (String s : dictionary) {
                    int cnt = 0;
                    for (int i = 0; i < s.length() && cnt <= 2; i++) {
                        if (q.charAt(i) != s.charAt(i)) {
                            cnt++;
                        }
                    }
                    if (cnt <= 2) {
                        ans.add(q);
                        break;
                    }
                }
            }
            return ans;
        }
    }

}
