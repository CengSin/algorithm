package main

import "fmt"

// 用栈实现队列
// 首先栈的特点是，先进后出，队列的特点是先进先出，
// 所有我们使用两个栈，一个栈命名为StackPush，用来保存Push进来的数据，一个栈命名为StackPop，用来保存弹出的数据
// 这样我们只要每次都将StackPush中的数据放入到StackPop中，之后从StackPop中弹出即可
// 但是要避免一个问题，就是在StackPop不为空的时候，不允许向其中放入数据

//push(x) -- 将一个元素放入队列的尾部。
//pop() -- 从队列首部移除元素。
//peek() -- 返回队列首部的元素。
//empty() -- 返回队列是否为空。
// todo 重点，每次push2Pop之后都要使用len函数去更新lens变量，否则会出现indexOut

type MyQueue struct {
	StackPush []int
	StackPop  []int
}

/** Initialize your data structure here. */
func MyQueueConstructor() MyQueue {
	return MyQueue{
		StackPop:  make([]int, 0, 10),
		StackPush: make([]int, 0, 10),
	}
}

/** Push element x to the back of queue. */
func (this *MyQueue) Push(x int) {
	this.StackPush = append(this.StackPush, x)
	this.push2Pop()
}

/** Removes the element from in front of queue and returns that element. */
func (this *MyQueue) Pop() int {
	popLens := len(this.StackPop)
	if len(this.StackPush) == 0 && popLens == 0{
		panic("没有值了")
	}
	this.push2Pop()
	val := this.StackPop[popLens-1]
	this.StackPop = this.StackPop[0:popLens - 1]
	return val
}

/** Get the front element. */
func (this *MyQueue) Peek() int {
	popLens := len(this.StackPop)
	if len(this.StackPush) == 0 && popLens == 0{
		panic("没有值了")
	}
	this.push2Pop()
	return this.StackPop[len(this.StackPop) - 1]
}

/** Returns whether the queue is empty. */
func (this *MyQueue) Empty() bool {
	return len(this.StackPop) == 0 && len(this.StackPush) == 0
}

/** 在StackPop为空的时候将StackPush中的数据全部存入StackPop */
func (this *MyQueue) push2Pop() {
	pushLens := len(this.StackPush)
	if len(this.StackPop) == 0 {
		for pushLens != 0 {
			this.StackPop = append(this.StackPop, this.StackPush[pushLens-1])
			this.StackPush = this.StackPush[0 : pushLens-1]
			pushLens--
		}
	}
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * param_2 := obj.Pop();
 * param_3 := obj.Peek();
 * param_4 := obj.Empty();
 */

func main() {
	constructor := MyQueueConstructor()
	constructor.Push(1)
	constructor.Push(2)
	fmt.Println(constructor.Pop())
	fmt.Println(constructor.Peek())
}