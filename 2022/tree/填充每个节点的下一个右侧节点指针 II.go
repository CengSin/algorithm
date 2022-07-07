package tree

func connect(root *Node) *Node {
	if root == nil {
		return nil
	}
	queue := []*Node{root}
	var level []*Node
	for len(queue) > 0 {
		node := queue[0]
		queue = queue[1:]

		if node.Left != nil {
			level = append(level, node.Left)
		}

		if node.Right != nil {
			level = append(level, node.Right)
		}

		if len(queue) > 0 {
			node.Next = queue[0]
		} else {
			queue = append(queue, level...)
			level = []*Node{}
		}
	}

	return root
}
