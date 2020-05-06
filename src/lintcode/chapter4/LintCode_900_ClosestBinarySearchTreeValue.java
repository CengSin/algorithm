package lintcode.chapter4;

import com.company.simple.datastruct.TreeNode;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 *
 * 分治法和遍历法
 *
 * 遍历法，遍历二叉树的每个节点，找到与指定节点差值最小的节点
 *
 */

class LintCode_900_Solution_Foreach {

    private double distance;
    private int value;
    private double target;

    /**
     *
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        distance = Integer.MAX_VALUE;
        value = 0;
        this.target = target;
        dfs(root);
        return value;
    }

    private void dfs(TreeNode root) {
        if (root == null) return ;
        dfs(root.left);
        double abs = Math.abs(root.val - target);
        if (distance > abs) {
            distance = abs;
            value = root.val;
        }
        dfs(root.right);
    }
}

class LintCode_900_Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        if (root == null) return 0;

        TreeNode lowerNode = lowerBound(root, target);
        TreeNode upperNode = upperBound(root, target);

        if (lowerNode == null) return upperNode.val;

        if (upperNode == null) return lowerNode.val;

        if (target - lowerNode.val > upperNode.val - target) {
            return upperNode.val;
        }
        return lowerNode.val;
    }

    private TreeNode lowerBound(TreeNode root, double target) {
        if (root == null) return null;

        if (root.val >= target) {
            return lowerBound(root.left, target);
        }

        TreeNode lowerNode = lowerBound(root.right, target);
        if (lowerNode != null) {
            return lowerNode;
        }
        return root;
    }

    private TreeNode upperBound(TreeNode root, double target) {
        if (root == null) return null;

        if (root.val < target) {
            return upperBound(root.right, target);
        }

        TreeNode upperNode = upperBound(root.left, target);
        if (upperNode != null) {
            return upperNode;
        }
        return root;
    }

}

public class LintCode_900_ClosestBinarySearchTreeValue {
}
