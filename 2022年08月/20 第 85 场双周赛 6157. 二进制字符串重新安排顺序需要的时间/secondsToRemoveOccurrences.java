// 执行用时：643 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：42 MB, 在所有 Java 提交中击败了100.00%的用户
class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int count = 0;
        String t = new String(s.replaceAll("01", "10"));
        while (!s.equals(t)) {
            s = t;
            t = t.replaceAll("01", "10");
            count++;
        }
        return count;
    }
}