package main

import (
	"container/heap"
	"sort"
)

type pair struct {
	right, height int
}

type hp []pair

func (h hp) Len() int {
	return len(h)
}

func (h hp) Less(i, j int) bool {
	return h[i].height > h[j].height
}

func (h hp) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *hp) Push(x interface{}) {
	*h = append(*h, x.(pair))
}

func (h *hp) Pop() interface{} {
	a := *h
	v := a[len(a)-1]
	*h = a[:len(a)-1]
	return v
}

func getSkylineOptimize(buildings [][]int) (ans [][]int) {
	var edgePoints []int
	for _, building := range buildings {
		edgePoints = append(edgePoints, building[0], building[1])
	}

	sort.Ints(edgePoints)

	n := len(buildings)
	h := hp{}
	idx := 0
	for _, point := range edgePoints {
		for idx < n && buildings[idx][0] <= point {
			heap.Push(&h, pair{buildings[idx][1], buildings[idx][2]})
			idx++
		}

		for h.Len() != 0 && h[0].right <= point {
			heap.Pop(&h)
		}

		maxHight := 0
		if h.Len() > 0 {
			maxHight = h[0].height
		}

		if len(ans) == 0 || ans[len(ans)-1][1] != maxHight {
			ans = append(ans, []int{point, maxHight})
		}
	}

	return
}
