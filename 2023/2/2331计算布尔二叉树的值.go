package main

type TreeNode struct {
	Left  *TreeNode
	Right *TreeNode
	Val   int
}

func evaluateTree(root *TreeNode) bool {
	switch root.Val {
	case 0:
		return false
	case 1:
		return true
	case 2:
		return evaluateTree(root.Left) || evaluateTree(root.Right)
	case 3:
		return evaluateTree(root.Left) && evaluateTree(root.Right)
	default:
		return false
	}
}
