package com.logos.leetcode.dayquestion2026.Nov;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/23 11:22
 * @version v1.0
 */
public class M11D23 {


    /**
     * 1352. 最后 K 个数的乘积
     * <a href="https://leetcode.cn/problems/product-of-the-last-k-numbers/description/"/>
     */

    class ProductOfNumbers {
        private final List<Integer> p = new ArrayList<>();

        public ProductOfNumbers() {
            p.add(1);
        }

        public void add(int num) {
            if (num != 0) {
                p.add(p.getLast() * num);
            } else {
                p.clear();
                p.add(1);
            }
        }

        public int getProduct(int k) {
            int n = p.size();
            if (n <= k) {
                return 0;
            }
            return p.getLast() / p.get(n - 1 - k);
        }
    }

}
