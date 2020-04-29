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
 */

class ResultType {
    public boolean isBST;
    public TreeNode minNode, maxNode;

    public ResultType(boolean isBST) {
        this.isBST = isBST;
        this.minNode = null;
        this.maxNode = null;
    }
}

class LintCode_95_Solution {

    // 当前节点的上一个节点
    private TreeNode lastNode;

    // 是否是一个有效的二叉搜索树
    private boolean isValid;

    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     *
     * 二叉搜索树的特点是：左子节点的值小于根节点的值，右子节点的值大于根节点的值，所以二叉搜索树的中序遍历是非递减的。
     *
     * 节点的左子树中的值要严格小于该节点的值。
     * 节点的右子树中的值要严格大于该节点的值。
     *
     * 所以这道题目中的二叉搜索树的中序遍历是单调递增的
     */
    public boolean isValidBST(TreeNode root) {
        lastNode = null;
        isValid = true;
        dfs(root);
        return isValid;
    }

    /**
     * 分治法
     * @return
     */
    private ResultType divideConquer(TreeNode root) {
        if (root == null) return new ResultType(true);

        ResultType left = divideConquer(root.left);
        ResultType right = divideConquer(root.right);

        if (!left.isBST || !right.isBST) {
            return new ResultType(false);
        }

        if (left.maxNode != null && left.maxNode.val >= root.val) {
            return new ResultType(false);
        }

        if (right.minNode != null && right.minNode.val <= root.val) {
            return new ResultType(false);
        }

        // isBST
        ResultType result = new ResultType(true);
        result.minNode = left.minNode != null ? left.minNode : root;
        result.maxNode = right.maxNode != null ? right.maxNode : root;
        return result;
    }

    /**
     * 遍历法
     * @param root
     */
    private void dfs(TreeNode root) {
        if (root == null) {
            isValid = true;
            return;
        }
        dfs(root.left);
        if (lastNode != null && lastNode.val >= root.val) {
            isValid = false;
            return ;
        }
        lastNode = root;
        dfs(root.right);
    }
}

public class LintCode_95_ValidateBinarySearchTree {
}
