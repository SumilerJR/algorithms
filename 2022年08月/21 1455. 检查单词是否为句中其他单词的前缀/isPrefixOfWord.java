//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：39.5 MB, 在所有 Java 提交中击败了13.79%的用户
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        if (sentence.indexOf(sentence) == -1)
            return -1;
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].indexOf(searchWord) == 0)
                return i + 1;
        }
        return -1;
    }
}