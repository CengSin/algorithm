package main

import (
	"fmt"
	"sort"
)

func removeElement(nums []int, val int) int {
	sort.Ints(nums)
	for i := 0; i < len(nums); i++ {
		j := i
		cnt := 0
		for ; j < len(nums) && nums[j] == val; j++ {
			cnt++
		}
		for k := j; k < len(nums); k++ {
			nums[k-cnt] = nums[k]
		}
		nums = nums[:len(nums)-cnt]
	}

	return len(nums)
}

func main() {
	nums := []int{3, 2, 2, 3}
	lens := removeElement(nums, 3)
	fmt.Println(lens)
	for i := 0; i < lens; i++ {
		fmt.Println(nums[i])
	}
}
