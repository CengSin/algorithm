package main

func getKthFromEnd(head *ListNode, k int) *ListNode {
	n, tmp := 0, head

	for ; head != nil; head = head.Next {
		n++
	}
	for ; n > k; n-- {
		tmp = tmp.Next
	}
	return tmp
}

//getKthFromEnd1 双指针玩法
func getKthFromEnd1(head *ListNode, k int) *ListNode {
	i, slow, fast := 1, head, head
	for ; i <= k; i++ {
		fast = fast.Next
	}
	for fast != nil {
		fast, slow = fast.Next, slow.Next
	}
	return slow
}
