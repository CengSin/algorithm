package main

import "fmt"

func rotateRedo(nums []int, k int) {
	if len(nums) == 0 {
		return
	}

	k %= len(nums)

	if k == 0 {
		return
	}

	trans(nums, 0, len(nums)-1)
	trans(nums, 0, k-1)
	trans(nums, k, len(nums)-1)
}

func trans(nums []int, start, end int) {
	for i, j := start, end; i < j; i, j = i+1, j-1 {
		nums[i], nums[j] = nums[j], nums[i]
	}
}

func main() {
	ints := []int{1, 2, 3, 4, 5, 6, 7}
	rotateRedo(ints, 3)
	fmt.Println(ints)
}

// 1,2,3,4,5,6,7
// 7,6,5,4,3,2,1
// 5,6,7,1,2,3,4
