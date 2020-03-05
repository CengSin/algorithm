package com.company.simple;

import java.util.Arrays;

/**
 * @description: 分饼干
 * @author: 15262
 * @date: 2020/3/5
 */

class LeetCode_455_Solution {

    /**
     *
     * @param g 孩子
     * @param s 饼干
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0) return 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;

        for (int i = g.length - 1, j = s.length - 1; j >= 0 && i >= 0; ) {
            if (g[i] == s[j] || g[i] < s[j]) {
                i--;
                j--;
                count++;
            } else if (g[i] > s[j]) {
                i--;
            }
        }

        return count;
    }

}

public class LeetCode_455_AssignCookies {

    public static void main(String[] args) {
        LeetCode_455_Solution solution = new LeetCode_455_Solution();
        System.out.println(solution.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(solution.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    }
}
