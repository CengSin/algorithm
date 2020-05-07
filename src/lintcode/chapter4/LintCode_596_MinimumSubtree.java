package lintcode.chapter4;


import com.company.simple.datastruct.TreeNode;

/**
 * 最小子树
 *
 * 就是查询和为最小的子树
 */

class LintCode_596_ResultType {
    TreeNode minSubtree;
    int sum, minSum;

    public LintCode_596_ResultType(TreeNode minSubTree, int sum, int minSum) {
        this.minSubtree = minSubTree;
        this.sum = sum;
        this.minSum = minSum;
    }
}

class LintCode_596_Solution {
    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        LintCode_596_ResultType result = helper(root);
        return result.minSubtree;
    }

    public LintCode_596_ResultType helper(TreeNode node) {
        if (node == null) {
            return new LintCode_596_ResultType(null, Integer.MAX_VALUE, 0);
        }

        LintCode_596_ResultType leftResult = helper(node.left);
        LintCode_596_ResultType rightResult = helper(node.right);

        LintCode_596_ResultType result = new LintCode_596_ResultType(
                node,
                leftResult.sum + rightResult.sum + node.val,
                leftResult.sum + rightResult.sum + node.val
        );

        if (leftResult.minSum <= result.minSum) {
            result.minSum = leftResult.minSum;
            result.minSubtree = leftResult.minSubtree;
        }

        if (rightResult.minSum <= result.minSum) {
            result.minSum = rightResult.minSum;
            result.minSubtree = rightResult.minSubtree;
        }

        return result;
    }
}

public class LintCode_596_MinimumSubtree {
}
