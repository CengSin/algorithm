package com.company.simple;

import com.company.simple.datastruct.TreeNode;

class LeetCode_700_Solution {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val == val) {
            return root;
        }if (val > root.val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

}

public class LeetCode_700_SearchInBinarySearch {
}
