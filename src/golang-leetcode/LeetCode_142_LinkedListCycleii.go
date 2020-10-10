package main

func detectCycle(head *ListNode) *ListNode {
	return mapCheckDupEle(head)
}

// 通过map检查原指针是否存在
func mapCheckDupEle(head *ListNode) *ListNode {
	visit := map[*ListNode]struct{}{}

	for head != nil {
		if _, ok := visit[head]; ok {
			return head
		}
		visit[head] = struct{}{}
		head = head.Next
	}
	return nil
}

// fastSlowPoint 快慢指针
func fastSlowPoint(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}

	fast := head
	slow := head

	for {
		if fast == nil || fast.Next == nil {
			return nil
		}

		fast = fast.Next.Next
		slow = slow.Next
		if fast == slow {
			break
		}
	}
	fast = head
	for fast != slow {
		fast = fast.Next
		slow = slow.Next
	}
	return fast
}
