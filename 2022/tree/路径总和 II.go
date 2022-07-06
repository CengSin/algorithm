package tree

func PathSum(root *TreeNode, targetSum int) [][]int {
	return pathSum(root, targetSum)
}

func pathSum(root *TreeNode, targetSum int) (ans [][]int) {
	var path []int
	var dfs func(*TreeNode, int)
	dfs = func(node *TreeNode, target int) {
		if node == nil {
			return
		}

		defer func() { path = path[:len(path)-1] }()

		target -= node.Val
		path = append(path, node.Val)
		if node.Left == nil && node.Right == nil && target == 0 {
			ans = append(ans, append([]int(nil), path...))
			return
		}

		dfs(node.Left, target)
		dfs(node.Right, target)
	}

	dfs(root, targetSum)
	return
}
