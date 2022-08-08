//执行用时：2 ms, 在所有 Java 提交中击败了79.55%的用户
//内存消耗：39.9 MB, 在所有 Java 提交中击败了43.18%的用户
class Solution {
    public String makeLargestSpecial(String s) {
        if (s.length() == 0)
            return "";
        List<String> list = new ArrayList<>();
        int count = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            count += s.charAt(i) == '1' ? 1 : -1;
            if (count == 0) {
                list.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                left = i + 1;
            }
        }
        list.sort((a, b) -> b.compareTo(a));
        StringBuilder sb = new StringBuilder();
        for (String str : list)
            sb.append(str);
        return sb.toString();
    }
}