package main

import "sort"

// 从数组中找出三元数组之和为0的子数组
func threeSum(nums []int) [][]int {
	if len(nums) < 3 {
		return nil
	}

	var result [][]int

	sort.Ints(nums)
	for i := range nums {
		if i == 0 || nums[i] != nums[i-1] {
			result = enrichResult(nums, i, i+1, len(nums)-1, 0-nums[i], result)
		}
	}

	return result
}

func enrichResult(nums []int, f int, l int, r int, target int, allResult [][]int) [][]int {
	for l < r {
		if nums[l]+nums[r] > target {
			r--
		} else if nums[l]+nums[r] < target {
			l++
		} else {
			if l == f+1 || nums[l-1] != nums[l] {
				var result []int
				result = append(result, nums[l], nums[f], nums[r])
				allResult = append(allResult, result)
			}
			l++
			r--
		}
	}
	return allResult
}
