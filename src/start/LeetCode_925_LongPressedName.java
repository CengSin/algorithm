package start;

class LeetCode_925_LongPressedName_Solution {

    /**
     * typed中的每个字符都只有两种情况
     * - 与name中对应的字母相同，此时i++;j++;
     * - 如果与name中的字符不相同，且与之前的type字符相同，说明重复输入了，此时j++
     * - 否则说明了typed中单独存在的字符，所以直接返回false
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }

}

public class LeetCode_925_LongPressedName {
}
