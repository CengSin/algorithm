package tree

func isValidSerialization(preorder string) bool {
	n := len(preorder)
	stk := []int{1}
	for i := 0; i < n; {
		if len(stk) == 0 {
			return false
		}

		switch preorder[i] {
		case ',':
			i++
		case '#':
			stk[len(stk)-1]--
			if stk[len(stk)-1] == 0 {
				stk = stk[:len(stk)-1]
			}
			i++
		default:
			for i < n && preorder[i] != ',' {
				i++
			}

			stk[len(stk)-1]--
			if stk[len(stk)-1] == 0 {
				stk = stk[:len(stk)-1]
			}
			stk = append(stk, 2)
		}
	}

	return len(stk) == 0
}
