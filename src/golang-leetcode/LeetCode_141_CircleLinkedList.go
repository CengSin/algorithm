package main

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

type ListNode struct {
	Val  int
	Next *ListNode
}

func hasCycle(head *ListNode) bool {
	return modifyListNodeVal(head)
}

// 快慢指针 node1 为快指针 ， node2为慢指针 timeout
func quickSlowPoint(node1 *ListNode) bool {
	for node1 != nil && node1.Next != nil {
		if node1.Next == node1.Next.Next {
			return true
		}
	}
	return false
}

// 会修改链表的值
func modifyListNodeVal(head *ListNode) bool {
	if head == nil {
		return false
	}
	if head.Val == 10e5+1 {
		return true
	}
	head.Val = 10e5 + 1
	return hasCycle(head.Next)
}
