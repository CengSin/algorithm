package main

// reverseBetween 反转链表head中位置在[left, right]之内的所有节点，并返回反转后链表的头节点。
func reverseBetween(head *ListNode, left int, right int) *ListNode {
	index := 1
	var stack []int
	for headTmp := head; headTmp != nil && index <= right; headTmp, index = headTmp.Next, index+1 {
		if index >= left {
			stack = append(stack, headTmp.Val)
		}
	}

	index = 1
	for headTmp := head; headTmp != nil && index <= right; headTmp, index = headTmp.Next, index+1 {
		if index >= left {
			headTmp.Val = stack[len(stack)-1]
			stack = stack[:len(stack)-1]
		}
	}
	return head
}
