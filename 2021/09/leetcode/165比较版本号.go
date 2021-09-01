package main

import (
	"math"
	"strconv"
	"strings"
)

func compareVersion(version1 string, version2 string) int {
	v1Nums := strings.Split(version1, ".")
	v2Nums := strings.Split(version2, ".")
	n := int(math.Max(float64(len(v1Nums)), float64(len(v2Nums))))

	var sum1, sum2 int
	for i := 0; i < n; i++ {
		var v1, v2 int
		if i < len(v1Nums) {
			v1, _ = strconv.Atoi(v1Nums[i])
		}
		sum1 += v1 * int(math.Pow(10.0, float64(n-i-1)))

		if i < len(v2Nums) {
			v2, _ = strconv.Atoi(v2Nums[i])
		}
		sum2 += v2 * int(math.Pow(10.0, float64(n-i-1)))
	}

	if sum1 > sum2 {
		return 1
	}

	if sum1 == sum2 {
		return 0
	}

	return -1
}
