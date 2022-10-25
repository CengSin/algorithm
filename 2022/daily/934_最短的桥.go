package daily

func shortestBridge(grid [][]int) (step int) {
	type pair struct{ x, y int }
	dirs := []pair{{0, 1}, {0, -1}, {1, 0}, {-1, 0}} // 上下左右的移动距离
	n := len(grid)
	for i, row := range grid {
		for j, v := range row {
			if v != 1 { // 岛屿 = 1，河水 = 0
				continue
			}
			island := []pair{} // 记录数组中第一个岛屿的位置
			grid[i][j] = -1    // 遍历过的岛屿标记，防止重复遍历
			q := []pair{{i, j}}
			for len(q) > 0 {
				p := q[0]
				q = q[1:]
				island = append(island, p)
				for _, dir := range dirs {
					x, y := p.x+dir.x, p.y+dir.y
					if x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1 {
						grid[x][y] = -1 // 遍历过的岛屿标记，防止重复遍历
						q = append(q, pair{x, y})
					}
				}
			}

			q = island // 第一个岛屿的边界此时都在island中
			for {
				tmp := q
				q = nil
				for _, p := range tmp {
					for _, dir := range dirs {
						x, y := p.x+dir.x, p.y+dir.y
						if x >= 0 && x < n && y >= 0 && y < n {
							if grid[x][y] == 1 {
								return
							}
							if grid[x][y] == 0 {
								grid[x][y] = -1
								q = append(q, pair{x, y})
							}
						}
					}
				}

				step++
			}
		}
	}

	return
}
