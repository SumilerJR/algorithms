class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] s_chars = s.toCharArray(), t_chars = t.toCharArray();
        int s_len = s_chars.length, t_len = t_chars.length;
        int s_count = 0, t_count = 0;
        for (int i = 0; i < s_len; i++) {
            if (s_chars[i] == '#') {
                s_count--;
            } else {
                s_chars[s_count++] = s_chars[i];
            }
            if (s_count < 0) {
                s_count = 0;
            }
        }
        for (int i = 0; i < t_len; i++) {
            if (t_chars[i] == '#') {
                t_count--;
            } else {
                t_chars[t_count++] = t_chars[i];
            }
            if (t_count < 0) {
                t_count = 0;
            }
        }
        if (s_count != t_count)
            return false;
        for (int i = 0; i < s_count; i++) {
            if (s_chars[i] != t_chars[i])
                return false;
        }
        return true;
    }
}