package main

import "math"

// TreeNode 二叉搜索树 有序的是中序排列
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func minDiffInBST(root *TreeNode) int {
	ans, pre := math.MaxInt64, -1

	var dfs func(*TreeNode)
	dfs = func(node *TreeNode) {
		if node == nil {
			return
		}
		dfs(node.Left)
		if pre != -1 && ans >= node.Val-pre {
			ans = node.Val - pre
		}
		pre = node.Val
		dfs(node.Right)
	}

	dfs(root)
	return ans
}

func main() {

}
