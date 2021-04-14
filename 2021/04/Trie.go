package main

import "fmt"

type Trie struct {
	val  rune
	end  bool
	next []*Trie
}

/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{
		next: make([]*Trie, 26),
	}
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {
	node := this
	for _, c := range word {
		v := c - 'a'
		if node.next[v] == nil {
			trie := Constructor()
			node.next[v] = &trie
			node.next[v].val = c
		}
		node = node.next[v]
	}

	node.end = true
}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	node := this
	for _, c := range word {
		v := c - 'a'
		if node.next[v] == nil {
			return false
		}
		node = node.next[v]
	}
	return node.end
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	node := this
	for _, c := range prefix {
		v := c - 'a'
		if node.next[v] == nil {
			return false
		}
		node = node.next[v]
	}
	return true
}

/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor()
 * obj.Insert(word)
 * param_2 := obj.Search(word)
 * param_3 := obj.StartsWith(prefix)
 */

func main() {
	trie := Constructor()
	trie.Insert("apple")
	fmt.Println(trie.Search("apple"))   // 返回 True
	fmt.Println(trie.Search("app"))     // 返回 False
	fmt.Println(trie.StartsWith("app")) // 返回 True
	trie.Insert("app")
	fmt.Println(trie.Search("app")) // 返回 True
}
