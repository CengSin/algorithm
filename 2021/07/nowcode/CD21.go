package main

import "fmt"

func main() {
	var cnt int
	fmt.Scanln(&cnt)
	var arr []int
	for i := 0; i < cnt; i++ {
		var num int
		fmt.Scan(&num)
		arr = append(arr, num)
	}

	fmt.Println(smallSum(arr))
}

func smallSum(arr []int) int {
	if len(arr) == 0 {
		return 0
	}
	return getSmallSum(arr, 0, len(arr)-1)
}

func getSmallSum(arr []int, l, r int) int {
	if l == r {
		return 0
	}
	mid := int(uint(l+r) >> 1)
	return getSmallSum(arr, l, mid) + getSmallSum(arr, mid+1, r) + merge(arr, l, mid, r)
}

func merge(arr []int, l int, mid int, r int) int {
	h := make([]int, 0, r-l+1)
	smallSum, i, j := 0, l, mid+1
	for i <= mid && j <= r {
		if arr[i] <= arr[j] {
			smallSum += arr[i] * (r - j + 1)
			h = append(h, arr[i])
			i++
		} else {
			h = append(h, arr[j])
			j++
		}
	}

	for ; (j < r+1) || (i < mid+1); i, j = i+1, j+1 {
		if i > mid {
			h = append(h, arr[j])
		} else {
			h = append(h, arr[i])
		}
	}

	for k := 0; k != len(h); k++ {
		arr[l] = h[k]
		l++
	}

	return smallSum
}
