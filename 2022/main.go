package main

import (
	"2022_leetcode/linkedList"
	"2022_leetcode/tree"
	"strings"
)

func main() {
	nodes := strings.Split("1,2,5,3,4,null,6", ",")
	if len(nodes) == 0 {
		return
	}
	root := &tree.TreeNode{}
	tree.Construct(root, 0, len(nodes), nodes)
	linkedList.Flatten(root)
	tree.PrintTree(root)

}
