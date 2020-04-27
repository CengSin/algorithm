package lintcode.chapter4;

import com.company.simple.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

class LintCode_68_Solution {
    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return ;
        dfs(root.left, res);
        dfs(root.right, res);
        res.add(root.val);
    }
}

public class LintCode_68_BinaryTreePostorderTraversal {
}
