class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        backtracking(0, list, chars);
        return list;
    }
    public void backtracking(int start, List<String> list, char[] chars) {
        if (start == chars.length) {
            list.add(String.valueOf(chars));
            return;//一轮完成添加到结果集
        }
        backtracking(start + 1, list, chars);//自身先递归
        if (Character.isDigit(chars[start]))
            return;//为数字不用大小写转换
        //大小写转换
        char ch = chars[start];
        chars[start] = Character.isLowerCase(ch) ? Character.toUpperCase(ch) : Character.toLowerCase(ch);
        backtracking(start + 1, list, chars);
        ch = chars[start];
        chars[start] = Character.isLowerCase(ch) ? Character.toUpperCase(ch) : Character.toLowerCase(ch);
    }
}
