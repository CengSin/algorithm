package com.company.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */

class LeetCode_22_Solution {

    /**
     * 回朔优化
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        generateLookBack(new StringBuilder(), 0, 0, n, res);
        return res;
    }

    private void generateLookBack(StringBuilder current, int open, int close, int n, ArrayList<String> res) {

        if (current.length() == 2 * n) {
            res.add(new String(current));
        } else {
            if (open < n) {
                current.append('(');
                generateLookBack(current, open + 1, close, n, res);
                current.deleteCharAt(current.length() - 1); // 删掉最后一个字符
            }
            if (close < open) {
                current.append(')');
                generateLookBack(current, open, close + 1, n, res);
                current.deleteCharAt(current.length() - 1); // 删掉最后一个字符
            }
        }

    }

    /**
     * 暴力，首先n对括号的所有排列，之后判断那些有效哪些无效
     * @param n
     * @return
     */
    public List<String> generateParenthesisForce(int n) {
        char[] current = new char[2*n];
        ArrayList<String> res = new ArrayList<>();
        generate(current, 0, res);
        return res;
    }

    private void generate(char[] current, int pos, List<String> res) {
        if (pos == current.length) {  // current数组中共有6个括号，
            if (valid(current)) {   // 如果有效，则添加到结果数组中
                res.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generate(current, pos + 1, res);
            current[pos] = ')';
            generate(current, pos + 1, res);
        }
    }

    private boolean valid(char[] current) {
        int cnt = 0;
        for (int i = 0; i < current.length; i++) {
            if (current[i] == '(') {
                cnt ++;
            } else {
                cnt --;
            }
            if (cnt < 0) {
                return false;
            }
        }
        return cnt == 0;
    }

}

public class LeetCode_22_GenerateParentheses {

    public static void main(String[] args) {
        LeetCode_22_Solution solution = new LeetCode_22_Solution();
        System.out.println(solution.generateParenthesis(2));
    }

}
