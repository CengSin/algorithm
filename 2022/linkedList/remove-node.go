package linkedList

func deleteNode(head *ListNode, val int) *ListNode {
	if head == nil {
		return head
	}

	if head.Val == val {
		return head.Next
	}

	pre, cur := head, head
	for cur.Next != nil {

		if cur.Val == val {
			break
		}

		pre = cur
		cur = cur.Next
	}

	pre.Next = cur.Next
	return head
}
