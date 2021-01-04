package main

import (
	"fmt"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

// 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
func partition(head *ListNode, x int) *ListNode {
	// 将链表分为三个部分，小于x的，等于x的，以及大于x的
	var sH, sT, bH, bT, next, loopNode *ListNode
	loopNode = head
	for loopNode != nil {
		// 将遍历出来的节点变成一个独立的节点
		next = loopNode.Next
		loopNode.Next = nil

		// 建立链表
		if loopNode.Val < x {
			if sH == nil {
				sH = loopNode
				sT = loopNode
			} else {
				sT.Next = loopNode
				sT = sT.Next
			}
		} else {
			if bH == nil {
				bH = loopNode
				bT = loopNode
			} else {
				bT.Next = loopNode
				bT = bT.Next
			}
		}

		// 将下一个节点赋值给loopNode
		loopNode = next
	}
	if sT != nil {
		sT.Next = bH
		if bT == nil {
			bT = sT
		}
	}

	if sH != nil {
		return sH
	}
	return bH
}

func Parti(head *ListNode, x int) *ListNode {
	return partition(head, x)
}

func ConstructList(arr []int) *ListNode {
	var head, first *ListNode
	for _, val := range arr {
		if head == nil {
			head = &ListNode{val, nil}
			first = head
		} else {
			head.Next = &ListNode{val, head.Next}
			head = head.Next
		}
	}
	return first
}

func main() {

	head := ConstructList([]int{1, 4, 3, 2, 5, 2})

	node := partition(head, 3)

	for node != nil {
		fmt.Print(node.Val, " ")
		node = node.Next
	}
	fmt.Println()
}
