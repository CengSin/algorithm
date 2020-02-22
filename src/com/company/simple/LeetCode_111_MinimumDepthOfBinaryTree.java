package com.company.simple;


import com.company.simple.datastruct.TreeNode;

/**
 * 求二叉树的最小深度
 * @author zhangzetao
 */
class LeetCode_111_solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.right == null || root.left == null) return minDepth(root.left == null ? root.right : root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}

public class LeetCode_111_MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        assert fTest() == 0;
        assert fTest1() == 2;
        assert fTest2() == 1;
        assert fTest3() == 2;
    }

    private static int fTest3() {
        LeetCode_111_solution solution = new LeetCode_111_solution();
        return solution.minDepth(new TreeNode(1, new TreeNode(2), null));
    }

    private static int fTest() {
        LeetCode_111_solution solution = new LeetCode_111_solution();
        return solution.minDepth(null);
    }

    private static int fTest2() {
        LeetCode_111_solution solution = new LeetCode_111_solution();
        return solution.minDepth(new TreeNode(1));
    }


    private static int fTest1() {
        LeetCode_111_solution solution = new LeetCode_111_solution();
        return solution.minDepth(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))));
    }

}
