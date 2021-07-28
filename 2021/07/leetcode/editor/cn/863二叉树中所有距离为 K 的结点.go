//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
//
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
//
//
//
//
//
//
// 示例 1：
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//输出：[7,4,1]
//解释：
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//
//
//注意，输入的 "root" 和 "target" 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
//
//
//
//
// 提示：
//
//
// 给定的树是非空的。
// 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
// 目标结点 target 是树上的结点。
// 0 <= K <= 1000.
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树
// 👍 378 👎 0

package main

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
//cannotDistinct 没有办法过滤掉target相同路径上的节点，导致会出现到了跟节点之后，再返回target的情况出现在结果中
func cannotDistinct(root *TreeNode, target *TreeNode, k int) []int {
	// get distance that root to target node
	getDeep := func() int {
		var queue []*TreeNode
		queue = append(queue, root)
		var deep int
		for len(queue) > 0 {
			ql := len(queue)
			for ql > 0 {
				node := queue[0]
				queue = queue[1:]
				ql--
				if node == target {
					return deep
				}
				if node.Left != nil {
					queue = append(queue, node.Left)
				}
				if node.Right != nil {
					queue = append(queue, node.Right)
				}
			}
			deep += 1
		}
		return -1
	}

	targetDeep := getDeep()
	if targetDeep < 0 {
		return nil
	}

	getDistanceForK := func(root *TreeNode, i int) []int {
		if i <= 0 {
			return []int{}
		}

		var ans []int
		var queue []*TreeNode
		var deep int
		queue = append(queue, root)
		for len(queue) > 0 {
			ql := len(queue)
			for ql > 0 {
				node := queue[0]
				queue = queue[1:]
				ql--
				if deep == i && node != target {
					ans = append(ans, node.Val)
					continue
				}
				if node.Left != nil {
					queue = append(queue, node.Left)
				}
				if node.Right != nil {
					queue = append(queue, node.Right)
				}
			}
			deep++
		}
		return ans
	}

	var result []int
	if targetDeep == k {
		result = append(result, root.Val)
	}

	abs := func(a int) int {
		if a < 0 {
			a = 0 - a
		}
		return a
	}
	result = append(result, getDistanceForK(root, abs(k-targetDeep))...)
	result = append(result, getDistanceForK(target, k)...)
	return result
}

func distanceK(root *TreeNode, target *TreeNode, k int) []int {
	// DFS记录每个节点的父节点

	parent := make(map[int]*TreeNode)
	var dfs func(node *TreeNode)
	dfs = func(node *TreeNode) {
		if node == nil {
			return
		}

		if node.Left != nil {
			parent[node.Left.Val] = node
			dfs(node.Left)
		}

		if node.Right != nil {
			parent[node.Right.Val] = node
			dfs(node.Right)
		}
	}

	dfs(root)

	ans := []int{}
	var getDistance func(node, from *TreeNode, d int)
	getDistance = func(node, from *TreeNode, d int) {
		if node == nil {
			return
		}

		if d == k {
			ans = append(ans, node.Val)
			return
		}

		if node.Left != from {
			getDistance(node.Left, node, d+1)
		}

		if node.Right != from {
			getDistance(node.Right, node, d+1)
		}

		if parent[node.Val] != from { // 父节点可能会重复访问node
			getDistance(parent[node.Val], node, d+1)
		}
	}

	getDistance(target, nil, 0)
	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
