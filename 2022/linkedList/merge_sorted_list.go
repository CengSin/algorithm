package linkedList

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	switch {
	case l1 == nil && l2 == nil:
		return nil
	case l1 != nil && l2 != nil:
		return mergeTwoListsCore(l1, l2)
	case l1 != nil:
		return l1
	}
	return l2
}

func profoundSolution(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2
	}

	if l2 == nil {
		return l1
	}

	if l1.Val > l2.Val {
		l1, l2 = l2, l1
	}

	l1.Next = profoundSolution(l1.Next, l2)

	return l1
}

func mergeTwoListsCore(l1 *ListNode, l2 *ListNode) *ListNode {
	ans := &ListNode{}
	head := ans
	for l1 != nil && l2 != nil {
		if l1.Val <= l2.Val {
			ans.Next = l1
			l1 = l1.Next
		} else {
			ans.Next = l2
			l2 = l2.Next
		}
		ans = ans.Next
	}

	if l1 != nil {
		ans.Next = l1
	}

	if l2 != nil {
		ans.Next = l2
	}

	return head.Next
}
