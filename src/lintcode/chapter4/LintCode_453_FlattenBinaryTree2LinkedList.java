package lintcode.chapter4;

import com.company.simple.datastruct.TreeNode;

class LintCode_453_Solution {

    private TreeNode lastNode; // 用lastNode来表示当前假链表的最后一个节点

    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        if (root == null) return;

        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }

        lastNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
}

public class LintCode_453_FlattenBinaryTree2LinkedList {
}
