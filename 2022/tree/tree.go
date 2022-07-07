package tree

import (
	"fmt"
	"strconv"
)

// Node2 Definition for a Node that have more than one children node.
type Node2 struct {
	Val      int
	Children []*Node2
}

// Node definition for a Node
type Node struct {
	Val   int
	Left  *Node
	Right *Node
	Next  *Node
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func PrintTree(root *TreeNode) {
	if root == nil {
		fmt.Print("nil ")
		return
	}

	fmt.Print(root.Val, " ")
	PrintTree(root.Left)
	PrintTree(root.Right)
}

func Construct(root *TreeNode, start, end int, nodes []string) *TreeNode {
	if len(nodes) == 0 || start >= end || nodes[start] == "null" {
		return nil
	}
	nodeVal, _ := strconv.Atoi(nodes[start])
	if root != nil {
		root.Val = nodeVal
	} else {
		root = &TreeNode{Val: nodeVal}
	}
	root.Left = Construct(root.Left, 2*start+1, end, nodes)
	root.Right = Construct(root.Right, 2*start+2, end, nodes)
	return root
}

func Dfs(root *TreeNode, ans *[]int) {
	if root == nil {
		return
	}

	*ans = append(*ans, root.Val)
	Dfs(root.Left, ans)
	Dfs(root.Right, ans)
}
