package main

import "math"

// 统计好三元组

func countGoodTriplets(arr []int, a int, b int, c int) int {
	cnt := 0
	lens := len(arr)

	for i := 0; i < lens; i++ {
		for j := i + 1; j < lens; j++ {
			for k := j + 1; k < lens; k++ {
				lessA := math.Abs(float64(arr[i] - arr[j]))
				lessB := math.Abs(float64(arr[j] - arr[k]))
				lessC := math.Abs(float64(arr[i] - arr[k]))
				if int(lessA) <= a && int(lessB) <= b && int(lessC) <= c {
					cnt++
				}
			}
		}
	}

	return cnt
}

func main() {

}
