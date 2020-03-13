package com.company.simple;

import com.company.simple.datastruct.TreeNode;

/**
 * @description: 检查平衡性
 * @author: zhangzetao
 * @date: 2020/3/13
 */

class LeetCode_04_04_Solution {

    public boolean isBalanced(TreeNode root) {

        try {
            getTreeDeep(root);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    private int getTreeDeep(TreeNode root) {
        if (root != null) {
            // 拿到左子树的高度
            int leftDeep = getTreeDeep(root.left) + 1;
            // 拿到右子树的高度
            int rightDeep = getTreeDeep(root.right) + 1;
            if (Math.abs(leftDeep - rightDeep) > 1) {
                throw new RuntimeException("不是平衡二叉树");
            }
            return Math.max(leftDeep, rightDeep);
        }
        return 0;
    }

}

public class LeetCode_04_04_CheckBalanceLCCI {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        LeetCode_04_04_Solution solution = new LeetCode_04_04_Solution();
        System.out.println(solution.isBalanced(root));

        root = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));
        System.out.println(solution.isBalanced(root));

        root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        System.out.println(solution.isBalanced(root));
    }

}
