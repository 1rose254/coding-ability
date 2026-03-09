package com.logos.leetcode.hot100.stack;

import java.util.Stack;

/**
 * @author logos
 * date 2026/3/9 16:07
 * @version v1.0
 * @Package com.logos.leetcode.hot100.stack
 */
public class Q02 {

    /**
     * 155. 最小栈
     */

    class MinStack {

        private Stack<int[]> st = new Stack<>();

        public MinStack() {
            st.clear();
        }

        public void push(int val) {
            if (st.isEmpty()) {
                st.push(new int[] { val, val });
            } else {
                int[] tmp = st.peek();
                st.push(new int[] { val, Math.min(tmp[1], val) });
            }
        }

        public void pop() {
            st.pop();
        }

        public int top() {
            return st.peek()[0];
        }

        public int getMin() {
            return st.peek()[1];
        }
    }

}
