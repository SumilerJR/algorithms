class Solution {
    public String customSortString(String order, String s) {
        boolean[] map = new boolean[26];
        int[] count = new int[26];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < order.length(); i++) {
            int index = order.charAt(i) - 'a';
            map[index] = true;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map[ch - 'a']) {
                count[ch - 'a']++;
            } else {
                sb.append(ch);
            }
        }
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            if (count[ch - 'a'] > 0) {
                for (int j = 0; j < count[ch - 'a']; j++) {
                    sb.append(String.valueOf(ch));
                }
            }
        }
        return sb.toString();
    }
}