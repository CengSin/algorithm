package main

func getIntersectionNodeOptimize(headA, headB *ListNode) *ListNode {
	getLen := func(head *ListNode) int {
		if head == nil {
			return 0
		}

		var cnt int
		for head != nil {
			cnt++
			head = head.Next
		}
		return cnt
	}

	aLen := getLen(headA)
	bLen := getLen(headB)

	if aLen > bLen {
		subLen := aLen - bLen
		for subLen > 0 {
			headA = headA.Next
			subLen--
		}
	}

	if bLen > aLen {
		subLen := bLen - aLen
		for subLen > 0 {
			headB = headB.Next
			subLen--
		}
	}

	for headA != headB {
		headA = headA.Next
		headB = headB.Next
	}

	return headA
}
