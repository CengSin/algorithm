package main

/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

type TreeNode struct {
	Val      int
	Children []*TreeNode
}

func maxDepth(root *TreeNode) int {

	if root == nil {
		return 0
	}

	depth := 1
	queue := []*TreeNode{root}

	for len(queue) > 0 {
		tmp := queue
		queue = nil

		for _, node := range tmp {
			if node.Children != nil {
				queue = append(queue, node.Children...)
			}
		}
		depth++

	}

	return depth

}
