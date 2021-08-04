//给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
//
// 示例 1:
//
//
//输入: [2,2,3,4]
//输出: 3
//解释:
//有效的组合是:
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
//
//
// 注意:
//
//
// 数组长度不超过1000。
// 数组里整数的范围为 [0, 1000]。
//
// Related Topics 贪心 数组 双指针 二分查找 排序
// 👍 260 👎 0

package main

import "sort"

//leetcode submit region begin(Prohibit modification and deletion)
func triangleNumber(nums []int) (ans int) {
	sort.Ints(nums)
	for i, num := range nums {
		for j := i + 1; j < len(nums); j++ {
			ans += sort.SearchInts(nums[j+1:], num+nums[j])
		}
	}
	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
