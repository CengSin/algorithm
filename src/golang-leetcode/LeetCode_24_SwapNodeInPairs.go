package main

// swapPairs 两两交换连表中的节点
func swapPairs(head *ListNode) *ListNode {
	first := &ListNode{
		Val:  0,
		Next: head,
	}
	swapPairsLogic(first, head)
	return first.Next
}

// swapPairsLogic 主逻辑
func swapPairsLogic(pre *ListNode, cur *ListNode) {
	if cur == nil || cur.Next == nil {
		return
	}

	nx := cur.Next
	pre.Next = nx
	cur.Next = nx.Next
	nx.Next = cur

	swapPairsLogic(cur, cur.Next)
}
