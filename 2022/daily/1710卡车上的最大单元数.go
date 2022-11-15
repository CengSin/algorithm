package daily

import "sort"

func MaximumUnits(boxTypes [][]int, truckSize int) int {
	return maximumUnits(boxTypes, truckSize)
}

func maximumUnits(boxTypes [][]int, truckSize int) (ans int) {
	// 一趟都不走
	if len(boxTypes) == 0 || truckSize == 0 {
		return
	}

	// 一趟全装走
	allBoxCnt := 0
	for _, boxType := range boxTypes {
		allBoxCnt += boxType[0]
		ans += boxType[0] * boxType[1]
	}
	if allBoxCnt < truckSize {
		return
	}

	// 一趟只能装一部分走
	ans = 0
	sort.Slice(boxTypes, func(i, j int) bool {
		return boxTypes[i][1] > boxTypes[j][1]
	})

	for i := 0; truckSize != 0 && i <= len(boxTypes); i++ {
		boxCnt := boxTypes[i][0]

		if truckSize < boxTypes[i][0] {
			boxCnt = truckSize
		}

		ans += boxCnt * boxTypes[i][1]
		truckSize -= boxCnt
	}
	return
}
