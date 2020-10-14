package start;

import java.util.*;

class LeetCode_1002_FindCommonChars_Solution {

    public List<String> commonChars(String[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        if (A.length == 1) {
            List<String> result = new ArrayList<>();
            result.add(A[0]);
            return result;
        }

        Map<String, Integer> visitSign = hashString(A[0]);

        List<String> result = new ArrayList<>();

        for (String s : A) {
            Map<String, Integer> tmpMap = hashString(s);
            Iterator<Map.Entry<String, Integer>> iterator = visitSign.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Integer> next = iterator.next();
                if (!tmpMap.containsKey(next.getKey())) {
                    iterator.remove();
                } else {
                    next.setValue(Math.min(next.getValue(), tmpMap.get(next.getKey())));
                }
            }
        }

        Set<String> keys = visitSign.keySet();
        for (String key : keys) {
            Integer loopCnt = visitSign.get(key);
            for (int i = 0; i < loopCnt; i++) {
                result.add(key);
            }
        }

        return result;
    }

    private Map<String, Integer> hashString(String s) {
        HashMap<String, Integer> visit = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            visit.put(s.charAt(i) + "", visit.getOrDefault(s.charAt(i) + "", 0) + 1);
        }
        return visit;
    }

}

public class LeetCode_1002_FindCommonChars {
    public static void main(String[] args) {
        List<String> result = new LeetCode_1002_FindCommonChars_Solution().commonChars(new String[]{"bella", "label", "roller"});
        System.out.println(result);
    }
}
