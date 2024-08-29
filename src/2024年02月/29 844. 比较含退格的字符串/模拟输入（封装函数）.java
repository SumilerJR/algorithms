class Solution {
    public boolean backspaceCompare(String s, String t) {
        return inputString(s).equals(inputString(t));
    }

    public String inputString(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] == '#') {
                i--;
            } else {
                chars[i++] = chars[j];
            }
            if (i < 0) {
                i = 0;
            }
        }
        return new String(chars).substring(0, i);
    }
}