package main

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func getLen(l *ListNode) (ans int) {
	for l != nil {
		ans++
		l = l.Next
	}
	return
}

func splitListToParts(head *ListNode, k int) []*ListNode {
	n := getLen(head)

	avgNodeNum, remainingNodeNum := n/k, n%k
	res := make([]*ListNode, k)

	for i, curr := 0, head; i < k && curr != nil; i++ {
		res[i] = curr
		partSize := avgNodeNum
		if i < remainingNodeNum {
			partSize++
		}
		for j := 1; j < partSize; j++ {
			curr = curr.Next
		}
		curr, curr.Next = curr.Next, nil
	}

	return res
}
