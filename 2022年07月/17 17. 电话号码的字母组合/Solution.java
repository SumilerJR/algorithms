//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：40.3 MB, 在所有 Java 提交中击败了20.17%的用户
//  - 回溯
class Solution {
    String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0)
            return list;
        else
            letterCombinations(list, digits, new StringBuilder(), 0);
        return list;
    }

    public void letterCombinations(List<String> list, String digits, StringBuilder sb, int index) {
        if (sb.length() == digits.length())
            list.add(new String(sb));
        else {
            for (int i = index; i < digits.length(); i++) {
                int num = digits.charAt(i) - '2';
                for (int j = 0; j < map[num].length(); j++) {
                    sb.append(map[num].charAt(j));
                    letterCombinations(list, digits, sb, i + 1);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}
