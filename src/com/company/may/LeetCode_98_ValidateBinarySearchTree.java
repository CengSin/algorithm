package com.company.may;

import com.company.simple.datastruct.TreeNode;

class ResultType {
    boolean isBST;
    TreeNode minNode;
    TreeNode maxNode;

    public ResultType(boolean isBST) {
        this.isBST = isBST;
        this.minNode = null;
        this.maxNode = null;
    }
}

class LeetCode_98_Solution {

    public boolean isValidBST(TreeNode root) {
        return divideConquer(root).isBST;
    }

    private ResultType divideConquer(TreeNode root) {
        if (root == null) return new ResultType(true);

        ResultType leftRes = divideConquer(root.left);
        ResultType rightRes = divideConquer(root.right);

        if (!leftRes.isBST || !rightRes.isBST) {
            return new ResultType(false);
        }

        if (leftRes.maxNode != null && leftRes.maxNode.val >= root.val) {
            return new ResultType(false);
        }

        if (rightRes.minNode != null && rightRes.minNode.val <= root.val) {
            return new ResultType(false);
        }

        ResultType result = new ResultType(true);
        result.minNode = leftRes.minNode != null ? leftRes.minNode : root;
        result.maxNode = rightRes.maxNode != null ? rightRes.maxNode : root;
        return result;
    }

}

public class LeetCode_98_ValidateBinarySearchTree {
}
