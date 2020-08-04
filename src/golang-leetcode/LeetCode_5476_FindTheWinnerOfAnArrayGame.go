package main

import "fmt"

// 降序排序，找第k个数字

// 三种情况
// 数字在两边和数字在中间
// 数字在开头处，只要他后面的k个数字都比他小即可
// 数字在结尾，只要他前面k个数字比他小即可
// 数字在中间，只要他前面的数字都比他小，后面的连续k-1个数字比他小即可

func getWinner(arr []int, k int) int {
	lens := len(arr)
	if k > lens {
		maxNum := arr[0]
		for i := 0; i < lens; i++ {
			if arr[i] > maxNum {
				maxNum = arr[i]
			}
		}
		return maxNum
	}
	for i := range arr {
		cnt := lessThanValCnt(arr, i, k, lens)
		if cnt >= k {
			return cnt
		}
	}
	return 0
}

func lessThanValCnt(arr []int, flagIndex, k, lens int) int {
	cnt := 0
	if flagIndex == 0 {
		for i := 1; i < lens && i <= k; i++ {
			if arr[i] > arr[flagIndex] {
				return cnt
			} else {
				cnt++
			}
		}
	} else if flagIndex == lens-1 {
		for i := lens - 1; i >= 0 && i >= lens-k-1; i-- {
			if arr[i] > arr[flagIndex] {
				return cnt
			} else {
				cnt++
			}
		}
	} else {
		for i := 0; i < flagIndex; i++ {
			if arr[i] <= arr[flagIndex] {
				cnt++
			} else {
				break
			}
		}
		for i := flagIndex + 1; i < lens && i < flagIndex+k; i++ {
			if arr[i] <= arr[flagIndex] {
				cnt++
			} else {
				return cnt
			}
		}
	}
	return cnt
}

func timeLimit(arr []int, k int) int {
	cnt := 0
	frontWin := arr[0]
	lens := len(arr)

	maxNum := arr[0]
	for i := 0; i < lens; i++ {
		if arr[i] > maxNum {
			maxNum = arr[i]
		}
	}
	// 获胜的数字在0
	// 输掉的数字在len(arr) - 1
	for {
		// 数组如果有序的话直接返回arr[0]
		if arr[0] == maxNum {
			return maxNum
		}

		// 如果第一个数字大于第零个数字，那么首先交换第一个数字和第零个数字，之后按照第零个数字比较大的情况走
		if arr[0] <= arr[1] {
			swap(arr, 0, 1)
		}

		tmp := arr[1]
		move(arr, 1, len(arr))
		arr[len(arr)-1] = tmp

		if frontWin == arr[0] {
			cnt++
		} else {
			cnt = 1
			frontWin = arr[0]
		}

		if cnt == k {
			return frontWin
		}
	}
}

func move(arr []int, startIndex int, endIndex int) {
	for i := startIndex + 1; i < endIndex; i++ {
		arr[i-1] = arr[i]
	}
}

func swap(arr []int, i int, j int) {
	arr[i], arr[j] = arr[j], arr[i]
}

func main() {
	arr := []int{2, 1, 3, 5, 4, 6, 7}
	k := 2
	winner := getWinner(arr, k)
	fmt.Println(winner)
}
