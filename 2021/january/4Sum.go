package main

import (
	"fmt"
	"sort"
)

func fourSum(nums []int, target int) [][]int {

	if len(nums) < 4 {
		return nil
	}

	var result [][]int
	sort.Ints(nums)

	for i := range nums {
		if i == 0 || nums[i-1] != nums[i] {
			result = threeSumNew(nums, i, i+1, len(nums)-1, target-nums[i], result)
		}
	}
	return result
}

func threeSumNew(nums []int, i0 int, l int, r int, target int, result [][]int) [][]int {
	for i := l; i < r; i++ {
		if i == i0+1 || nums[i-1] != nums[i] {
			result = enrich(nums, i0, i, i+1, len(nums)-1, target-nums[i], result)
		}
	}
	return result
}

func enrich(nums []int, i0, i1, l int, r int, target int, result [][]int) [][]int {
	for l < r {
		sum := nums[l] + nums[r]
		if sum > target {
			r--
		} else if sum < target {
			l++
		} else {
			if l == i1+1 || nums[l] != nums[l-1] {
				var rows []int
				rows = append(rows, nums[i0], nums[i1], nums[l], nums[r])
				result = append(result, rows)
			}
			r--
			l++
		}
	}
	return result
}

func main() {
	// nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
	//nums := []int{-2, -1, -1, 1, 1, 2, 2}
	nums := []int{1, 0, -1, 0, -2, 2}
	target := 0
	result := fourSum(nums, target)
	fmt.Printf("%#v", result)
}
