//执行用时：1 ms, 在所有 Java 提交中击败了75.84%的用户
//内存消耗：41.2 MB, 在所有 Java 提交中击败了86.12%的用户
//  - 回溯
class Solution {
    List<String> list = new ArrayList<>();
    int n;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        generateParenthesis(0, 0, new String());
        return list;
    }

    public void generateParenthesis(int left, int right, String s) {
        if (left == n && right == n)
            list.add(s);//左右括号都已有n个
        else {
            if (left < n)//左括号不满n个，尝试添加左括号
                generateParenthesis(left + 1, right, s + "(");
            if (right < n && left > right)//右括号不满n个，且为了满足有效括号，必须左括号数大于右括号数时才可添加右括号
                generateParenthesis(left, right + 1, s + ")");
        }
    }
}
