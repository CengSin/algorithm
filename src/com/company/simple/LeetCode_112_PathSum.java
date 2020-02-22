package com.company.simple;

import com.company.simple.datastruct.TreeNode;

class LeetCode_112_Solution {

    /**
     * 思路1：深度遍历二叉树，每经过一个节点，就将sum减去该节点的值。如果sum = 0 的时候左右子树都为空，则返回true。
     * 思路2：深度遍历二叉树，将每个到叶子节点的路径和都算出来，看有没有等于sum的
     *
     * @param root 树根
     * @param sum  求和值
     * @return true | false
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root != null && sum != 0) {

            if (root.left == null && root.right == null) {
                return sum == root.val;
            }

            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
        return false;
    }

}

public class LeetCode_112_PathSum {

    public static void main(String[] args) {
        assert fTest1();
        assert !fTest2();
        assert fTest3();
        assert !fTest4();
    }

    private static boolean fTest4() {
        LeetCode_112_Solution solution = new LeetCode_112_Solution();
        TreeNode root = new TreeNode(1,
                new TreeNode(-2, new TreeNode(1, new TreeNode(-1), null), new TreeNode(3)),
                new TreeNode(-3, new TreeNode(-2), null));
        return solution.hasPathSum(root, 3);
    }

    private static boolean fTest3() {
        LeetCode_112_Solution solution = new LeetCode_112_Solution();
        TreeNode root = new TreeNode(-2, null, new TreeNode(-3));
        return solution.hasPathSum(root, -5);
    }

    private static boolean fTest2() {
        LeetCode_112_Solution solution = new LeetCode_112_Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        return solution.hasPathSum(root, 2);
    }

    private static boolean fTest1() {
        LeetCode_112_Solution solution = new LeetCode_112_Solution();
        TreeNode root = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
        return solution.hasPathSum(root, 22);
    }

}
