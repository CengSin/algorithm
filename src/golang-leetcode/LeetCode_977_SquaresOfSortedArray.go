package main

import "sort"

func sortedSquares(A []int) []int {
	return TwoPoint(A)
}

// TwoPoint 双指针
// A是一个非递减顺序的数组，
// 如果A数组中全是非负数，那么平方后认为非递减
// 如果A数组中全是非负数，那么平方后则为非递增
// 如果A数组中两种情况都包括，且A数组为非递减的话，我们可以找到最后一个负数的下标，然后对平方后的数组排序
func TwoPoint(a []int) []int {
	inx := getLatestLessZero(a)

	for i, val := range a {
		a[i] = val * val
	}

	if inx == len(a) {
		sort.Ints(a)
		return a
	}

	if inx == 0 {
		return a
	}

	minx := inx + 1
	var result []int
	for inx >= 0 && minx < len(a) {
		if a[inx] < a[minx] {
			result = append(result, a[inx])
			inx--
		} else {
			result = append(result, a[minx])
			minx++
		}
	}

	for inx >= 0 {
		result = append(result, a[inx])
		inx--
	}

	for minx < len(a) {
		result = append(result, a[minx])
		minx++
	}

	return result

}

func getLatestLessZero(a []int) int {
	i := 0
	for i < len(a) && a[i] < 0 {
		i++
	}
	return i
}

func BaoLiSort(A []int) []int {
	for i, val := range A {
		A[i] = val * val
	}

	sort.Ints(A)

	return A
}
