package main

import (
	"2022_leetcode/tree"
	"strings"
)

func main() {
	nodes := strings.Split("1,0,1,0,1,0,1", ",")
	if len(nodes) == 0 {
		return
	}
	root := &tree.TreeNode{}
	tree.Construct(root, 0, len(nodes), nodes)
	tree.SumRootToLeaf(root)
	tree.PrintTree(root)

}
