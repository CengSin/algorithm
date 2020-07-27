package main

import (
	"fmt"
	"strings"
)

//5472. 重新排列字符串 显示英文描述
//
//给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
//
//请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
//
//返回重新排列后的字符串。

//思路，根据indices数组排序，但调整的事字符串s

func restoreString(s string, indices []int) string {

	if len(indices) <= 0 {
		return ""
	}

	chs := make([]rune, len(s))
	for i, val := range s {
		chs[i] = val
	}

	for start := 1; start < len(indices); start++ {
		tmp := indices[start]

		r := chs[start]
		index := start
		for ; index > 0 && tmp < indices[index - 1]; index-- {
			chs[index] = chs[index-1]
			indices[index] = indices[index-1]
		}
		indices[index] = tmp

		chs[index] = r
	}

	builder := strings.Builder{}

	for _, ch := range chs {
		builder.WriteRune(ch)
	}

	return builder.String()
}

func main() {
	var s string
	s = "codeleet"
	indices := []int{4, 5, 6, 7, 0, 2, 1, 3}

	s2 := restoreString(s, indices)
	fmt.Println(s2)
}
