package com.company.may;

import com.company.simple.datastruct.TreeNode;

/**
 * 二叉树的最近公共祖先 LCA问题 分治法
 */
class LeetCode_236_Solution {

    /**
     * 一个节点也可以是它自己的祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || (root == q || root == p)) {
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if (leftNode != null && rightNode != null) {
            return root;
        } else if (leftNode != null) {
            return leftNode;
        } else if (rightNode != null){
            return rightNode;
        }
        return null;
    }

}

public class LeetCode_236_LowestCommonAncestorBinaryTree {
}
