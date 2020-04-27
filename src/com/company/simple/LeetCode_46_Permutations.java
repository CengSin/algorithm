package com.company.simple;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 全排列
 *
 * 深度遍历
 *
 * https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
 */
class LeetCode_46_Solution {
    public List<List<Integer>> permute(int[] nums) {
        // 判断输入是否合法
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return ;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;;
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, used, res);
            used[i] = false;
            path.removeLast();
        }
    }
}

public class LeetCode_46_Permutations {
}
