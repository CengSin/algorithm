package com.company.simple;

import com.company.simple.datastruct.TreeNode;

import java.util.*;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/4/5
 */

class LeetCode_501_Solution {

    private int maxCnt = 1;

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        dfs(root, map);
        List<Integer> res = new ArrayList<>();
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            Integer value = map.get(key);
            if (value == maxCnt) {
                res.add(key);
            }
        }
        int[] ans = new int[res.size()];
        int k = 0;
        for (Integer re : res) {
            ans[k++] = re;
        }
        return ans;
    }

    private void dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root != null) {
            dfs(root.left, map);
            dfs(root.right, map);
            if (map.containsKey(root.val)) {
                Integer value = map.get(root.val);
                if (value + 1> maxCnt) {
                    maxCnt = value + 1;
                }
                map.put(root.val, value + 1);
            } else {
                map.put(root.val, 1);
            }
        }
    }

}

public class LeetCode_501_FindModeBinarySearchTree {

    public static void main(String[] args) {
        LeetCode_501_Solution solution = new LeetCode_501_Solution();
        // System.out.println(Arrays.toString(solution.findMode(new TreeNode(1, null, new TreeNode(2, new TreeNode(2), null)))));
        System.out.println(Arrays.toString(solution.findMode(new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3))))));
    }

}
