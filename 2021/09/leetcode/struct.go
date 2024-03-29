package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func ConstructLinkedList(nums []int) *ListNode {
	var head, first *ListNode
	for _, num := range nums {
		if head == nil {
			first = &ListNode{Val: num}
			head.Next = first
		} else {
			first.Next = &ListNode{Val: num}
			first = first.Next
		}
	}
	return head
}

type Node struct {
	Val   int
	Prev  *Node
	Next  *Node
	Child *Node
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
