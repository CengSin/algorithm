package leetcode

import (
	"strconv"
	"strings"
)

func countAndSay(n int) string {
	switch n {
	case 1:
		return "1"
	case 2:
		return "11"
	case 3:
		return "21"
	case 4:
		return "1211"
	case 5:
		return "111221"
	default:
		lessNStr := countAndSay(n - 1)
		var sb strings.Builder
		for i := 0; i < len(lessNStr); {
			j := i + 1
			for ; j < len(lessNStr) && lessNStr[i] == lessNStr[j]; j++ {
			}
			sb.WriteString(strconv.Itoa(j - i))
			sb.WriteByte(lessNStr[i])
			i = j
		}
		return sb.String()
	}
}
