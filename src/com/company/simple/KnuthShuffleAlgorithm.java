package com.company.simple;

import java.util.Arrays;
import java.util.Random;


/**
 * @description: KnuthShuffle
 * @author: 随即洗牌算法
 * @date: 2020/4/23
 */

public class KnuthShuffleAlgorithm {

    public static final Random gen = new Random();

    // version for array of ints
    public static void shuffle(int[] array) {
        int n = array.length;
        while (n > 1) {
            int k = gen.nextInt(n--); //decrements after using the value
            swap(array, k, n);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        shuffle(array);
        System.out.println(Arrays.toString(array));

        /*int a = gen.nextInt(10);
        int b = gen.nextInt(10);
        System.out.println("a = " + a + ", b = " + b);
        a += b;
        b = a - b;
        a = a - b;
        System.out.println("a = " + a + ", b = " + b);*/
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
