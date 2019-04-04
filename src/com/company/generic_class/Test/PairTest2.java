package com.company.generic_class.Test;

import com.company.generic_class.Pair;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Date: Create in 16:32 2019/1/20
 */
public class PairTest2 {

    public static void main(String[] args) {
        LocalDate[] birthdays = {
          LocalDate.of(1906,12, 9),
          LocalDate.of(1815,12, 9),
          LocalDate.of(1923,12, 9)
        };
        Pair<LocalDate> mm = ArrayAlg2.minmax(birthdays);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }

}

class ArrayAlg2 {

    /**
     * get the min and max of an array of objects of type Y
     * @param a a an array of objects of type t
     * @param <T>
     * @return a pair with the min and max value, or null if a is null or empty
     */
    public static <T extends Comparable> Pair<T> minmax(T[] a) {
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (T t : a) {
            if (min.compareTo(t) > 0) {
                min = t;
            }
            if (max.compareTo(t) < 0) {
                max = t;
            }
        }
        return new Pair<>(min, max);
    }

}
