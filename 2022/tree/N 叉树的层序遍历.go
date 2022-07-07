package tree

func levelOrder(root *Node2) (ans [][]int) {
	if root == nil {
		return
	}
	queue := []*Node2{root}
	for len(queue) > 0 {
		tmp := queue
		queue = nil
		var level []int
		for _, node := range tmp {
			level = append(level, node.Val)
			for _, n := range node.Children {
				if n != nil {
					queue = append(queue, n)
				}
			}
		}

		ans = append(ans, level)
	}
	return
}
