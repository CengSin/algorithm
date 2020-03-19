package com.company.simple;

import com.company.simple.datastruct.TreeNode;

/**
 * @description: 二叉累加树
 * @author: zhangzetao
 * @date: 2020/3/19
 */

class LeetCode_538_Solution {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    /**
     * 先遍历右子树，根节点等于根节点+右节点，左节点等于根节点的和 + 左节点
     * @param root
     */
    private void dfs(TreeNode root) {
        if (root != null){
            dfs(root.right);
            sum += root.val;
            root.val = sum;
            dfs(root.left);
        }
    }

    public void dfsPrint(TreeNode root) {
        if (root != null) {
            dfsPrint(root.right);
            System.out.print(root.val + " ");
            dfsPrint(root.left);
        }
    }

}

public class LeetCode_538_ConvertBST2GreaterTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(2), new TreeNode(13));
        LeetCode_538_Solution solution = new LeetCode_538_Solution();
        solution.convertBST(root);
        solution.dfsPrint(root);
        root = new TreeNode(2, new TreeNode(0, new TreeNode(1), new TreeNode(-4)), new TreeNode(1));
        solution.convertBST(root);
        solution.dfsPrint(root);
    }

}
