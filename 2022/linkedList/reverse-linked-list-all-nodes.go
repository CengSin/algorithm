package linkedList

func reverseList(head *ListNode) *ListNode {
	var stack []*ListNode
	for head != nil {
		stack = append(stack, head)
		node := head.Next
		head.Next = nil
		head = node
	}

	head = &ListNode{}
	pre := head
	for len(stack) > 0 {
		node := stack[len(stack)-1]
		pre.Next = node
		pre = pre.Next
		stack = stack[:len(stack)-1]
	}
	return head.Next
}
