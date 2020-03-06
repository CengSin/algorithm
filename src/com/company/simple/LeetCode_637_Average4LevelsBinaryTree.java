package com.company.simple;

import com.company.simple.datastruct.TreeNode;

import java.util.*;

/**
 * @description: 二叉树的层平均值
 * @author: 15262
 * @date: 2020/3/6
 */

class LeetCode_637_Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Double> avgs = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (queue.size() > 0) {
            int cnt = queue.size();
            double sum = 0;
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            avgs.add(sum / cnt);
        }
        return avgs;
    }
}

public class LeetCode_637_Average4LevelsBinaryTree {

    public static void main(String[] args) {
        LeetCode_637_Solution solution = new LeetCode_637_Solution();
        TreeNode root = new TreeNode(3, new TreeNode(9, new TreeNode(15), null), new TreeNode(20, new TreeNode(7), null));
        System.out.println(solution.averageOfLevels(root));
    }

}
