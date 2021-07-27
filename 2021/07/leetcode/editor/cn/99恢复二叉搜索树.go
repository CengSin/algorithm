//给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
//
//
//
// 示例 1：
//
//
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
//
//
// 示例 2：
//
//
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
//
//
//
// 提示：
//
//
// 树上节点的数目在范围 [2, 1000] 内
// -231 <= Node.val <= 231 - 1
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树
// 👍 517 👎 0

package main

import "sort"

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func recoverTree(root *TreeNode) {
	visit := make(map[int]*TreeNode)
	var nodes1, nodes2 []int

	var dfs func(*TreeNode)

	dfs = func(node *TreeNode) {
		if node == nil {
			return
		}
		dfs(node.Left)

		nodes1 = append(nodes1, node.Val)
		nodes2 = append(nodes2, node.Val)
		visit[node.Val] = node

		dfs(node.Right)
	}

	dfs(root)

	sort.Ints(nodes2)

	for i := 0; i < len(nodes2); i++ {
		if nodes1[i] != nodes2[i] {
			visit[nodes2[i]].Val, visit[nodes1[i]].Val = nodes1[i], nodes2[i]
			break
		}
	}
}

//leetcode submit region end(Prohibit modification and deletion)
