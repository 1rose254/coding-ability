package com.logos.leetcode.dayquestion2026.Jan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author logos
 * date 2026/1/26 0:14
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jan
 */
public class M01D26 {

    /**
     * 1200. 最小绝对差
     * <a href="https://leetcode.cn/problems/minimum-absolute-difference/description/"/>
     */

    class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            Arrays.sort(arr);
            List<List<Integer>> ans = new ArrayList<>();
            int n = arr.length;
            int min = arr[1] - arr[0];
            for (int i = 0; i < n - 1; i++) {
                int cur = arr[i + 1] - arr[i];
                if (cur < min) {
                    ans.clear();
                    min = cur;
                }
                if (cur == min) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[i + 1]);
                    ans.add(temp);
                }
            }
            return ans;
        }
    }

}
