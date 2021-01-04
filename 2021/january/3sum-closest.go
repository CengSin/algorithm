package main

import (
	"math"
	"sort"
)

//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
func threeSumClosest(nums []int, target int) int {
	if len(nums) < 3 {
		return 0
	}

	sort.Ints(nums)

	res, diff, n := 0, math.MaxInt32, len(nums)

	for i := 0; i < n-2; i++ {
		for j, k := i+1, n-1; j < k; {
			sum := nums[j] + nums[k] + nums[i]
			if abs(sum-target) < diff {
				res, diff = sum, abs(sum-target)
			}
			if sum == target {
				return res
			} else if sum > target {
				k--
			} else {
				j++
			}
		}
	}

	return res
}

func abs(i int) int {
	if i < 0 {
		return -i
	}
	return i
}
