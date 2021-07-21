package main

func getIntersectionNodeByTwoPoints(headA, headB *ListNode) *ListNode {
	if headA == nil || headB == nil {
		return nil
	}

	pa, pb := headA, headB
	for pa != pb {
		if pa == nil {
			pa = headA
		} else {
			pa = pa.Next
		}

		if pb == nil {
			pb = headB
		} else {
			pb = pb.Next
		}
	}
	return pa
}
