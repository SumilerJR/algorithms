//执行用时：3 ms, 在所有 Java 提交中击败了95.63%的用户
//内存消耗：40.5 MB, 在所有 Java 提交中击败了54.61%的用户
class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    list.add(words[i]);
                    break;
                }
            }
        }
        return list;
    }
}
