package com.company.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 卡牌分组
 * @author: 15262
 * @date: 2020/3/27
 */

class LeetCode_914_Solution {

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int key : deck) {
            if (!hash.containsKey(key)) {
                hash.put(key, 0);
            }
            hash.put(key, hash.get(key) + 1);
        }
        int divisor = -1;
        for (Integer key : hash.keySet()) {
            Integer value = hash.get(key);
            if (divisor == -1) {
                divisor = value;
            } else if (divisor >= 0 && divisor < 2) {
                return false;
            } else{
                divisor = getDivisor(divisor, value);
            }
        }
        return divisor >= 2;
    }

    private int getDivisor(int max, int min) {
        while (min != 0) {
            int tmp = min;
            min = max % min;
            max = tmp;
        }
        return max;
    }

}

public class LeetCode_914_XKindInDeckCards {

    public static void main(String[] args) {
        LeetCode_914_Solution solut = new LeetCode_914_Solution();
        System.out.println(solut.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
        System.out.println(solut.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
        System.out.println(solut.hasGroupsSizeX(new int[]{1}));
        System.out.println(solut.hasGroupsSizeX(new int[]{1, 1}));
        System.out.println(solut.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2}));
        System.out.println(solut.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2}));
        System.out.println(solut.hasGroupsSizeX(new int[]{0, 0, 0, 0, 0, 1, 1, 2, 3, 4}));
    }

}
