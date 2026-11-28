package com.logos.leetcode.dayquestion2026.Nov;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/28 10:24
 * @version v1.0
 */
public class M11D28 {

    /**
     * 3947. 购买最多物品数目 II
     * <a href="https://leetcode.cn/problems/maximum-number-of-items-from-sale-ii/description/"/>
     */

    class Solution {
        public int maximumSaleItems(int[][] items, int budget) {
            int n = items.length;
            int[] cntFactor = new int[n + 1];
            int minPrice = Integer.MAX_VALUE;
            for (int[] p : items) {
                cntFactor[p[0]]++;
                minPrice = Math.min(minPrice, p[1]);
            }

            int[] cntMulti = new int[n + 1];
            Map<Integer, Long> sumCnt = new TreeMap<>();

            for (int[] p : items) {
                int factor = p[0], price = p[1];
                if (price >= minPrice * 2) {
                    continue;
                }

                if (cntMulti[factor] == 0) {
                    for (int j = factor; j <= n; j += factor) {
                        cntMulti[factor] += cntFactor[j];
                    }
                }

                int cnt = cntMulti[factor] - 1;
                if (cnt > 0) {
                    sumCnt.merge(price, (long) cnt, Long::sum);
                }
            }

            int ans = 0;
            for (Map.Entry<Integer, Long> e : sumCnt.entrySet()) {
                int price = e.getKey();
                if (budget < price) {
                    break;
                }
                int c = (int) Math.min(e.getValue(), budget / price);
                budget -= price * c;
                ans += c * 2;
            }
            return ans + budget / minPrice;
        }
    }

}
