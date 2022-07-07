package tree

func sumNumbers(root *TreeNode) (ans int) {
	var dfs func(*TreeNode)
	var sum int
	dfs = func(node *TreeNode) {
		if node == nil {
			return
		}

		defer func() {
			sum -= node.Val
			sum /= 10
		}()

		sum *= 10
		sum += node.Val
		if node.Left == nil && node.Right == nil {
			ans += sum
		}

		dfs(node.Left)
		dfs(node.Right)
	}

	dfs(root)
	return
}
