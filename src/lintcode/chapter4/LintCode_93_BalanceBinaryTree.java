package lintcode.chapter4;

import com.company.simple.datastruct.TreeNode;

class LintCode_93_Solution {

    private final int NO_BALANCED = -1;

    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != NO_BALANCED;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left == NO_BALANCED || right == NO_BALANCED) {
            return NO_BALANCED;
        }
        if (Math.abs(left - right) > 1) {
            return NO_BALANCED;
        }
        return Math.max(left, right) + 1;
    }
}

public class LintCode_93_BalanceBinaryTree {
}
