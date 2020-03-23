package com.company.simple;

import com.company.simple.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 二叉树的堂兄弟节点
 * @author: 15262
 * @date: 2020/3/23
 */

class LeetCode_993_Solution {

    TreeNode xParent;
    TreeNode yParent;
    int xHight;
    int yHight;

    /**
     * 深度遍历
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousinsNew(TreeNode root, int x, int y) {
        dfs(root, x, y, 0, null);
        return xHight == yHight && !xParent.equals(yParent);
    }

    private void dfs(TreeNode root, int x, int y, int deepth, TreeNode parent) {
        if (root == null) return;
        deepth ++;
        if (root.val == x) {
            xParent = parent;
            xHight = deepth;
        }

        if (root.val == y) {
            yParent = parent;
            yHight = deepth;
        }

        dfs(root.left, x, y, deepth, root);
        dfs(root.right, x, y, deepth, root);
    }

    /**
     * 层次遍历
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (queue.size() > 0) {

            int count = queue.size();

            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                    if (node.left != null && node.right != null && ((node.left.val == x && y ==  node.right.val) || (x == node.right.val && y == node.left.val))) return false;
                }
            }

            if (list.contains(x) && list.contains(y)) {
                return true;
            }

        }

        return false;
    }

}

public class LeetCode_993_CousinsInBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));
        LeetCode_993_Solution solution = new LeetCode_993_Solution();
        /*System.out.println(solution.isCousins(root, 4, 3));
        root = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(5)));
        System.out.println(solution.isCousins(root, 4, 5));
        root = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));
        System.out.println(solution.isCousins(root, 2, 3));*/

        root = new TreeNode(1, new TreeNode(2, new TreeNode(3, null, new TreeNode(7)), new TreeNode(8)), new TreeNode(4, new TreeNode(6), new TreeNode(5)));
        System.out.println(solution.isCousinsNew(root, 5, 8));
    }

}
