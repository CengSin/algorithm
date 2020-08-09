package main

// 排序栈，要求只能申请临时的其他一个栈空间

// 我们可以使用两个栈和一个临时变量

// 最小的元素排在栈顶

// 申请两个栈，分别命名为heap和stackPush

type SortedStack struct {
	Stack []int
}

func SortedStackConstructor() SortedStack {
	return SortedStack{
		Stack: make([]int, 0, 10),
	}
}

func (this *SortedStack) sortedStackByStack() {
	newStack := make([]int, 0, len(this.Stack))
	for len(this.Stack) != 0 {
		num := this.Stack[len(this.Stack)-1]
		this.Stack = this.Stack[0:len(this.Stack) - 1]
		for len(newStack) != 0 && newStack[len(newStack)-1] > num {
			this.Stack = append(this.Stack, newStack[len(newStack)-1])
			newStack = newStack[0 : len(newStack)-1]
		}
		newStack = append(newStack, num)
	}

	for len(newStack) != 0 {
		num := newStack[len(newStack)-1]
		this.Stack = append(this.Stack, num)
		newStack = newStack[0 : len(newStack)-1]
	}
}

func (this *SortedStack) Push(val int) {
	this.Stack = append(this.Stack, val)
	this.sortedStackByStack()
}

func (this *SortedStack) Pop() {
	this.Stack = this.Stack[0:len(this.Stack) - 1]
}

func (this *SortedStack) Peek() int {
	if len(this.Stack) == 0 {
		return -1
	}
	return this.Stack[len(this.Stack) - 1]
}

func (this *SortedStack) IsEmpty() bool {
	return len(this.Stack) == 0
}

/**
 * Your SortedStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(val);
 * obj.Pop();
 * param_3 := obj.Peek();
 * param_4 := obj.IsEmpty();
 */
