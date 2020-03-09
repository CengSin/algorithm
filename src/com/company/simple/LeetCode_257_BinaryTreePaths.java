package com.company.simple;

import com.company.simple.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 二叉树的所有路径
 * @author: 15262
 * @date: 2020/3/9
 */
class LeetCode_257_Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> allPaths = new ArrayList<>();
        if (root != null) dfs(root, allPaths, "");
        return allPaths;
    }

    private void dfs(TreeNode root, List<String> allPaths, String s) {
        if ("".equals(s)) {
            s = root.val + "";
        } else {
            s = s + "->" + root.val;
        }
        if (root.left == null && root.right == null) {
            allPaths.add(s);
        }

        if (root.left != null) dfs(root.left, allPaths, s);

        if (root.right != null) dfs(root.right, allPaths, s);
    }
}

public class LeetCode_257_BinaryTreePaths {

    public static void main(String[] args) {
        LeetCode_257_Solution solution = new LeetCode_257_Solution();
        TreeNode simple = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(solution.binaryTreePaths(simple));
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        System.out.println(solution.binaryTreePaths(root));
    }

}
