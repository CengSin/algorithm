package com.company.simple;

import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Stack;

/**
 * 简化路径
 */

class LeetCode_71_Solution {

    public String simplifyPathNormal(String path) {
        if (path != null) {
            try {
                return Paths.get(path).normalize().toString().replace("\\", "/");
            } catch (Exception e) {
                return "/";
            }
        }
        return null;
    }

    public String simplifyPath(String path) {
        if (path != null) {
            Stack<String> stack = new Stack<>();
            String[] split = path.split("/");
            for (String s : split) {
                if (!"".equals(s) && !".".equals(s)) {
                    if ("..".equals(s)) {
                        if (!stack.isEmpty()) stack.pop();
                    } else {
                        stack.push(s);
                    }
                }
            }

            StringBuilder sb = new StringBuilder("/");
            Iterator<String> iterator = stack.iterator();
            while (iterator.hasNext()) {
                sb.append(iterator.next()).append("/");
            }
            String res = sb.toString();
            return res.length() > 1 ? res.substring(0, res.length() - 1) : res;
        }
        return null;
    }

}

public class LeetCode_71_SimplifyPath {

    public static void main(String[] args) {
        LeetCode_71_Solution solution = new LeetCode_71_Solution();
        System.out.println(solution.simplifyPath("/home/"));
        System.out.println(solution.simplifyPath("/../"));
        System.out.println(solution.simplifyPath("/home//foo/"));
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));
        System.out.println(solution.simplifyPath("/a/../../b/../c//.//"));
        System.out.println(solution.simplifyPath("/a//b////c/d//././/.."));
    }

}
