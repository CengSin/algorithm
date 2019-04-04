package com.company.simple;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 * <p>
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:      1          1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * 输出: false
 * 示例 3:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * <p>
 * 输出: false
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }
}

class Solution_100 {

    /**
     * 将所有的可能情况抽象出来容易被判断的，例如两个都等于null， 两个都不等于null（判断值是否相同）， 一个为null另一个不为null
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p != null && q != null && p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else return false;
    }

}

public class LeetCode_100_SameTree {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        TreeNode t2 = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        TreeNode t1 = new TreeNode(1, null, new TreeNode(3, null, null));
        Solution_100 s = new Solution_100();
        System.out.println(s.isSameTree(t, t1));
        System.out.println(s.isSameTree(t, t2));

    }

}
