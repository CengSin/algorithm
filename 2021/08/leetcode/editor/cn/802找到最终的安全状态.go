//在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
//
// 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。
//
// 返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
//
// 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，
//满足 (i, j) 是图的一条有向边。
//
//
//
//
//
// 示例 1：
//
//
//输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
//输出：[2,4,5,6]
//解释：示意图如上。
//
//
// 示例 2：
//
//
//输入：graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
//输出：[4]
//
//
//
//
// 提示：
//
//
// n == graph.length
// 1 <= n <= 104
// 0 <= graph[i].length <= n
// graph[i] 按严格递增顺序排列。
// 图中可能包含自环。
// 图中边的数目在范围 [1, 4 * 104] 内。
//
//
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序
// 👍 235 👎 0

package main

//leetcode submit region begin(Prohibit modification and deletion)
func eventualSafeNodes(graph [][]int) (ans []int) {
	n := len(graph)
	rg := make([][]int, n)
	inDeg := make([]int, n)

	for node, toNodes := range graph {
		for _, toNode := range toNodes {
			rg[toNode] = append(rg[toNode], node) // 交换起点和终点的位置，构造一个反图
		}
		inDeg[node] = len(toNodes) // node节点的入度 = 原图中node节点的邻接点个树
	}

	// bfs 拓扑排序
	var q []int
	for i, du := range inDeg {
		if du == 0 {
			q = append(q, i)
		}
	}

	for len(q) > 0 {
		node := q[0]
		q = q[1:]
		// 拿到该节点的邻接点
		for _, l := range rg[node] {
			inDeg[l]--
			if inDeg[l] == 0 {
				q = append(q, l)
			}
		}
	}

	for i, du := range inDeg {
		if du == 0 {
			ans = append(ans, i)
		}
	}
	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
