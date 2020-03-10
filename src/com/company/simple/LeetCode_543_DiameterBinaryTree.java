package com.company.simple;

import com.company.simple.datastruct.TreeNode;

/**
 * @description: 二叉树的直径
 * @author: 15262
 * @date: 2020/3/10
 */
class LeetCode_543_Solution {

    private int max;  // 二叉树的最大直径 可能会有某个子树的直径大于整个二叉树的直径，
    // 所以不能直接遍历整个二叉树，而要把所有子树求出来的直径对比，找出最大的那一个,比如[1,2,3,4,5, null, null, 6, null, null, 7]这种情况的最大值是4，不是3

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        max = 0;
        dfs(root.left);
        dfs(root.right);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root != null) {
            int left = dfs(root.left);
            int right = dfs(root.right);
            max = Math.max(max, left + right);
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}

public class LeetCode_543_DiameterBinaryTree {

    public static void main(String[] args) {
        LeetCode_543_Solution solution = new LeetCode_543_Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(solution.diameterOfBinaryTree(root));
    }

}
