//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
//
// 例如，
//
// [2,3,4] 的中位数是 3
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5
//
// 设计一个支持以下两种操作的数据结构：
//
//
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。
// double findMedian() - 返回目前所有元素的中位数。
//
//
// 示例：
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3)
//findMedian() -> 2
//
// 进阶:
//
//
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
//
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 514 👎 0

package main

import (
	"container/heap"
	"sort"
)

//leetcode submit region begin(Prohibit modification and deletion)

type hp struct {
	sort.IntSlice
}

func (h *hp) Push(x interface{}) {
	h.IntSlice = append(h.IntSlice, x.(int))
}

func (h *hp) Pop() interface{} {
	a := h.IntSlice
	val := a[len(a)-1]
	h.IntSlice = a[:len(a)-1]
	return val
}

type MedianFinder struct {
	queMin, queMax hp
}

/** initialize your data structure here. */
func Constructor() MedianFinder {
	return MedianFinder{}
}

func (this *MedianFinder) AddNum(num int) {
	min, max := &this.queMin, &this.queMax
	if len(min.IntSlice) == 0 || num <= -min.IntSlice[0] {
		heap.Push(min, -num)
		if max.Len()+1 < min.Len() {
			heap.Push(max, -heap.Pop(min).(int))
		}
	} else {
		heap.Push(max, num)
		if max.Len() > min.Len() {
			heap.Push(min, -heap.Pop(max).(int))
		}
	}
}

func (this *MedianFinder) FindMedian() float64 {
	min, max := &this.queMin, &this.queMax
	if min.Len() != max.Len() {
		return float64(-min.IntSlice[0])
	}
	return (float64(-min.IntSlice[0]) + float64(max.IntSlice[0])) / 2
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * obj := Constructor();
 * obj.AddNum(num);
 * param_2 := obj.FindMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)
