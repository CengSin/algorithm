package com.company.simple;

import com.company.simple.datastruct.TreeNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zhangzetao
 * @solution https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/108-jiang-you-xu-shu-zu-zhuan-huan-wei-er-cha-s-10/
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class LeetCode_108_Solution {

    private Queue<Integer> queue;

    public LeetCode_108_Solution() {
        this.queue = new PriorityQueue<>();
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return converseDFS(nums, 0, nums.length - 1);
    }

    /**
     * 逆深度遍历
     *
     * @param nums  二叉树的深度遍历结果
     * @param left  起始下标
     * @param right 终止下标记
     * @return 二叉树
     */
    private TreeNode converseDFS(int[] nums, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = converseDFS(nums, left, mid - 1);
            root.right = converseDFS(nums, mid + 1, right);
            return root;
        }
        return null;
    }

    public void DFS(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            if (root.left != null)
                DFS(root.left);
            if (root.right != null)
                DFS(root.right);
        }
        System.out.print("null ");
    }

    /**
     * 层次遍历二叉树
     *
     * @param root 二叉树的根节点
     */
    public void levelTraversal(TreeNode root) {
        if (root != null) {
            if (root.left != null)
                queue.offer(root.left.val);
            if (root.right != null)
                queue.offer(root.right.val);
            levelTraversal(root.left);
            levelTraversal(root.right);
        }
    }

    public Queue<Integer> getQueue() {
        return queue;
    }
}

public class LeetCode_108_SortedArrayToBST {

    public static void main(String[] args) {
        LeetCode_108_Solution solution = new LeetCode_108_Solution();
        TreeNode treeNode = solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println("=====DFS===");
        solution.DFS(treeNode);
        System.out.println("==========");

        System.out.println("=====BFS===");
        solution.levelTraversal(treeNode);
        if (treeNode != null) {
            System.out.print(treeNode.val + " ");
        }
        System.out.println(solution.getQueue());
        System.out.println("==========");
    }

}
