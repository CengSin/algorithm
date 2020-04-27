package lintcode.chapter4;


import com.company.simple.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

class LintCode_66_Solution {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return ;
        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }

}

public class LintCode_66_BinaryTreePreorderTraversal {



}
