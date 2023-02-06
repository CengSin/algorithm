package main

// btreeGameWinningMove 三块区域，x的左子树，x的右子树，其他节点，判断这三个区域里面那个区域的节点数量>=n+1/2，如果有则返回true，否则返回false，三个区域的总节点数为n-1
func btreeGameWinningMove(root *TreeNode, n int, x int) bool {
	var xnode *TreeNode

	var getSubTreeSize func(node *TreeNode) int
	getSubTreeSize = func(node *TreeNode) int {
		if node == nil {
			return 0
		}

		if node.Val == x {
			xnode = node
		}

		return 1 + getSubTreeSize(node.Left) + getSubTreeSize(node.Right)
	}

	getSubTreeSize(root)
	leftSize := getSubTreeSize(xnode.Left)
	if leftSize >= (n+1)/2 {
		return true
	}

	rightSize := getSubTreeSize(xnode.Right)
	if rightSize >= (n+1)/2 {
		return true
	}

	return (n - 1 - leftSize - rightSize) >= (n+1)/2
}
