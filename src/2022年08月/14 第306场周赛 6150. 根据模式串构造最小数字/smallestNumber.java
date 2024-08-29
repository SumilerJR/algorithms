//执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：39.7 MB, 在所有 Java 提交中击败了100.00%的用户
// 栈
class Solution {
    public String smallestNumber(String pattern) {
        pattern += "I";
        StringBuilder res = new StringBuilder();
        int len = pattern.length();
        Deque<Integer> que = new LinkedList<>();
        for(int i = 1; i <= len; i++){
            if(pattern.charAt(i - 1) == 'D'){
                que.offerLast(i);
            }else{
                res.append(i);
                while(que.size() != 0){
                    res.append(que.pollLast());
                }
            }
        }
        return res.toString();
    }
}
