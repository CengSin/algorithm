package main

import (
	"fmt"
)

const (
	minDegree = 3
)

type BPlusTree struct {
	root *node
}

type node struct {
	isLeaf bool
	keys   []int
	vals   []interface{}
	childs []*node
}

func (t *BPlusTree) insert(key int, val interface{}) {
	if t.root == nil {
		t.root = &node{
			isLeaf: true,
			keys:   []int{key},
			vals:   []interface{}{val},
			childs: []*node{},
		}
		return
	}

	if t.root.isFull() {
		left, right := split(t.root)
		t.root = &node{
			isLeaf: false,
			keys:   []int{right.keys[0]},
			vals:   []interface{}{},
			childs: []*node{left, right},
		}
	}

	t.root.insertNonFull(key, val)
}

func (n *node) insertNonFull(key int, val interface{}) {
	i := n.getIndex(key)
	if n.isLeaf {
		n.keys = append(n.keys[:i], append([]int{key}, n.keys[i:]...)...)
		n.vals = append(n.vals[:i], append([]interface{}{val}, n.vals[i:]...)...)
	} else {
		if n.childs[i].isFull() {
			left, right := split(n.childs[i])
			n.keys = append(n.keys[:i], append([]int{right.keys[0]}, n.keys[i:]...)...)
			n.childs = append(n.childs[:i], append([]*node{left, right}, n.childs[i+1:]...)...)
		}

		if key > n.keys[i] {
			i++
		}
		n.childs[i].insertNonFull(key, val)
	}
}

func (n *node) isFull() bool {
	return len(n.keys) == 2*minDegree-1
}

func (n *node) getIndex(key int) int {
	i := 0
	for i < len(n.keys) && n.keys[i] < key {
		i++
	}
	return i
}

func split(n *node) (left, right *node) {
	left = &node{
		isLeaf: n.isLeaf,
		keys:   n.keys[:minDegree-1],
		vals:   n.vals[:minDegree-1],
		childs: n.childs[:minDegree],
	}
	right = &node{
		isLeaf: n.isLeaf,
		keys:   n.keys[minDegree:],
		vals:   n.vals[minDegree:],
		childs: n.childs[minDegree:],
	}
	return
}

func (t *BPlusTree) search(key int) interface{} {
	if t.root == nil {
		return nil
	}
	return t.root.search(key)
}

func (n *node) search(key int) interface{} {
	i := n.getIndex(key)
	if i < len(n.keys) && n.keys[i] == key {
		return n.vals[i]
	}
	if n.isLeaf {
		return nil
	}
	return n.childs[i].search(key)
}

func main() {
	t := &BPlusTree{}
	t.insert(1, "A")
	t.insert(2, "B")
	t.insert(3, "C")
	t.insert(4, "D")
	t.insert(5, "E")

	fmt.Println(t.search(1))
	fmt.Println(t.search(2))
	fmt.Println(t.search(3))
	fmt.Println(t.search(4))
	fmt.Println(t.search(5))
}
