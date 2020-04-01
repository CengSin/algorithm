package com.company.simple;

import java.util.Arrays;

/**
 * @description: 有效括号的嵌套深度(把括号下标分开放到两个数组中，是两个数组中的括号深度差最小即可)
 * @author: 15262
 * @date: 2020/4/1
 */

class LeetCode_1111_Solution {
    public int[] maxDepthAfterSplit(String seq) {
        if (seq == null || seq.length() == 0) return new int[0];
        int[] ans = new int[seq.length()];
        int depth = 0;
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                depth++;
                ans[i] = (depth % 2);
            } else {
                ans[i] = (depth % 2);
                depth--;
            }
        }
        return ans;
    }
}

public class LeetCode_1111_MaxDepthAfterSplit {

    public static void main(String[] args) {
        LeetCode_1111_Solution solution = new LeetCode_1111_Solution();
        System.out.println(Arrays.toString(solution.maxDepthAfterSplit("(()())")));
    }

}
