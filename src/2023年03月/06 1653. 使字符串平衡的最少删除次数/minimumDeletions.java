class Solution {
    public int minimumDeletions(String s) {
        char[] chars = s.toCharArray();
        int del = 0;
        for (char ch : chars) {
            del += 'b' - ch;//统计a的个数
        }
        int ans = del;
        for (char ch : chars) {
            if (ch == 'a') del--;//若为a，则减少删减次数
            else del++;//若为b则增加删减次数
            ans = Math.min(ans, del);//取最小值
        }
        return ans;
    }
}