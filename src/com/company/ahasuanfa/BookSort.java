package com.company.ahasuanfa;

import java.awt.print.Book;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 桶排序
 * @Date: Create in 16:19 2019/1/1
 */
public class BookSort {

    public static void main(String[] args) {
//        BookSortObject bookSortObject = new BookSortObject(new int[]{1, 3, 2, 6, 2});
//        bookSortObject.asc();
//        bookSortObject.desc();

        String content = "（5个   qwqe    qw红包+1个封套）*2+883积分";
        String regex = "[0-9][0-9][0-9]积分";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);
        int length = m.replaceAll("").trim().length();
        System.out.println(content.substring(length, length+3));
    }

}

class BookSortObject {

    private int[] book;

    public BookSortObject() { }

    public BookSortObject(int[] book) {
        this.book = book;
    }

    public int[] getBook() {
        return book;
    }

    public void setBook(int[] book) {
        this.book = book;
    }

    private int getTheMax() {
        int max = book[0];
        for (int num : book) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private int[] sort() {
        int[] visit = new int[getTheMax() + 1];
        initArray(visit);
        for (int num : book) {
            visit[num] ++;
        }
        return visit;
    }

    /**
     * @date 2019/1/1 16:30
     * asc 升序输出
     * @return null
     * @description
     * @throws
    */
    public void asc() {
        int[] nums = sort();
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] > 0) {
                for (int j = 0; j < nums[i]; j++) {
                    System.out.print(String.format("%s ", i));
                }
            }
        }
        System.out.println();
    }

    /**
     * @date 2019/1/1 16:31
     desc 降序输出
     * @return null
     * @description
     * @throws
    */
    public void desc() {
        int[] nums = sort();
        for (int i = nums.length-1; i>=0; i--) {
            if (nums[i] > 0) {
                for (int j = 0; j < nums[i]; j++) {
                    System.out.print(String.format("%s ", i));
                }
            }
        }
        System.out.println();
    }

    private void initArray(int[] visit) {
        for (int i = 0; i < visit.length; i++) {
            visit[i] = 0;
        }
    }

}
