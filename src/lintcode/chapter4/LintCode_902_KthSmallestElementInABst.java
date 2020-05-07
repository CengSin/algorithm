package lintcode.chapter4;

import com.company.simple.datastruct.TreeNode;

import java.util.PriorityQueue;
import java.util.Queue;

class LintCode_902_Solution {

    private Queue<Integer> queue;
    private int k;

    /**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        queue = new PriorityQueue<>(k, Integer::compareTo);
        this.k = k;

        dfs(root);
        return queue.poll();
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        if (queue.size() > k) {
            queue.poll();
        }
        queue.offer(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}

public class LintCode_902_KthSmallestElementInABst {
}
