package com.company.simple;

import com.company.simple.datastruct.TreeNode;

/**
 * 对称二叉树
 *
 * 将树自己和自己做对比，如果自己的左节点 == 自己的右节点，并且自己的右节点等于自己的左节点则为真
 *
 */

class Solution_101 {

    private boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        else if (node1 != null && node2 != null && node1.val == node2.val) return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
}

public class LeetCode_101_Symmetric_Tree {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1,
                new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null)),
                new TreeNode(2, new TreeNode(4, null, null), new TreeNode(3, null, null)));
        TreeNode t1 = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3, null, null)),
                new TreeNode(2, null, new TreeNode(3, null, null)));
        Solution_101 s = new Solution_101();
        System.out.println(s.isSymmetric(t));
        System.out.println(s.isSymmetric(t1));
    }

}
