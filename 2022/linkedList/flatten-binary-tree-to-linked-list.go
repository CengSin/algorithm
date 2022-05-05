package linkedList

import "2022_leetcode/tree"

func Flatten(root *tree.TreeNode) {
	flatten(root)
}

func flatten(root *tree.TreeNode) {
	ans := make([]int, 0)
	tree.Dfs(root, &ans)

	if len(ans) == 0 {
		return
	}

	first := root
	for i, an := range ans {
		first.Val = an
		first.Left = nil
		if i < len(ans)-1 {
			first.Right = &tree.TreeNode{}
			first = first.Right
		}
	}
}

func flattenLeetCodeSolution(root *tree.TreeNode) {
	if root == nil {
		return
	}
	flattenLeetCodeSolution(root.Left)
	flattenLeetCodeSolution(root.Right)
	right := root.Right
	root.Right = root.Left
	root.Left = nil
	for root.Right != nil {
		root = root.Right
	}
	root.Right = right
}
