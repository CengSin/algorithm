package com.company.arithmetic;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Date: Create in 22:55 2019/1/24
 */

class SelectDto {

    private String label;
    private Object value;

    public SelectDto() {
    }

    public SelectDto(String label, Object value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SelectDto{" +
                "label='" + label + '\'' +
                ", value=" + value +
                '}';
    }
}

public class GreatestCommonDivisor {
    /**
     * @return gcd Number
     * @throws
     * @date 2019/1/24 22:57
     * @description get Greatest common divisor of p and q
     * q != 0
     */
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
//        System.out.println(GreatestCommonDivisor.gcd(1, 2));
//        System.out.println(GreatestCommonDivisor.gcd(0, 15));
//        System.out.println(GreatestCommonDivisor.gcd(15, 0));
//        System.out.println(GreatestCommonDivisor.gcd(15, 6));
//        System.out.println(GreatestCommonDivisor.gcd(6, 15));
//        System.out.println("undefined".compareToIgnoreCase("100001"));
//        System.out.println("100001".compareToIgnoreCase("undefined"));
//        System.out.println(Integer.parseInt("undefined"));
//        System.out.println(Integer.parseInt("1aweaw2"));
//        System.out.println("100001".compareToIgnoreCase("100154"));

//        GreatestCommonDivisor.get(47);
//
//        System.out.println(String.format("%s", Optional.ofNullable(null).orElse("")));

//        try {
//            int i = 1/0;
//        } catch (Exception e) {
//            System.out.println(1111111111);
//        }
//
//        try {
//            int i = 1 / 1;
//        } catch (Exception e) {
//            System.out.println(222222222);
//        }
//        System.out.println(test());

        SelectDto selectDto = new SelectDto("123", 1);
        System.out.println(selectDto);

        Integer i = null;

        System.out.println((int)i);

    }

    public static int test() {
        try {
            throw new RuntimeException("哈哈哈");
        } catch (RuntimeException re) {
            throw re;
        } catch (Exception e) {
            System.out.println("Exception进来啦");
        } finally {
            System.out.println("走finally");
        }
        return 0;
    }

    public static void get(int num) {

        int end = 9999;

        for (int i = 1; i*80+num < end; i++) {
            System.out.printf("%04d\n", i * 80 + num);
        }


    }

}