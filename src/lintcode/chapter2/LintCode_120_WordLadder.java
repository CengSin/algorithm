package lintcode.chapter2;

import java.util.*;

/**
 * 单词接龙
 */
class LintCode_120_Solution {

    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        Set<String> sets = new HashSet<>();
        sets.add(start);

        dict.add(end);

        if (start.equals(end)) return 1;

        int distance = 0;

        while (!queue.isEmpty()) {
            distance ++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(end)) {
                    return distance;
                }

                List<String> words = getNextWord(word);
                for (String w : words) {
                    if (sets.contains(w) || !dict.contains(w)) continue;
                    queue.offer(w);
                    sets.add(w);
                }
            }
        }
        return distance;
    }

    private List<String> getNextWord(String word) {
        List<String> words = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (int j = 'a'; j <= 'z'; j++) {
                if (j == word.charAt(i)) continue;
                words.add(replace(word, i, j));
            }
        }
        return words;
    }

    private String replace(String word, int i, int j) {
        char[] chars = word.toCharArray();
        chars[i] = (char)j;
        return new String(chars);
    }

}

public class LintCode_120_WordLadder {
}
