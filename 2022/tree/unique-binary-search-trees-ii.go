package tree

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func generateTrees(n int) []*TreeNode {
	if n == 0 {
		return []*TreeNode{}
	}

	return generateTree(1, n)
}

func generateTree(start, end int) []*TreeNode {
	if start > end {
		// 如果这里直接返回[]*TreeNode{}「空切片」，会导致下面的遍历直接跳过，因为数组的size为0
		return []*TreeNode{nil}
	}

	allTrees := []*TreeNode{}

	for i := start; i <= end; i++ {
		leftTree := generateTree(start, i-1)
		rightTree := generateTree(i+1, end)

		for _, left := range leftTree {
			for _, right := range rightTree {
				root := &TreeNode{i, nil, nil}
				root.Left = left
				root.Right = right
				allTrees = append(allTrees, root)
			}
		}
	}
	return allTrees
}
