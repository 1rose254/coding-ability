package com.logos.leetcode.hot100.graph_theory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author logos
 * date 2026/3/7 20:12
 * @version v1.0
 * @Package com.logos.leetcode.hot100.graph_theory
 */
public class Q03 {

    /**
     * 207. 课程表
     */

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] in = new int[numCourses];
            List<List<Integer>> ans = new ArrayList<>(numCourses);
            Queue<Integer> que = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                ans.add(new ArrayList<>());
            }
            for (int[] p : prerequisites) {
                in[p[0]]++;
                ans.get(p[1]).add(p[0]);
            }
            for (int i = 0; i < numCourses; i++) {
                if (in[i] == 0) {
                    que.add(i);
                }
            }
            while (!que.isEmpty()) {
                numCourses--;
                int tmp = que.poll();
                for (int x : ans.get(tmp)) {
                    if (--in[x] == 0) {
                        que.add(x);
                    }
                }
            }
            return numCourses == 0;
        }
    }

}
