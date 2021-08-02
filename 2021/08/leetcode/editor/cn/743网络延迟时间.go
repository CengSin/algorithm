//有 n 个网络节点，标记为 1 到 n。
//
// 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， w
//i 是一个信号从源节点传递到目标节点的时间。
//
// 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
//
//
//
// 示例 1：
//
//
//
//
//输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//输出：2
//
//
// 示例 2：
//
//
//输入：times = [[1,2,1]], n = 2, k = 1
//输出：1
//
//
// 示例 3：
//
//
//输入：times = [[1,2,1]], n = 2, k = 2
//输出：-1
//
//
//
//
// 提示：
//
//
// 1 <= k <= n <= 100
// 1 <= times.length <= 6000
// times[i].length == 3
// 1 <= ui, vi <= n
// ui != vi
// 0 <= wi <= 100
// 所有 (ui, vi) 对都 互不相同（即，不含重复边）
//
// Related Topics 深度优先搜索 广度优先搜索 图 最短路 堆（优先队列）
// 👍 378 👎 0

package main

import "math"

//leetcode submit region begin(Prohibit modification and deletion)
func networkDelayTime(times [][]int, n int, k int) (ans int) {
	const inf = math.MaxInt32 << 1
	g := make([][]int, n)
	for i := range g {
		g[i] = make([]int, n)
		for j := range g[i] {
			g[i][j] = inf
		}
	}

	for _, time := range times {
		i, j := time[0]-1, time[1]-1
		g[i][j] = time[2]
	}

	dist := make([]int, n) // 从起点到当前节点的花费时间
	for i := range dist {
		dist[i] = inf
	}
	dist[k-1] = 0           // 起点到自己的花费时间是0
	used := make([]bool, n) // 标识节点是否被使用

	min := func(a, b int) int {
		if a < b {
			return a
		}
		return b
	}

	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}

	for i := 0; i < n; i++ {
		// 每次从「未确定节点」中取一个与起点距离最短的点，将它归类为「已确定节点」
		x := -1
		for y, u := range used {
			if !u && (x == -1 || dist[y] < dist[x]) {
				x = y
			}
		}

		used[x] = true
		// 并用它「更新」从起点到其他所有「未确定节点」的距离。直到所有点都被归类为「已确定节点」
		for y, time := range g[x] {
			dist[y] = min(dist[y], dist[x]+time)
		}
	}

	for _, d := range dist {
		if d == inf {
			return -1
		}
		ans = max(ans, d)
	}

	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
