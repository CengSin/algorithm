package lintcode.chapter4;

import com.company.simple.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res); // 中序遍历
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return;
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }
}

public class LintCode_67_BinaryTreeInorderTraversal {
}
