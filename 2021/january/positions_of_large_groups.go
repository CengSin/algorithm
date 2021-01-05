package main

import "fmt"

func largeGroupPositions(s string) [][]int {
	var result [][]int
	for i := 0; i < len(s); i++ {
		j := i + 1
		for ; j < len(s) && s[i] == s[j]; j++ {
		}
		if j-i > 2 {
			result = append(result, []int{i, j - 1})
			i = j - 1
		}
	}
	return result
}

func main() {
	positions := largeGroupPositions("abbxxxxzzy")
	fmt.Printf("%#v\n", positions)
}
