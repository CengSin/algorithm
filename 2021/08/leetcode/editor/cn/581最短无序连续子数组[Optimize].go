package main

import "math"

func findUnsortedSubarray_Optimize(nums []int) int {
	maxNum, minNum, left, right := math.MinInt64, math.MaxInt64, -1, -1
	for i, num := range nums {
		if maxNum <= num {
			maxNum = num
		} else {
			right = i
		}
		num2 := nums[len(nums)-i-1]
		if minNum >= num2 {
			minNum = num2
		} else {
			left = len(nums) - i - 1
		}
	}

	if right == -1 {
		return 0
	}
	return right - left + 1
}
