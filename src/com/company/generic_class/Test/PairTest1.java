package com.company.generic_class.Test;

import com.company.generic_class.Pair;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Date: Create in 15:43 2019/1/20
 */
public class PairTest1 {

    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> pair = ArrayAlg.minmax(words);
        System.out.println("min = " + pair.getFirst());
        System.out.println("max = " + pair.getSecond());

        String middle = ArrayAlg.getMiddle("John", "Q.", "public");
        System.out.println(middle);

        /**
         * 当不同类型的参数传入只有一个泛型的方法时，
         *
         */
        Double number = ArrayAlg.getMiddle(3.1415926, 12345.0, 0.0);
        System.out.println(number);
    }

}

class ArrayAlg {
    /**
     * Get the minimnum and maximum of an array of String
     * @param words an array of String
     * @return a pair with the min and max value, or null if words is null or empty
     */
    public static Pair<String> minmax(String[] words) {
        if (words == null || words.length == 0) return null;
        String min = words[0];
        String max = words[0];
        for (int i = 1; i < words.length; i++) {
            if (min.compareToIgnoreCase(words[i]) > 0) min = words[i];
            if (max.compareToIgnoreCase(words[i]) < 0) max = words[i];
        }
        return new Pair<>(min, max);
    }

    /**
     * 普通类型中的泛型方法
     * @param a
     * @param <T>
     * @return
     */
    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

    /**
     * 对泛型进行限制 固定<T extends bounding Type> 表示T是绑定类型的子类型， T和bounding可以是类，也可以是接口，选择extends关键字是因为这样更接近子类的概念
     * 限定T为多个类型<T extends Comparable & Serializable>
     * & 分隔多个泛型限制类型
     * ， 分割多个泛型
     * @param a
     * @param <T>
     * @return
     */
    public static <T extends Comparable> T min(T[] a) {
        if (a == null || a.length == 0) return null;
        T smallest = a[0];
        for (int i = 1; i < a.length; i++) {
            if (smallest.compareTo(a[i]) > 0) {
                smallest = a[i];
            }
        }
        return smallest;
    }
}
