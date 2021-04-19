package main

import ()

func removeElement(nums []int, val int) int {
	left := 0
	for _, num := range nums {
		if num != val {
			nums[left] = num
			left++
		}
	}
	return left
}

func main() {
	element := removeElement([]int{2, 2, 3, 3}, 3)
	fmt.Println(element)
}
