package daily

import "bytes"

// magicalString 初始字符串为122，返回在神奇字符串 s 的前 n 个数字中 1 的数目。
func magicalString(n int) int {
	s := make([]byte, 0, n+1)
	s = append(s, 1, 2, 2)
	c := []byte{2}
	for i := 2; len(s) < n; i++ {
		c[0] ^= 3 // 1 ^ 3 = 2  2 ^ 3 = 1
		s = append(s, bytes.Repeat(c, int(s[i]))...)
	}

	return bytes.Count(s[:n], []byte{1})
}
