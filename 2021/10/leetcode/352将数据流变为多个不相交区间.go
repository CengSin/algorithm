package leetcode

type SummaryRanges struct {
	arr [10002]bool
}

func Constructor() SummaryRanges {
	return SummaryRanges{[10002]bool{}}
}

func (this *SummaryRanges) AddNum(val int) {
	this.arr[val] = true
}

func (this *SummaryRanges) GetIntervals() (res [][]int) {
	start := -1
	for i := 0; i < 10002; i++ {
		if this.arr[i] {
			if start == -1 {
				start = i
			}
			continue
		}
		if start != -1 {
			res = append(res, []int{start, i - 1})
			start = -1
		}
	}

	return
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * obj := Constructor();
 * obj.AddNum(val);
 * param_2 := obj.GetIntervals();
 */
