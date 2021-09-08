package main

import (
	"container/heap"
	"sort"
)

type hp struct {
	sort.IntSlice
}

func (h *hp) Push(x interface{}) {
	h.IntSlice = append(h.IntSlice, x.(int))
}

func (h *hp) Pop() interface{} {
	slice := h.IntSlice
	val := slice[len(slice)-1]
	h.IntSlice = slice[:len(slice)-1]
	return val
}

func (h hp) Less(i, j int) bool {
	return h.IntSlice[i] > h.IntSlice[j]
}

func findMaximizedCapital(k int, w int, profits []int, capital []int) int {
	type pair struct {
		c, p int
	}

	arr := []pair{}
	for i, profit := range profits {
		arr = append(arr, pair{capital[i], profit})
	}

	sort.Slice(arr, func(i, j int) bool {
		return arr[i].c < arr[j].c
	})

	h := &hp{}
	for cur := 0; k > 0; k-- {
		for cur < len(profits) && arr[cur].c <= w {
			heap.Push(h, arr[cur].p)
			cur++
		}

		if h.Len() == 0 {
			break
		}

		w += heap.Pop(h).(int)
	}

	return w
}
