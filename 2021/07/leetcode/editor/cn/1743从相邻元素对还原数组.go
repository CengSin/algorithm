//存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。
//
// 给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui
// 和 vi 在 nums 中相邻。
//
// 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i]
//, nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。
//
// 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。
//
//
//
// 示例 1：
//
//
//输入：adjacentPairs = [[2,1],[3,4],[3,2]]
//输出：[1,2,3,4]
//解释：数组的所有相邻元素对都在 adjacentPairs 中。
//特别要注意的是，adjacentPairs[i] 只表示两个元素相邻，并不保证其 左-右 顺序。
//
//
// 示例 2：
//
//
//输入：adjacentPairs = [[4,-2],[1,4],[-3,1]]
//输出：[-2,4,1,-3]
//解释：数组中可能存在负数。
//另一种解答是 [-3,1,4,-2] ，也会被视作正确答案。
//
//
// 示例 3：
//
//
//输入：adjacentPairs = [[100000,-100000]]
//输出：[100000,-100000]
//
//
//
//
// 提示：
//
//
// nums.length == n
// adjacentPairs.length == n - 1
// adjacentPairs[i].length == 2
// 2 <= n <= 105
// -105 <= nums[i], ui, vi <= 105
// 题目数据保证存在一些以 adjacentPairs 作为元素对的数组 nums
//
// Related Topics 数组 哈希表
// 👍 84 👎 0

package main

//leetcode submit region begin(Prohibit modification and deletion)
func restoreArray(adjacentPairs [][]int) []int {
	n := len(adjacentPairs) + 1
	g := make(map[int][]int) // 每个点对应的边

	for _, p := range adjacentPairs {
		v, w := p[0], p[1]
		g[v] = append(g[v], w)
		g[w] = append(g[w], v)
	}

	ans := make([]int, n)
	for e, adj := range g {
		if len(adj) == 1 {
			ans[0] = e // 拿到起点(起点和终点肯定只有一个相邻点，而且结果中不要求数组顺序。所以找到在adjacentPairs中相邻点只有一个的起点，就可以设置为起点)
			break
		}
	}

	ans[1] = g[ans[0]][0] // 第二个元素为第一个元素的关联点
	for i := 2; i < n; i++ {
		adj := g[ans[i-1]]      // 遍历中的点，拿到第i-1所有的相邻点
		if ans[i-2] == adj[0] { // 如果下标为i-2点等于i-1的第一个关联点，那么第二个点就是他的下一个相邻点
			ans[i] = adj[1]
		} else {
			ans[i] = adj[0] // 否则，第一个节点就是下标为i-1节点的相邻点
		}
	}

	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
