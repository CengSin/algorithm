package main

import (
	"sort"
)

// [1, 2, 3]
// 1. 首先创建一个空集[]放入结果
// 2. 复制结果中的数组
// 3. 将参数数组中的数字放入复制出来的数组，变成了 [] [] -> [] [1] 放入结果
// [] [1] -> [] [1] [2] [1, 2] 后面两个是复制的前两个然后加上2
// [] [1] [2] [1, 2] copy and add 3 -> [3] [1, 3] [2, 3], [1, 2, 3]

func subsetsWithDup(nums []int) [][]int {
	sort.Ints(nums)

	n := len(nums)
	var result [][]int
	var tmp []int
	visited := make([]bool, n)

	var dfs func(start int)
	dfs = func(start int) {
		r := make([]int, len(tmp))
		copy(r, tmp)
		result = append(result, r)

		for i := start; i < n; i++ {
			if visited[i] || (i > 0 && nums[i-1] == nums[i] && !visited[i-1]) {
				continue
			}

			visited[i] = true
			tmp = append(tmp, nums[i])
			dfs(i + 1)
			visited[i] = false
			tmp = tmp[:len(tmp)-1]
		}
	}

	dfs(0)

	// 复制法 https://leetcode-cn.com/problems/subsets/solution/zi-ji-by-leetcode-solution/
	// result  = append(result, []int{})
	//for i := 0; i < len(nums); i++ {
	//	var dst []int
	//	var tmp [][]int
	//	for _, src := range result {
	//		n := len(src)
	//		dst = make([]int, n)
	//		copy(dst, src)
	//		dst = append(dst, nums[i])
	//		tmp = append(tmp, dst)
	//	}
	//	result = append(result, tmp...)
	//}

	return result
}

func main() {
	subsetsWithDup([]int{1, 2, 3})
	subsetsWithDup([]int{1, 2, 2})
}
