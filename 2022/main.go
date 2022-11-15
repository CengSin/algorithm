package main

import (
	"2022_leetcode/daily"
	"fmt"
)

func main() {
	units := daily.MaximumUnits([][]int{{1, 3}, {5, 5}, {2, 5}, {4, 2}, {4, 1}, {3, 1}, {2, 2}, {1, 3}, {2, 5}, {3, 2}}, 35)
	fmt.Println(units)
}
