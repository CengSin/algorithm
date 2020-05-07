package com.company.may;

import com.company.simple.datastruct.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class LeetCode_572_Solution {

    // t == s || t == s.left || t==s.right
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return subFrom(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean subFrom(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return subFrom(s.left, t.left) && subFrom(s.right, t.right);
    }

}

public class LeetCode_572_SubtreeOfAnotherTree {
}
