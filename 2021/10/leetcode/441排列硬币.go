package leetcode

import "sort"

func arrangeCoins(n int) (ans int) {
	//for i := 1; n >= 0; i++ {
	//	n -= i
	//	ans++
	//}
	//return

	return sort.Search(n, func(k int) bool {
		k++
		return k*(k+1) > 2*n
	})
}
