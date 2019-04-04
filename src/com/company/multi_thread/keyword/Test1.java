package com.company.multi_thread.keyword;

import com.company.generic_class.Test.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Date: Create in 18:56 2019/3/26
 */
public interface Test1 extends Test2, Test3 {

    default void test(int a, int b){
        System.out.println("123123 = " +  (a+b));
        System.out.println("123123 = " +  a + b);

    }


}
