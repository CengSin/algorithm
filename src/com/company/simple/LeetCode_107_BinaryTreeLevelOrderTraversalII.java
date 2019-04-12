package com.company.simple;

import com.company.simple.datastruct.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * <p>
 * 思路：
 * 使用栈
 * 层次遍历，倒序输出
 */

class Solution_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> list = new LinkedList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size -- > 0) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            list.addFirst(level);
        }
        return list;
    }

}

public class LeetCode_107_BinaryTreeLevelOrderTraversalII {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3, new TreeNode(9, null, null),
                new TreeNode(20, new TreeNode(15, null, null), new TreeNode(17, null, null)));
        Solution_107 s = new Solution_107();
        System.out.println(s.levelOrderBottom(t));
        System.out.println(s.levelOrderBottom(null));

        TreeNode t1 = new TreeNode(3, new TreeNode(9, null, null),
                new TreeNode(20, new TreeNode(15, null, null), null));
        System.out.println(s.levelOrderBottom(t1));
    }

}
