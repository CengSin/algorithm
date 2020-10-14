package main

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

/*
 removeNthFromEnd 删除链表的倒数第N个节点
 head 链表头节点
 n    要删除的倒数第n个节点
*/
func removeNthFromEnd(head *ListNode, n int) *ListNode {

	// 首先计算链表的长度
	node := head
	listLen := 0

	for node != nil {
		listLen++
		node = node.Next
	}

	// 删除链表的第len - n + 1个节点
	head = removeNode(head, listLen-n+1)

	return head
}

func removeNode(head *ListNode, n int) *ListNode {
	if n == 1 {
		return head.Next
	}

	node, pre := head, head
	for node != nil {
		n--
		if n == 0 {
			pre.Next = node.Next
			break
		}
		pre = node
		node = node.Next
	}

	return head
}
