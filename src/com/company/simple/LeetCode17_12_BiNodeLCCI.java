package com.company.simple;

import com.company.simple.datastruct.TreeNode;

/**
 * @description: BiNode 中序遍历
 * @author: 15262
 * @date: 2020/3/7
 */

class LeetCode17_12_Solution {

    private TreeNode head;

    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) return null;
        head = new TreeNode(0);
        TreeNode f = head;
        dfs(root);
        return f.right;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            head.right = root;
            root.left = null;
            head = head.right;
            dfs(root.right);
        }
    }
}

public class LeetCode17_12_BiNodeLCCI {

    public static void main(String[] args) {
        LeetCode17_12_Solution solution = new LeetCode17_12_Solution();
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1, new TreeNode(0), null), new TreeNode(3)), new TreeNode(5, null, new TreeNode(6)));
        solution.convertBiNode(root);
    }

}

