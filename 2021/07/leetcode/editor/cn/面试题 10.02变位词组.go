//编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
//
// 注意：本题相对原题稍作修改
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串 排序
// 👍 40 👎 0

package main

import (
	"sort"
	"strings"
)

//leetcode submit region begin(Prohibit modification and deletion)
func groupAnagrams(strs []string) [][]string {
	var res [][]string
	indexMap := make(map[string]int)
	for _, str := range strs {
		strArr := strings.Split(str, "")
		sort.Strings(strArr)
		s := strings.Join(strArr, "")
		if index, ok := indexMap[s]; ok {
			res[index] = append(res[index], str)
		} else {
			indexMap[s] = len(res)
			res = append(res, []string{str})
		}
	}
	return res
}

//leetcode submit region end(Prohibit modification and deletion)
