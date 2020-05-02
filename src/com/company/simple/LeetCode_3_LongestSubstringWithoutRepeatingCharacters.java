package com.company.simple;

import java.util.HashMap;
import java.util.Map;

class LeetCode_3_Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;
        int ans = 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (hashMap.containsKey(c)) {
                start = Math.max(start, hashMap.get(c));
            }
            ans = Math.max(ans, end - start + 1);
            hashMap.put(c, end + 1);
        }
        return ans;
    }
}

public class LeetCode_3_LongestSubstringWithoutRepeatingCharacters {

}
