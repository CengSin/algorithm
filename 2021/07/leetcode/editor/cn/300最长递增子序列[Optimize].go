package main

import "sort"

func lengthOfLISOptimize(nums []int) (ans int) {
	// 要求最长递增子序列
	// 思路，定义，dp[i]为以第i个元素结尾的子序列的最大长度
	// 从小到大计算dp[i]的值，在计算dp[i]之前,dp[0~i-1]的元素我们已经计算完成，所以状态转移方程为
	// dp[i] = max(dp[i], dp[j] + 1) 0 <= j <= i

	d := []int{}

	for _, num := range nums {
		if index := sort.SearchInts(d, num); index < len(d) {
			d[index] = num
		} else {
			d = append(d, num)
		}
	}

	return len(d)
}
