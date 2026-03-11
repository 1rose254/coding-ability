package com.logos.leetcode.hot100.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logos
 * date 2026/3/11 16:51
 * @version v1.0
 * @Package com.logos.leetcode.hot100.dp
 */
public class Q02 {

    /**
     * 118. 杨辉三角
     */

    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans = new ArrayList<>(numRows);
            ans.add(new ArrayList<Integer>());
            ans.get(0).add(1);
            for (int i = 2; i <= numRows; i++) {
                List<Integer> tmp = new ArrayList<>(i);
                tmp.add(1);
                for (int j = 1; j < i - 1; j++) {
                    tmp.add(ans.get(i - 2).get(j - 1) + ans.get(i - 2).get(j));
                }
                tmp.add(1);
                ans.add(tmp);
            }
            return ans;
        }
    }

}
