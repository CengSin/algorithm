package com.company.simple;

import com.company.simple.datastruct.TreeNode;

/**
 * @description: 根据二叉树创建字符串
 * @author: 15262
 * @date: 2020/3/17
 */

class LeetCode_606_Solution {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder sb = new StringBuilder();
        dfs(t, sb);
        return sb.substring(1, sb.length() - 1);
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root != null) {
            sb.append("(").append(root.val);
            if (root.left == null && root.right != null) {
                sb.append("()");
            }
            dfs(root.left, sb);

            dfs(root.right, sb);
            sb.append(")");
        }
    }
}

public class LeetCode_606_ConstructStringFromBinaryTree {

    public static void main(String[] args) {
        LeetCode_606_Solution solution = new LeetCode_606_Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        System.out.println(solution.tree2str(root));

        root = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));
        System.out.println(solution.tree2str(root));
    }

}
