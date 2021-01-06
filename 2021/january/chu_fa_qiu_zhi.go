package main

func calcEquation(equations [][]string, values []float64, queries [][]string) []float64 {
	// 给方程中的每个字符编号
	id := map[string]int{}
	for _, eq := range equations {
		a, b := eq[0], eq[1]
		if _, has := id[a]; !has {
			id[a] = len(id)
		}

		if _, has := id[b]; !has {
			id[b] = len(id)
		}
	}

	// 建图
	type edge struct {
		to    int
		value float64
	}

	graph := make([][]edge, len(id))

	for i, eq := range equations {
		v, w := id[eq[0]], id[eq[1]]
		graph[v] = append(graph[v], edge{w, values[i]})
		graph[w] = append(graph[w], edge{v, 1 / values[i]})
	}

	bfs := func(start, end int) float64 {
		rations := make([]float64, len(graph))
		rations[start] = 1
		queue := []int{start}
		for len(queue) > 0 {
			v := queue[0]
			queue = queue[1:]
			if v == end {
				return rations[v]
			}
			for _, e := range graph[v] {
				if w := e.to; rations[w] == 0 {
					rations[w] = rations[v] * e.value
					queue = append(queue, w)
				}
			}
		}
		return -1
	}

	ans := make([]float64, len(queries))
	for i, q := range queries {
		start, hasS := id[q[0]]
		end, hasE := id[q[1]]
		if !hasS || !hasE {
			ans[i] = -1
		} else {
			ans[i] = bfs(start, end)
		}
	}
	return ans
}

func main() {

}
