package main

import (
	"sort"
)

func alertNames(keyName []string, keyTime []string) (warnList []string) {
	keyInfoMap := make(map[string][]int)
	for i, name := range keyName {
		keyInfoMap[name] = append(keyInfoMap[name], toMinutes(keyTime[i]))
	}

	for name, useKeyCardTime := range keyInfoMap {
		sort.Ints(useKeyCardTime)
		if useKeyCard3TimesInHour(useKeyCardTime) {
			warnList = append(warnList, name)
		}
	}

	if len(warnList) != 0 {
		sort.Strings(warnList)
	}

	return
}

func toMinutes(t string) int {
	hour := int(t[0]-'0')*10 + int(t[1]-'0')
	minute := int(t[3]-'0')*10 + int(t[4]-'0')
	return hour*60 + minute
}

func useKeyCard3TimesInHour(useKeyCardTime []int) bool {
	// 窗口思维，直接拿三个数字比较最小和最大的差距即可。
	// 同一小时内超过3次，所以这里只检查[0:len-2]下标处的时间与[2:len]下表处的时间差是否<=60,如果[n-n+2]的时间差<=60,那么说明n,n+1,n+2这三次都是在一个小时内，所以符合条件
	for i, t := range useKeyCardTime[2:] {
		if t-useKeyCardTime[i] <= 60 {
			return true
		}
	}
	return false
}
