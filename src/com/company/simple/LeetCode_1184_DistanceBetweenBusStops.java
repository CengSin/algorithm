package com.company.simple;

/**
 * @description: 公交车站之间的距离
 * @author: 15262
 * @date: 2020/3/30
 */

class LeetCode_1184_Solution {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int forward = 0;
        if (start > destination) {
            start += destination;
            destination = start - destination;
            start -= destination;
        }
        for (int i = start; i < destination; i++) {
            forward += distance[i];
        }
        int reverse = 0;
        for (int i = destination; i != start; i = (i + 1) % distance.length) {
            reverse += distance[i];
        }
        return Math.min(forward, reverse);
    }

}

public class LeetCode_1184_DistanceBetweenBusStops {

    public static void main(String[] args) {
        LeetCode_1184_Solution solution = new LeetCode_1184_Solution();
        System.out.println(solution.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 3));
        System.out.println(solution.distanceBetweenBusStops(new int[]{7,10,1,12,11,14,5,0}, 7, 2));
    }

}
