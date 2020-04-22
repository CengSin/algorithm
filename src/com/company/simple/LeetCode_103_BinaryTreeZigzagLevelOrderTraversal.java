package com.company.simple;

import com.company.simple.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class LeetCode_103_Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        bfs(root, res);
        return res;
    }

    private void bfs(TreeNode root, List<List<Integer>> res) {
        boolean isLeftStart = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (!isLeftStart) {
                    list.add(0, node.val);
                } else {
                    list.add(node.val);
                }
            }
            res.add(list);
            isLeftStart = !isLeftStart;
        }
    }

}

public class LeetCode_103_BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {

    }

}
