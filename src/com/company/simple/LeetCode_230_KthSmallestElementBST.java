package com.company.simple;

import com.company.simple.datastruct.TreeNode;

import java.util.Arrays;

/**
 * @description: 返回二叉树中第k个最小的元素
 * @author: 15262
 * @date: 2020/3/12
 */

class LeetCode_230_Solution {

    public int kthSmallest(TreeNode root, int k) {
        int[] arr = new int[1000];
        if (k > arr.length) {
            arr = Arrays.copyOf(arr, k - arr.length + 1);
            for (int i = arr.length; i <= k; i++) {
                arr[i] = Integer.MIN_VALUE;
            }
        }
        if (arr[k] == Integer.MIN_VALUE) {
            dfs(root, k, 0, arr);
        }
        return arr[k];
    }

    private void dfs(TreeNode root, int k, int count, int[] arr) {
        if (root != null) {
            dfs(root.left, k, count, arr);
            count++;
            if (count == k) {
                arr[count] = root.val;
            }
            dfs(root.right, k, count, arr);
        }
    }
}

public class LeetCode_230_KthSmallestElementBST {

    public static void main(String[] args) {
        LeetCode_230_Solution solution = new LeetCode_230_Solution();
        System.out.println(solution.kthSmallest(new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4)), 1));
        LeetCode_230_Solution solution1 = new LeetCode_230_Solution();
        System.out.println(solution1.kthSmallest(new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6)), 3));
    }

}
