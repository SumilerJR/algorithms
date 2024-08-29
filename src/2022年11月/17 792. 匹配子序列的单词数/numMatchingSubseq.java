//暴力竟然过了。。
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            if (isSum(s, words[i])) {
                ans++;
            }
        }
        return ans;
    }

    public boolean isSum(String s, String word) {
        int index1 = s.indexOf(word.charAt(0));
        System.out.println(index1);
        if (index1 == -1) {
            return false;
        }
        for (int i = 1; i < word.length(); i++) {
            int index2 = s.indexOf(word.charAt(i), index1 + 1);
            if (index2 == -1) {
                return false;
            } else {
                index1 = index2;
            }
        }
        return true;
    }
}