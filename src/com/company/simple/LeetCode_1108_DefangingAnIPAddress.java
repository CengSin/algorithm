package com.company.simple;

/**
 * @description: IP 地址无效化
 * @author: 15262
 * @date: 2020/3/26
 */

class LeetCode_1108_Solution {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}

public class LeetCode_1108_DefangingAnIPAddress {

    public static void main(String[] args) {
        LeetCode_1108_Solution solution = new LeetCode_1108_Solution();
        System.out.println(solution.defangIPaddr("1.1.1.1"));
    }

}
