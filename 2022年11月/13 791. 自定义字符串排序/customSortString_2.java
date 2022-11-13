class Solution {
    public String customSortString(String order, String s) {
        int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        Arrays.sort(chars, (a, b) -> {
            return map[a - 'a'] - map[b - 'a'];
        });
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++ ){
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}