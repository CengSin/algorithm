//输入两个链表，找出它们的第一个公共节点。
//
// 如下面的两个链表：
//
//
//
// 在节点 c1 开始相交。
//
//
//
// 示例 1：
//
//
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
//kipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
//
//
//
//
// 示例 2：
//
//
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
//
//
//
//
// 示例 3：
//
//
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
//
//
//
//
// 注意：
//
//
// 如果两个链表没有交点，返回 null.
// 在返回结果后，两个链表仍须保持原有的结构。
// 可假定整个链表结构中没有循环。
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
// 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lis
//ts/
//
// Related Topics 哈希表 链表 双指针
// 👍 304 👎 0

package main

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
//getIntersectionNode 获取两个链表的第一个公共节点。
// 第一种思路：在遍历的过程中，修改链表的值为某一个固定的值，如果第二次碰到这个值，那么说明这个节点就是链表的重合点
// 第二种思路：两个链表如果有一个公共的节点的话，那么这个公共的节点之后的节点应该是一样的，那么我们从尾部节点开始遍历。
//   当匹配到第一个不一样的节点的时候，那么下一个节点的子节点就是第一个公共节点。我们遍历链表是从前往后遍历的，但是要求从后往前比较，最新遍历的节点最后比较，符合栈的特点。
func getIntersectionNode(headA, headB *ListNode) *ListNode {
	if headA == nil || headB == nil {
		return nil
	}

	if headA == headB {
		return headA
	}

	var stack1, stack2 []*ListNode
	travese := func(head *ListNode, stack *[]*ListNode) {
		if head == nil {
			return
		}

		for head != nil {
			tmp := head
			*stack = append(*stack, tmp)
			head = head.Next
		}
	}

	travese(headA, &stack1)
	travese(headB, &stack2)

	i := 0
	for i < len(stack1) && i < len(stack2) && stack1[len(stack1)-i-1] == stack2[len(stack2)-i-1] {
		i++
	}

	// 如果i超过了某个链表的长度的问题
	if i < len(stack1) && stack1[len(stack1)-i-1].Next != nil {
		return stack1[len(stack1)-i-1].Next
	}
	return stack2[len(stack2)-i-1].Next
}

//leetcode submit region end(Prohibit modification and deletion)
