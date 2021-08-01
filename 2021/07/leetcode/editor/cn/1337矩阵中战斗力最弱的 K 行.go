//给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
//
// 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
//
// 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
//
// 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
//
//
//
// 示例 1：
//
//
//输入：mat =
//[[1,1,0,0,0],
// [1,1,1,1,0],
// [1,0,0,0,0],
// [1,1,0,0,0],
// [1,1,1,1,1]],
//k = 3
//输出：[2,0,3]
//解释：
//每行中的军人数目：
//行 0 -> 2
//行 1 -> 4
//行 2 -> 1
//行 3 -> 2
//行 4 -> 5
//从最弱到最强对这些行排序后得到 [2,0,3,1,4]
//
//
// 示例 2：
//
//
//输入：mat =
//[[1,0,0,0],
// [1,1,1,1],
// [1,0,0,0],
// [1,0,0,0]],
//k = 2
//输出：[0,2]
//解释：
//每行中的军人数目：
//行 0 -> 1
//行 1 -> 4
//行 2 -> 1
//行 3 -> 1
//从最弱到最强对这些行排序后得到 [0,2,3,1]
//
//
//
//
// 提示：
//
//
// m == mat.length
// n == mat[i].length
// 2 <= n, m <= 100
// 1 <= k <= m
// matrix[i][j] 不是 0 就是 1
//
// Related Topics 数组 二分查找 矩阵 排序 堆（优先队列）
// 👍 91 👎 0

package main

import (
	"container/heap"
	"sort"
)

//leetcode submit region begin(Prohibit modification and deletion)

type arrPair struct {
	index int
	//sum int64 sum会溢出，int64会报错
	pow int
}

type arrPairs []arrPair

func (a arrPairs) Len() int {
	return len(a)
}

func (a arrPairs) Less(i, j int) bool {
	return a[i].pow < a[j].pow || a[i].pow == a[j].pow && a[i].index < a[j].index
}

func (a arrPairs) Swap(i, j int) {
	a[i], a[j] = a[j], a[i]
}

func (a *arrPairs) Push(x interface{}) {
	*a = append(*a, x.(arrPair))
}

func (a *arrPairs) Pop() interface{} {
	h := *a
	val := h[len(h)-1]
	*a = h[:len(h)-1]
	return val
}

func kWeakestRows(mat [][]int, k int) []int {
	hp, m, n := arrPairs{}, len(mat), len(mat[0])

	for i := 0; i < m; i++ {
		pow := sort.Search(n, func(o int) bool {
			return mat[i][o] == 0 // 查询平民的个数的最小索引，如果是军人，那么应该查询最大索引
		})

		hp = append(hp, arrPair{
			index: i,
			pow:   pow,
		})
	}

	heap.Init(&hp)

	var ans []int

	for i := 0; i < k; i++ {
		ans = append(ans, heap.Pop(&hp).(arrPair).index)
	}

	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
