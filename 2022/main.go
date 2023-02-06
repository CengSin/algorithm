package main

import "fmt"

func main() {
	//units := daily.MaximumUnits([][]int{{1, 3}, {5, 5}, {2, 5}, {4, 2}, {4, 1}, {3, 1}, {2, 2}, {1, 3}, {2, 5}, {3, 2}}, 35)
	//fmt.Println(units)

	a := make(map[int64]bool, 15)
	a[1] = true
	a[2] = true
	fmt.Println(a[3])
}
