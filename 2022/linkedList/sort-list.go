package linkedList

import "container/heap"

type sHeap []ListNode

func (s sHeap) Len() int {
	return len(s)
}

func (s sHeap) Less(i, j int) bool {
	return s[i].Val < s[j].Val
}

func (s sHeap) Swap(i, j int) {
	s[i], s[j] = s[j], s[i]
}

func (s *sHeap) Push(x interface{}) {
	*s = append(*s, x.(ListNode))
}

func (s *sHeap) Pop() interface{} {
	node := (*s)[s.Len()-1]
	*s = (*s)[:s.Len()-1]
	return node
}

func sortList(head *ListNode) *ListNode {
	return mergeSort(head, nil)
}

func mergeSort(head *ListNode, tail *ListNode) *ListNode {
	if head == nil {
		return head
	}

	if head.Next == tail {
		head.Next = nil //截断
		return head
	}

	slow, fast := head, head
	for fast != tail {
		slow = slow.Next
		fast = fast.Next
		if fast != tail {
			fast = fast.Next
		}
	}

	mid := slow
	return merge(mergeSort(head, mid), mergeSort(mid, tail))
}

func merge(head1 *ListNode, head2 *ListNode) *ListNode {
	dummyHead := &ListNode{}
	temp, temp1, temp2 := dummyHead, head1, head2
	for temp1 != nil && temp2 != nil {
		if temp1.Val <= temp2.Val {
			temp.Next = temp1
			temp1 = temp1.Next
		} else {
			temp.Next = temp2
			temp2 = temp2.Next
		}
		temp = temp.Next
	}

	if temp1 != nil {
		temp.Next = temp1
	} else if temp2 != nil {
		temp.Next = temp2
	}
	return dummyHead.Next
}

func heapSort(head *ListNode) *ListNode {
	var h sHeap
	heap.Init(&h)
	for head != nil {
		tmp := head.Next
		head.Next = nil
		heap.Push(&h, *head)
		head = tmp
	}

	dummyHead := &ListNode{}
	newHead := dummyHead
	for h.Len() > 0 {
		node := heap.Pop(&h).(ListNode)
		newHead.Next = &node
		newHead = newHead.Next
	}
	return dummyHead.Next
}
