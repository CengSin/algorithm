package linkedList

func reversePrint(head *ListNode) []int {
	if head == nil {
		return []int{}
	}

	var stack []int
	for head != nil {
		stack = append(stack, head.Val)
		head = head.Next
	}

	for i := 0; i < len(stack)/2; i++ {
		tmp := stack[i]
		stack[i] = stack[len(stack)-1-i]
		stack[len(stack)-1-i] = tmp
	}

	return stack
}
