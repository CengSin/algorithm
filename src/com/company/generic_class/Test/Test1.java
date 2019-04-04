package com.company.generic_class.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Date: Create in 15:03 2019/3/13
 */
public class Test1 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();

        for (int i = 0; i < 1; i ++) {
            list.add(i+"");
            list1.add(i+1+"");
        }

        sync(list, list1);
        System.out.println("====================async===========");
        async(list, list1);
        System.out.println("====================result===========");
        System.out.println(syncCompare(list, list1));
        System.out.println(asyncCompare(list, list1));
    }

    public static void async(List<String> list, List<String> list1) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1; i++) {
            asyncCompare(list, list1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("async time = " + (endTime - startTime));
    }

    public static void sync(List<String> list, List<String> list1) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            syncCompare(list, list1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("sync time = " + (endTime - startTime));
    }

    private static List<String> syncCompare(List<String> list, List<String> list1) {
        return list.stream().filter(i -> !list1.contains(i)).collect(Collectors.toList());
//        System.out.println(collect);
    }

    private static List<String> asyncCompare(List<String> list, List<String> list1) {
        return list.parallelStream().filter(i -> !list1.contains(i)).collect(Collectors.toList());
//        System.out.println(collect);
    }

}
