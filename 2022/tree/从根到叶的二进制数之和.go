package tree

func SumRootToLeaf(root *TreeNode) (ans int) {
	return sumRootToLeaf(root)
}

func sumRootToLeaf(root *TreeNode) (ans int) {
	return sumRootToLeafCore(root, 0)
}

func sumRootToLeafCore(root *TreeNode, val int) int {
	if root == nil {
		return 0
	}
	val = val<<1 | root.Val
	if root.Left == nil && root.Right == nil {
		return val
	}
	return sumRootToLeafCore(root.Left, val) + sumRootToLeafCore(root.Right, val)
}
