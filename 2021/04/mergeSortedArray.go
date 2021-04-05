package main

import (
	"fmt"
	"sort"
)

func merge(nums1 []int, m int, nums2 []int, n int) {
	//hahaha(nums1, nums2, m)

	// 避免从前向后插入的时候出现数字被覆盖的情况，从后向前插入
	for p1, p2, tail := m - 1, n - 1, m + n - 1; p1 >= 0 || p2 >= 0; tail -- {

		var cur int
		if p1 == -1 {
			cur = nums2[p2]
			p2 --
		} else if p2 == -1 {
			cur = nums1[p1]
			p1 --
		} else if nums1[p1] > nums2[p2] {
			cur = nums1[p1]
			p1 --
		} else {
			cur = nums2[p2]
			p2 --
		}

		nums1[tail] = cur

	}

}

func hahaha(nums1, nums2 []int, m int) {
	nums1 = append(nums1[:m], nums2...)
	sort.Ints(nums1)
}

func main() {
	nums1 := []int{2, 0}
	nums2 := []int{1}
	merge(nums1, 1, nums2, 1)
	fmt.Println(nums1)
}
