package daily

import "sort"

//frequencySort 按照出现频率升序排序，频率相同，降序排序
func frequencySort(nums []int) []int {
	m := make(map[int]int, 15)

	for _, num := range nums {
		m[num]++
	}

	sort.Slice(nums, func(i, j int) bool {
		return m[nums[i]] < m[nums[j]] || (m[nums[i]] == m[nums[j]] && nums[i] > nums[j])
	})

	return nums
}
