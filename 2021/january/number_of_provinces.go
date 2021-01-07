package main

func findCircleNum(isConnected [][]int) int {
	// bfs遍历整个矩阵
	ans := 0

	vis := make([]bool, len(isConnected))

	for i, isVisit := range vis {
		if !isVisit {
			ans++
			queue := []int{i}
			for len(queue) > 0 {
				from := queue[0]
				queue = queue[1:]
				vis[from] = true
				for to, conn := range isConnected[from] {
					if conn == 1 && !vis[to] {
						queue = append(queue, to)
					}
				}
			}
		}
	}

	return ans
}

func main() {

}
