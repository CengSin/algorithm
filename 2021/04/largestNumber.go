package main

import (
	"sort"
	"strconv"
	"strings"
)

func largestNumber(nums []int) string {
	var numStrs []string

	for _, num := range nums {
		numStrs = append(numStrs, strconv.Itoa(num))
	}

	sort.Slice(numStrs, func(i, j int) bool {
		return numStrs[i]+numStrs[j] >= numStrs[j]+numStrs[i]
	})

	result := strings.Join(numStrs, "")

	if result[0] == '0' {
		return "0"
	}

	return result
}

func main() {

}
