package main

func sortedListToBST(head *ListNode) *TreeNode {
	return buildBST(head, nil)
}

func buildBST(left, right *ListNode) *TreeNode {
	if left == right {
		return nil
	}
	mid := getMidNode(left, right)
	root := &TreeNode{mid.Val, buildBST(left, mid), buildBST(mid.Next, right)}
	return root
}

func getMidNode(left, right *ListNode) *ListNode {
	fast, slow := left, left
	for ; fast != right && fast.Next != right; fast, slow = fast.Next.Next, slow.Next {
	}

	return slow
}
