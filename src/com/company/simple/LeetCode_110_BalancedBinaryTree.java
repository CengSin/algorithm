package com.company.simple;

import com.company.simple.datastruct.TreeNode;

/**
 * @author zhangzetao
 * @time 2020-02-22
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class LeetCode_110_Solution {

    private int leftNodeNum;

    private int rightNodeNum;

    public LeetCode_110_Solution() {
        leftNodeNum = 0;
        rightNodeNum = 0;
    }

    /**
     * 首先检查叶子节点的深度，之后逐层往上加，在比较
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root != null) {
            leftNodeNum = getNodeDeep(root.left);
            rightNodeNum = getNodeDeep(root.right);
            return Math.abs(leftNodeNum - rightNodeNum) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
        return true;
    }

    public int getNodeDeep(TreeNode root) {
        if (root != null) {
            return Math.max(getNodeDeep(root.right), getNodeDeep(root.left)) + 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "LeetCode_110_Solution{" +
                "leftNodeNum=" + leftNodeNum +
                ", rightNodeNum=" + rightNodeNum +
                '}';
    }
}

public class LeetCode_110_BalancedBinaryTree {

    public static void main(String[] args) {
        assert fTest1();
        assert !fTest2();
        assert !fTest3();
        assert !fTest4();
    }

    private static boolean fTest4() {
        LeetCode_110_Solution solution3 = new LeetCode_110_Solution();
        TreeNode test4 = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(4, new TreeNode(3), new TreeNode(5, null, new TreeNode(6))));
        return solution3.isBalanced(test4);
    }

    private static boolean fTest3() {
        LeetCode_110_Solution solution2 = new LeetCode_110_Solution();
        TreeNode test3 = new TreeNode(1,
                new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null),
                new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));
        return solution2.isBalanced(test3);
    }

    private static boolean fTest2() {
        LeetCode_110_Solution solution1 = new LeetCode_110_Solution();
        TreeNode test2 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4),
                                new TreeNode(4)),
                        new TreeNode(3)),
                new TreeNode(2));
        return solution1.isBalanced(test2);
    }

    private static boolean fTest1() {
        LeetCode_110_Solution solution = new LeetCode_110_Solution();
        TreeNode test1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        return solution.isBalanced(test1);
    }

}
