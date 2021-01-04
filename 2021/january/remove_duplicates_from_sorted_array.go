package main

import "fmt"

func removeDuplicates(nums []int) int {
	for i := 0; i < len(nums)-1; i++ {
		cnt := 0
		index := i + 1
		for index < len(nums) && nums[i] == nums[index] {
			cnt++
			index++
		}
		for j := index; j < len(nums); j++ {
			nums[j-cnt] = nums[j]
		}
		nums = nums[:len(nums)-cnt]
	}

	return len(nums)
}

func main() {
	//nums := []int{0,0,1,1,1,2,2,3,3,4}
	nums := []int{0, 0}
	len1 := removeDuplicates(nums)
	for i := 0; i < len1; i++ {
		fmt.Print(nums[i], " ")
	}
}
