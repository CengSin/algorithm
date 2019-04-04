package com.company.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 报数 1 11 21 1211 111221 312211 .....每个数字都等于前一个数字的文字描述，比如n2 = 1个1 n3 = 2个1 n4 = 1个2，1个1[1211]
 * @Date: Create in 20:44 2018/12/19
 */
public class LeetCode_36_CountAndSay {

    public static void main(String[] args) {

//        Solution_36 sol = new Solution_36();
//        System.out.println(sol.countAndSay(5));
//        System.out.println(sol.countAndSay(6));
//        System.out.println(sol.countAndSay(7));
//        System.out.println(sol.countAndSay(8));
//        System.out.println(sol.countAndSay(9));
//        System.out.println(sol.countAndSay(10));

        test t = new test();
        t.setIsPost(true);
        System.out.println(t);
    }

}

class test {

    private int isPost;

    public void setIsPost(boolean post) {
        this.isPost = post?1:0;
    }

}

class Solution_36 {

    public String countAndSay(int n) {
        List<String> list = new ArrayList<>();
        list.add("1");
        for (int i = 1; i < n; i++) {
            list.add(solve_36(list.get(i-1)));
        }
        return list.get(list.size()-1);
    }

    /**
     * 通过对第一个数字和之后相同数字计数，相同+1，不同则将count 和 数字组成一个字符，遍历下一个数字
     * @param s
     * @return
     */
    private String solve_36(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i =0 ; i < s.length(); i+=count) {
            char tmp = s.charAt(i);
            count = 1;
            int j = 0;
            for (j = i+1; j<s.length(); j++) {
                if (tmp == s.charAt(j)) {
                    count++;
                } else {
                    break;
                }
            }
            sb.append(count).append(tmp);
            if (j == s.length()) break;
        }
        return sb.toString();
    }

}