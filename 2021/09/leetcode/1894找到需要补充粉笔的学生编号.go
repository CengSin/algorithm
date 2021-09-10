package main

import "sort"

//chalkReplacer 普通思路肯定是循环chalk，k每次减去chalk[i]的值，直到差为负数，则输出下表i
// 优化模拟：循环可以直接用除法来代替，但是这样会丢失最后一次的k的值，所以使用取余代替
// 前缀和+二分搜索：对于上面解法中的第二次训话，可以使用二分查找进行优化
func chalkReplacer(chalk []int, k int) int {
	solution1 := func() int {
		total := 0
		for _, i := range chalk {
			total += i
		}

		k %= total
		for i, c := range chalk {
			if k < c {
				return i
			}
			k -= c
		}
		return 0
	}

	solution2 := func() int {
		if chalk[0] > k {
			return 0
		}

		for i := 1; i < len(chalk); i++ {
			chalk[i] += chalk[i-1]
			if chalk[i] > k {
				return i
			}
		}

		k %= chalk[len(chalk)-1]
		return sort.SearchInts(chalk, k+1)
	}

	return 0
}
