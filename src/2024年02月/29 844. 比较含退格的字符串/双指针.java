class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] s_chars = s.toCharArray(), t_chars = t.toCharArray();
        int s_len = s_chars.length, t_len = t_chars.length;
        int i = s_len - 1, j = t_len - 1;
        int s_count = 0, t_count = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s_chars[i] == '#') {
                    s_count++;
                } else if (s_count > 0) {
                    s_count--;
                } else {
                    break;
                }
                i--;
            }
            while (j >= 0) {
                if (t_chars[j] == '#') {
                    t_count++;
                } else if (t_count > 0) {
                    t_count--;
                } else {
                    break;
                }
                j--;
            }
            if (i >= 0 && j >= 0) {
                if (s_chars[i] != t_chars[j]) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

}