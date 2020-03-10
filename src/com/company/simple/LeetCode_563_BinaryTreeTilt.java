package com.company.simple;

import com.company.simple.datastruct.TreeNode;

/**
 * @description: 二叉树的坡度
 * @author: zhangzetao
 * @date: 2020/3/10
 */

class LeetCode_563_Solution {

    private int tilt;

    public int findTilt(TreeNode root) {
        tilt = 0;
        dfs(root);
        return tilt;
    }

    private int dfs(TreeNode root) {
        if (root != null) {
            int leftTilt = dfs(root.left); // 左节点的值
            int rightTilt = dfs(root.right); // 左节点的值
            int selfTilt = Math.abs(leftTilt - rightTilt); // 节点自身的坡度
            tilt = tilt + selfTilt;
            return root.val + leftTilt + rightTilt;  // 自身以及子节点之和
        }
        return 0;
    }
}

public class LeetCode_563_BinaryTreeTilt {

    public static void main(String[] args) {
        LeetCode_563_Solution solution = new LeetCode_563_Solution();
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(solution.findTilt(treeNode));

        treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), null));
        System.out.println(solution.findTilt(treeNode));

        treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), null);
        System.out.println(solution.findTilt(treeNode));
    }

}
