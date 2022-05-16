package linkedList

func insertionSortList(head *ListNode) *ListNode {
	if head == nil {
		return head
	}

	dummyHead := &ListNode{Next: head} // 处理头节点需要插入的情况

	for lastSorted, cur := head, head.Next; cur != nil; cur = lastSorted.Next { // cur为最后一个节点的下一个节点
		if lastSorted.Val <= cur.Val {
			lastSorted = lastSorted.Next // lastSorted直接往后走
		} else {
			prev := dummyHead
			for ; prev.Next.Val < cur.Val; prev = prev.Next { // 从链表头往后走，寻找第一个不小于cur的节点
			}
			lastSorted.Next = cur.Next // 最后一个节点的之后的节点等于当前需要插入节点的后续节点
			// 插入节点
			cur.Next = prev.Next // 当前节点的后续节点为prev的后续节点
			prev.Next = cur      // prev的后节点为cur
		}
	}
	return dummyHead.Next
}
