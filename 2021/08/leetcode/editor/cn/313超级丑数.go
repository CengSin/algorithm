//超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
//
// 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
//
// 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
//
//
//
// 示例 1：
//
//
//输入：n = 12, primes = [2,7,13,19]
//输出：32
//解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,
//28,32] 。
//
// 示例 2：
//
//
//输入：n = 1, primes = [2,3,5]
//输出：1
//解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
//
//
//
//
//
//
// 提示：
//
//
// 1 <= n <= 106
// 1 <= primes.length <= 100
// 2 <= primes[i] <= 1000
// 题目数据 保证 primes[i] 是一个质数
// primes 中的所有值都 互不相同 ，且按 递增顺序 排列
//
//
//
//
// Related Topics 数组 哈希表 数学 动态规划 堆（优先队列）
// 👍 233 👎 0

package main

//leetcode submit region begin(Prohibit modification and deletion)
// 最小的超级丑数为1，这道题目规定「超级丑数」是只包含primes数组中的质因数，那么我们可以把1放入最小堆，
// 取出堆顶的的数字，则堆顶元素是堆中的最小超级丑数，
// 将堆顶元素与primes相乘并放入最小堆，并用hash去重
// 从最小堆中取出第n个堆顶数字就是结果

import (
	"container/heap"
	"sort"
)

type heap313 struct {
	sort.IntSlice
}

func (h *heap313) Push(x interface{}) {
	h.IntSlice = append(h.IntSlice, x.(int))
} // add x as element Len()

func (h *heap313) Pop() interface{} {
	a := h.IntSlice
	val := a[len(a)-1]
	h.IntSlice = a[:len(a)-1]
	return val
} // remove and return element Len() - 1.

func nthSuperUglyNumber(n int, primes []int) (ugly int) {
	seen := make(map[int]bool)

	h := &heap313{[]int{1}}
	for i := 0; i < n; i++ {
		ugly = heap.Pop(h).(int)
		if i == n-1 {
			return
		}
		for _, prime := range primes {
			ugly1 := ugly * prime
			if _, ok := seen[ugly1]; !ok {
				heap.Push(h, ugly1)
				seen[ugly1] = true
			}
		}
	}

	return
}

//leetcode submit region end(Prohibit modification and deletion)
