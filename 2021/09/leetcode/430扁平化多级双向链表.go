package main

/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Prev *Node
 *     Next *Node
 *     Child *Node
 * }
 */

func flatten(root *Node) *Node {
	dfs(root)
	return root
}

func dfs(node *Node) (last *Node) {
	cur := node

	for cur != nil {
		if cur.Child != nil {
			childLast := dfs(cur.Child)
			next := cur.Next
			cur.Next = cur.Child
			cur.Child.Prev = cur
			if next != nil {
				childLast.Next = next
				next.Prev = childLast
			}
			cur.Child = nil
			last = childLast
		} else {
			last = cur
		}
		cur = cur.Next
	}
	return
}
