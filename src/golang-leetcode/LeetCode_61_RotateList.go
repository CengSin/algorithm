package main

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func rotateRight(head *ListNode, k int) *ListNode {
	if head == nil {
		return nil
	}

	listLen := getLenByLoop(head)

	k = k % listLen

	if k == 0 {
		return head
	}

	firstList, lastList := getSubListByIndex(head, listLen-k+1)

	firstList.Next = nil
	node := lastList
	for lastList.Next != nil {
		lastList = lastList.Next
	}
	lastList.Next = head
	return node
}

func getSubListByIndex(head *ListNode, n int) (*ListNode, *ListNode) {
	for head != nil {
		n--
		if n == 1 {
			return head, head.Next
		}
		head = head.Next
	}
	return nil, nil
}

func getLenByLoop(head *ListNode) int {
	cnt := 0
	node := head
	for node != nil {
		cnt++
		node = node.Next
	}
	return cnt
}
