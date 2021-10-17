package leetcode

func kthSmallest(root *TreeNode, k int) (ans int) {
	var dfs func(*TreeNode, int)
	var n int
	dfs = func(node *TreeNode, cnt int) {
		if node == nil {
			return
		}

		dfs(node.Left, cnt)

		n++
		if n == cnt {
			ans = node.Val
		}

		dfs(node.Right, cnt)
	}

	dfs(root, k)

	return
}
