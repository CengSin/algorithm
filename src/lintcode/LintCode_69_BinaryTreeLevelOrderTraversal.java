package lintcode;

import com.company.simple.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class LintCode_69_Solution {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        // write your code here
        List<List<Integer>> levelTraversal = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        initTraversals(root, levelTraversal, queue);
        List<Integer> level;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    level.add(node.left.val);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    level.add(node.right.val);
                    queue.offer(node.right);
                }
            }
            if (level.size() > 0) levelTraversal.add(level);
        }

        return levelTraversal;
    }

    private void initTraversals(TreeNode root, List<List<Integer>> levelTraversal, Queue<TreeNode> queue) {
        queue.offer(root);
        List<Integer> level = new ArrayList<>();
        level.add(root.val);
        levelTraversal.add(level);
    }

}

public class LintCode_69_BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {

    }

}
