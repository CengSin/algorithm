package main

import (
	"fmt"
	"sort"
)

func combinationSum2(candidates []int, target int) [][]int {
	if len(candidates) == 0 {
		return nil
	}
	sort.Ints(candidates)
	var result [][]int
	var c []int

	findCombinationSum2(candidates, target, c, 0, &result)

	return result
}

func findCombinationSum2(nums []int, target int, c []int, start int, res *[][]int) {
	if target <= 0 {
		if target == 0 {
			b := make([]int, len(c))
			copy(b, c)
			*res = append(*res, b)
		}
		return
	}

	for i := start; i < len(nums); i++ {
		if nums[i] > target {
			continue
		}
		if i == start || nums[i] != nums[i-1] {
			c = append(c, nums[i])
			findCombinationSum2(nums, target-nums[i], c, i+1, res)
			c = c[:len(c)-1]
		}
	}
}

func main() {
	sum := combinationSum2([]int{10, 1, 2, 7, 6, 1, 5}, 8)
	fmt.Printf("%#v\n", sum)
}
