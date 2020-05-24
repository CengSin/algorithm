package com.company.may;

import com.company.simple.datastruct.TreeNode;

import java.util.HashMap;
import java.util.Map;

class LeetCode_105_Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;

        // 使用Map优化查询数组的信息，key = 数组内的值 value = 数组下标
        Map<Integer, Integer> hashMap = new HashMap<>();

        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            // 中序遍历来递归建成树
            hashMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, n-1, inorder, 0, n-1, hashMap);
    }

    private TreeNode buildTree(int[] preorder, int preorderLeft, int preorderRight,
                               int[] inorder, int inorderLeft, int inorderRight,
                               Map<Integer, Integer> hashMap) {
        if (preorderLeft > preorderRight) return null;

        int inorderRoot = preorder[preorderLeft];
        TreeNode root = new TreeNode(inorderRoot);

        Integer rootNodeIndex = hashMap.get(inorderRoot);

        int leftSubTreeLen = rootNodeIndex - inorderLeft;

        root.left = buildTree(preorder, preorderLeft + 1, preorderLeft + leftSubTreeLen,
                inorder, inorderLeft, rootNodeIndex - 1, hashMap);

        root.right = buildTree(preorder, preorderLeft + leftSubTreeLen + 1, preorderRight,
                inorder, rootNodeIndex + 1, inorderRight, hashMap);

        return root;
    }

}

public class LeetCode_105_ConstructBinaryTree4PreAndInorder {
}
