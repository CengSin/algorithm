package lintcode.chapter4;

import com.company.simple.datastruct.TreeNode;

class LintCode_97_Solution {

    private int maxDepth;
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        maxDepth = 0;
        dfs(root, 1);
        return maxDepth;
    }

    private void dfs(TreeNode root, int currDepth) {
        if (root == null) return ;
        maxDepth = Math.max(currDepth, maxDepth);
        dfs(root.left, currDepth + 1);
        dfs(root.right, currDepth + 1);
    }

    private int divide(TreeNode root) {
        if (root == null) return 0;
        int left = divide(root.left);
        int right = divide(root.right);
        return Math.max(left, right) + 1;
    }
}

public class LintCode_97_MaximumPepthOfBinaryTree {
}
