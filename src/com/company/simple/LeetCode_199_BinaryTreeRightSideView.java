package com.company.simple;

import com.company.simple.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的右侧视图，宽度优先搜索，把每层的最后一个节点添加进去，就是其右侧视图
 */
class LeetCode_199_Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        bfs(root, res);
        return res;
    }

    private void bfs(TreeNode root, List<Integer> res) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
    }

}

public class LeetCode_199_BinaryTreeRightSideView {

    public static void main(String[] args) {

    }

}
