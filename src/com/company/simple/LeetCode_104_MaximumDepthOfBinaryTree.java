package com.company.simple;

import com.company.simple.datastruct.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * 思路：
 * <p>
 * 最大深度 = max(左子树，右子树)+1
 */

class Solution_104 {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

public class LeetCode_104_MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3, new TreeNode(9, null, null),
                new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
        Solution_104 s = new Solution_104();
        long startTime = System.currentTimeMillis();
        System.out.println(s.maxDepth(t));
        System.out.println(System.currentTimeMillis() - startTime);
    }

}
