package main

import "fmt"

func removeDuplicates(nums []int) int {
	n := len(nums)
	for i := 1; i < n; {
		if nums[i-1] == nums[i] && i < n-1 && nums[i+1] == nums[i] {
			move(nums, i, n)
			n--
		} else {
			i++
		}
	}
	return n
}

func move(nums []int, startIndex, n int) {
	for i := startIndex + 1; i < n; i++ {
		nums[i-1] = nums[i]
	}
}

func main() {
	//nums := []int{1, 1, 1, 2, 2, 3}
	//nums := []int{0,0,1,1,1,1,2,3,3}
	nums := []int{0, 0, 1, 1, 1, 1, 2, 3, 3}
	duplicates := removeDuplicates(nums)
	fmt.Println(nums[:duplicates])
}
