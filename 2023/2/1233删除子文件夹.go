package main

import (
	"fmt"
	"sort"
	"strings"
)

type node struct {
	val   string
	child []*node
}

func (n *node) construct(fld []string) {
	if len(fld) == 0 {
		return
	}

	for _, s := range fld {
		appendNode(n, s)
	}
}

func appendNode(n *node, s string) {
	if strings.HasPrefix(s, n.val) {
		if len(n.child) > 0 {
			for _, c := range n.child {
				if strings.HasPrefix(s, c.val) && strings.HasPrefix(strings.TrimPrefix(s, c.val), `/`) {
					appendNode(c, s)
					return
				}
			}
		}
		n.child = append(n.child, &node{
			val: s,
		})
	}
}

func (n *node) getRootChildVals() []string {
	if len(n.child) == 0 {
		return nil
	}

	var vals []string
	for _, nd := range n.child {
		vals = append(vals, nd.val)
	}
	return vals
}

func removeSubfolders(folder []string) []string {
	//  sort.Strings(folder)
	//  ans := []string{folder[0]}
	//	for _, s := range folder[1:] {
	//		pre := ans[len(ans)-1]
	//		if !strings.HasPrefix(s, pre) || s[len(pre)] != '/' {
	//			ans = append(ans, s)
	//		}
	//	}
	//  return ans
	if len(folder) == 0 {
		return nil
	}

	sort.Strings(folder)

	root := new(node)
	root.construct(folder)
	return root.getRootChildVals()
}

func main() {
	folders := []string{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"}
	fmt.Printf("[%+v]\n", removeSubfolders(folders))
}
