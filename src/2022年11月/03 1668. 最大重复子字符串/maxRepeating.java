class Solution {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        String s = word;//一开始没看到是“连续”字符串
        int index = sequence.indexOf(s);
        while (index != -1) {
            count++;
            s += word;
            index = sequence.indexOf(s);
        }
        return count;
    }
}