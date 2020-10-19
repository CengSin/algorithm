package main

import "fmt"

// backspaceCompare 比较含退格的字符串
func backspaceCompare(S string, T string) bool {
	realS := getRealStr(S)
	realT := getRealStr(T)

	return realS == realT
}

type CharStack []rune

func (s CharStack) Len() int {
	return len(s)
}

// Pop 弹出栈顶元素
func (s *CharStack) Pop() rune {
	if s == nil {
		panic("栈空间未初始化")
	}
	if s.Len() == 0 {
		panic("栈顶元素不存在")
	}
	result := (*s)[s.Len()-1]
	*s = (*s)[0 : s.Len()-1]
	return result
}

func (s *CharStack) Push(c rune) {
	*s = append(*s, c)
}

func (s *CharStack) String() string {
	return string(*s)
}

func getRealStr(s string) string {
	result := new(CharStack)
	for _, r := range s {
		if r == 35 {
			if result.Len() > 0 {
				result.Pop()
			}
			continue
		}
		result.Push(r)
	}
	return result.String()
}

func main() {
	compare := backspaceCompare("y#fo##f", "y#f#o##f")
	fmt.Printf("%+v\n", compare)
}
