//给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
//请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
//输出：13
//解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
//
//
// 示例 2：
//
//
//输入：matrix = [[-5]], k = 1
//输出：-5
//
//
//
//
// 提示：
//
//
// n == matrix.length
// n == matrix[i].length
// 1 <= n <= 300
// -109 <= matrix[i][j] <= 109
// 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列
// 1 <= k <= n2
//
// Related Topics 数组 二分查找 矩阵 排序 堆（优先队列）
// 👍 628 👎 0

package main

import "sort"

//leetcode submit region begin(Prohibit modification and deletion)
func kthSmallest(matrix [][]int, k int) int {
	row, col := len(matrix), len(matrix[0])
	res := make([]int, 0, row*col)
	for _, nums := range matrix {
		res = append(res, nums...)
	}

	sort.Ints(res)
	return res[k-1]
}

//leetcode submit region end(Prohibit modification and deletion)
