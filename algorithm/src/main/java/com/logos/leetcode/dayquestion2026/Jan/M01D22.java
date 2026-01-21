package com.logos.leetcode.dayquestion2026.Jan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logos
 * date 2026/1/22 0:12
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jan
 */
public class M01D22 {


    /**
     * 3507. 移除最小数对使数组有序 I
     * <a href="https://leetcode.cn/problems/minimum-pair-removal-to-sort-array-i/description/"/>
     */
    class Solution {
        public static List<Integer> list = new ArrayList<>();

        public int minimumPairRemoval(int[] nums) {
            list.clear();
            int op = 0;
            for (int num : nums) {
                list.add(num);
            }
            while (true) {
                if (check(list)) {
                    break;
                }
                int minSum = Integer.MAX_VALUE;
                int idx = -1;
                for (int i = 0; i < list.size() - 1; i++) {
                    int sum = list.get(i) + list.get(i + 1);
                    if (sum < minSum) {
                        minSum = sum;
                        idx = i;
                    }
                }
                int val = list.get(idx) + list.get(idx + 1);
                list.remove(idx + 1);
                list.set(idx, val);
                op++;
            }
            return op;
        }

        private boolean check(List<Integer> list) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    return false;
                }
            }
            return true;
        }
    }

}
