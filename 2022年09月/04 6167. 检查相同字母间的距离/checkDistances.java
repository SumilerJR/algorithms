class Solution {
    public boolean checkDistances(String s, int[] distance) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int last = s.indexOf(ch, i + 1);
            if (last > 0 && last - i - 1 != distance[ch - 'a'])
                return false;
        }
        return true;
    }
}