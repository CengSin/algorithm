package main

import "fmt"

//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//push(x) —— 将元素 x 推入栈中。
//pop() —— 删除栈顶的元素。
//top() —— 获取栈顶元素。
//getMin() —— 检索栈中的最小元素。

// 思路，一个栈命名为stackData，用来存储输入的数据，另一个栈命名为stackMin，用来存储每一步最小的数字
// GetMin只需要从StackMin中取栈顶数字就可以了
type MinStack struct {
	StackData []int
	StackMin  []int
}

/** initialize your data structure here. */
func Constructor() MinStack {
	m := new(MinStack)
	m.StackData = make([]int, 0, 10)
	m.StackMin = make([]int, 0, 10)
	return *m
}

func (this *MinStack) Push(x int) {
	minLens := len(this.StackMin)
	if minLens == 0 || this.StackMin[minLens-1] >= x {
		this.StackMin = append(this.StackMin, x)
	}
	this.StackData = append(this.StackData, x)
}

func (this *MinStack) Pop() {
	dataLens := len(this.StackData)
	if dataLens == 0 {
		return
	}
	x := this.StackData[dataLens-1]
	minLens := len(this.StackMin)
	if x == this.StackMin[minLens-1] {
		this.StackMin = this.StackMin[0 : minLens-1]
	}
	this.StackData = this.StackData[0 : dataLens-1]
}

func (this *MinStack) Top() int {
	datalens := len(this.StackData)
	val := this.StackData[datalens-1]
	return val
}

func (this *MinStack) GetMin() int {
	minLens := len(this.StackMin)
	if minLens == 0 {
		return 0
	}
	return this.StackMin[minLens-1]
}

/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor()
 * obj.Push(x)
 * obj.Pop()
 * param_3 := obj.Top()
 * param_4 := obj.GetMin()
 */

func main() {
	// TestCase1()
	// TestCase2()
	TestCase3()
}

func TestCase3() {
	//["MinStack","push","push","push","getMin","pop","getMin"]
	//[[],[0],[1],[0],[],[],[]]
	m := new(MinStack)
	m.Push(0)
	m.Push(1)
	m.Push(0)
	fmt.Println(m.GetMin())
	m.Pop()
	fmt.Println(m.GetMin())
}

func TestCase2() {
	m := new(MinStack)
	m.Push(-1)
	m.GetMin()
}

func TestCase1() {
	minStack := new(MinStack)
	minStack.Push(-2)
	minStack.Push(0)
	minStack.Push(-3)
	fmt.Println(minStack.GetMin()) //  --> 返回 -3.
	minStack.Pop()
	fmt.Println(minStack.Top())    //--> 返回 0.
	fmt.Println(minStack.GetMin()) //--> 返回 -2.
}
