package main

type Stack []int

func (s *Stack) Pop() (val int) {
	if s.Empty() {
		panic("stack is empty")
	}

	val = (*s)[len(*s)-1]
	*s = (*s)[:len(*s)-1]
	return val
}

func (s *Stack) Push(val int) {
	*s = append(*s, val)
}

func (s *Stack) Empty() bool {
	return len(*s) == 0
}

func checkValidString(s string) bool {
	leftStack, starStack := &Stack{}, &Stack{}

	for i, c := range s {
		if c == '(' {
			leftStack.Push(i)
		} else if c == '*' {
			starStack.Push(i)
		} else if !leftStack.Empty() {
			leftStack.Pop()
		} else if !starStack.Empty() {
			starStack.Pop()
		} else {
			return false
		}
	}

	for !leftStack.Empty() && !starStack.Empty() {
		if leftStack.Pop() > starStack.Pop() {
			return false
		}
	}

	if !leftStack.Empty() && starStack.Empty() {
		return false
	}

	return true
}
