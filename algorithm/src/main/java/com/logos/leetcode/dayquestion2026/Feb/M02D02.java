package com.logos.leetcode.dayquestion2026.Feb;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author logos
 * date 2026/2/2 19:59
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D02 {


    /**
     * 3013. 将数组分成最小总代价的子数组 II
     * <a href="https://leetcode.cn/problems/divide-an-array-into-subarrays-with-minimum-cost-ii/description/"/>
     */

    class Solution {
        public long minimumCost(int[] nums, int k, int dist) {
            k--;
            sumL = nums[0];
            for (int i = 1; i < dist + 2; i++) {
                sumL += nums[i];
                L.merge(nums[i], 1, Integer::sum);
            }
            sizeL = dist + 1;
            while (sizeL > k) {
                l2r();
            }

            long ans = sumL;
            for (int i = dist + 2; i < nums.length; i++) {
                int out = nums[i - dist - 1];
                if (L.containsKey(out)) {
                    sumL -= out;
                    sizeL--;
                    removeOne(L, out);
                } else {
                    removeOne(R, out);
                }

                int in = nums[i];
                if (in < L.lastKey()) {
                    sumL += in;
                    sizeL++;
                    L.merge(in, 1, Integer::sum);
                } else {
                    R.merge(in, 1, Integer::sum);
                }

                if (sizeL == k - 1) {
                    r2l();
                } else if (sizeL == k + 1) {
                    l2r();
                }

                ans = Math.min(ans, sumL);
            }
            return ans;
        }

        private long sumL;
        private int sizeL;
        private final TreeMap<Integer, Integer> L = new TreeMap<>();
        private final TreeMap<Integer, Integer> R = new TreeMap<>();

        private void l2r() {
            int x = L.lastKey();
            removeOne(L, x);
            sumL -= x;
            sizeL--;
            R.merge(x, 1, Integer::sum);
        }

        private void r2l() {
            int x = R.firstKey();
            removeOne(R, x);
            sumL += x;
            sizeL++;
            L.merge(x, 1, Integer::sum);
        }

        private void removeOne(Map<Integer, Integer> m, int x) {
            int cnt = m.get(x);
            if (cnt > 1) {
                m.put(x, cnt - 1);
            } else {
                m.remove(x);
            }
        }
    }

}
