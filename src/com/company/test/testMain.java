package com.company.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Date: Create in 16:59 2019/1/8
 */
public class testMain {

    public static void main(String[] args) {

        int limit = 3;
        ArrayList<Integer> gradeProducts = new ArrayList<>();
        gradeProducts.add(1);
        gradeProducts.add(2);
        gradeProducts.add(3);
        gradeProducts.add(4);
        for (int i = 0; i < gradeProducts.size(); i+=limit) {
            List<Integer> newLists = null;
            if (i+limit > gradeProducts.size()) {
                newLists = gradeProducts.subList(i, gradeProducts.size());
            } else {
                newLists = gradeProducts.subList(i, limit);
            }
            System.out.println(newLists.toString());
        }

    }

}
