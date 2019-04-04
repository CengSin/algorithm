package com.company.collections;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: JDK8 中的不可变class(immutable class)实现
 *
 * Immutable Objects的介绍：https://blog.csdn.net/u012142247/article/details/81168886
 *
 * https://docs.oracle.com/en/java/javase/11/core/creating-immutable-lists-sets-and-maps.html#GUID-DD066F67-9C9B-444E-A3CB-820503735951
 *
 * @Date: Create in 14:30 2019/3/27
 */
public class Immutable {

    private static List<String> createImmutableList(String... a) {
        List<String> objects = Arrays.asList(a);
        return Collections.unmodifiableList(objects);
    }

    private static Set<String> createImmutableSet(String... a) {
        HashSet<String> strings = new HashSet<>(Arrays.asList(a));
        return Collections.unmodifiableSet(strings);
    }

    private static void testArrayList() {
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        strings.add("6");
        System.out.println(strings);
    }

    public static void main(String[] args) {
        List<String> immutableList = createImmutableList("1asfdghjgfdsa", "2ASDFGHGHFDSA", "3hjkkjhgfd", "4qwertyytre", "5zxcv", "6mnbv");

    }

}
