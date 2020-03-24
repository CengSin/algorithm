package com.company.simple;

import java.util.Arrays;

/**
 * @description: 增减字符串匹配
 *
 * 题目： https://leetcode-cn.com/problems/di-string-match/
 * 题解： https://leetcode-cn.com/problems/di-string-match/
 *
 * 分析
 *
 * 我们首先考虑字符串中的第一个字母。如果 S[0] == 'I'，那么我们只要令 A[0] = 0，就一定能满足 A[0] < A[1]。如果 S[0] == 'D'，同样我们只要令 A[0] = N，就一定能满足 A[0] > A[1]。
 *
 * 接下来，当我们考虑 S 中剩下的 N - 1 个字母时，还剩下 N 个数可以使用，这 N 个数为 [0 .. N - 1] 或 [1 .. N]。可以发现，由于 S[0] 的值已经确定，那么剩下 S 中的 N - 1 个字母和 N 个可用的数变成了一个和原问题相同，但规模为 N - 1 的问题。即如果 S[1] == 'I'，我们就令 A[1] 为剩下数中最小的那个数；如果 S[1] == 'D'，我们就令 A[1] 为剩下数中最大的那个数。
 *
 * 我们每次会把可以使用的数的集合中的最小值或最大值取出，并放到当前的位置，因此可以使用的数的集合总是连续的，就可以非常方便的进行维护。
 *
 * 算法
 *
 * 我们维护当前未使用的最小和最大的数，它们对应的区间为当前未使用的数的集合。从左向右扫描字符串，如果碰到 'I'，就取出当前最小的数，否则取出当前最大的数。
 *
 * @author: 15262
 * @date: 2020/3/24
 */

class LeetCode_942_Solution {
    public int[] diStringMatch(String S) {
        int low = 0;
        int high = S.length();
        int[] ans = new int[S.length() + 1];

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                ans[i] = low++;
            } else {
                ans[i] = high--;
            }
        }

        ans[S.length()] = high;
        return ans;
    }
}

public class LeetCode_942_DIStringMatch {

    public static void main(String[] args) {
        LeetCode_942_Solution solution = new LeetCode_942_Solution();
        System.out.println(Arrays.toString(solution.diStringMatch("IDID")));
        System.out.println(Arrays.toString(solution.diStringMatch("III")));
    }

}
