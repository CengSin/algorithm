package com.company.simple;

import java.util.Arrays;

/**
 * @description: 分糖果，妹妹分到的糖果种类最多
 * @author: 15262
 * @date: 2020/3/31
 */

class LeetCode_575_Solution {

    public int distributeCandies(int[] candies) {
        return timeTooLong(candies);
    }

    private int timeTooLong(int[] candies) {
        int middle = candies.length / 2;
        int upSize = 100000;
        int[] res = new int[upSize + upSize + 1];
        for (int index : candies) {
            res[index + upSize]++;
        }
        Arrays.sort(res);
        long count = Arrays.stream(res).filter(i -> i > 0).count();
        // 查询种类是否大于等于 middle
        if (count > middle) {
            return middle;
        } else { // 种类小于middle
            return (int) count;
        }
    }

}

public class LeetCode_575_DistributeCandies {

    public static void main(String[] args) {
        LeetCode_575_Solution solut = new LeetCode_575_Solution();
        /*System.out.println(solut.distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
        System.out.println(solut.distributeCandies(new int[]{1, 1, 2, 3}));*/
        System.out.println(solut.distributeCandies(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3}));
    }

}
