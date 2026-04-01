package com.logos.leetcode.dayquestion2026.Apr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author logos
 * date 2026/4/1 9:54
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D01 {

    /**
     * 2751. 机器人碰撞
     * <a href="https://leetcode.cn/problems/robot-collisions/description/"/>
     */

    class Solution {
        public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
            int n = positions.length;
            Integer[] idx = new Integer[n];
            for (int i = 0; i < n; i++) {
                idx[i] = i;
            }
            Arrays.sort(idx, (i, j) -> positions[i] - positions[j]);

            int[] st = new int[n];
            int top = -1;
            for (int i : idx) {
                if (directions.charAt(i) == 'R') {
                    st[++top] = i;
                    continue;
                }
                while (top >= 0) {
                    int j = st[top];
                    if (healths[j] > healths[i]) {
                        healths[i] = 0;
                        healths[j]--;
                        break;
                    }
                    if (healths[j] == healths[i]) {
                        healths[i] = 0;
                        healths[j] = 0;
                        top--;
                        break;
                    }
                    healths[i]--;
                    healths[j] = 0;
                    top--;
                }
            }

            List<Integer> ans = new ArrayList<>();
            for (int h : healths) {
                if (h > 0) {
                    ans.add(h);
                }
            }
            return ans;
        }
    }

}
