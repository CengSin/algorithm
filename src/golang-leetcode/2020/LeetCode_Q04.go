package main

import "fmt"

func cutBar(n, m int) int {
	ans := 0
	slices := 1
	for slices < n {
		ans++
		slices += min(slices, m)
	}
	return ans
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	fmt.Println(cutBar(8, 3))
	fmt.Println(cutBar(20, 3))
}
