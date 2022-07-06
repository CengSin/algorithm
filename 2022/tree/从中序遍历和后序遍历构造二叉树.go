package tree

func buildTree(inorder []int, postorder []int) *TreeNode {
	if len(inorder) == 0 && len(postorder) == 0 {
		return nil
	}

	if len(inorder) == 1 && len(postorder) == 1 {
		return &TreeNode{Val: inorder[0]}
	}

	index := 0
	for ; index < len(inorder); index++ {
		if inorder[index] == postorder[len(postorder)-1] {
			break
		}
	}

	left := buildTree(inorder[0:index], postorder[:len(inorder[0:index])])
	right := buildTree(inorder[index+1:], postorder[len(inorder[0:index]):len(postorder)-1])

	return &TreeNode{Val: inorder[index], Left: left, Right: right}
}
