package main

import (
	"fmt"
	"math"
	"sort"
)

// kClosest k个距离原点最近的点
func kClosest(points [][]int, K int) [][]int {
	if K == 0 {
		return nil
	}

	m := make(map[float64][]int, 16)
	sortArr := make([]float64, 0)
	for i, point := range points {
		key := math.Sqrt(float64(point[0]*point[0] + point[1]*point[1]))
		val := i
		if _, ok := m[key]; !ok {
			m[key] = make([]int, 0)
		}
		m[key] = append(m[key], val)
		sortArr = append(sortArr, key)
	}

	sort.Float64s(sortArr)

	result := make([][]int, 0)
	for i := 0; i < len(sortArr); i++ {
		for _, val := range m[sortArr[i]] {
			result = append(result, points[val])
			if len(result) >= K {
				return result
			}
		}
	}

	return result
}

func main() {
	closest := kClosest([][]int{{1, 0}, {0, 1}}, 2)
	fmt.Printf("%+v\n", closest)
}
