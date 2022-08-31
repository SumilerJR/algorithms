//执行用时：4 ms, 在所有 Java 提交中击败了16.24%的用户
//内存消耗：41 MB, 在所有 Java 提交中击败了72.50%的用户
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int k = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && popped[k] == stack.peek()) {
                stack.pop();
                k++;
            }
        }
        return k == pushed.length;
    }
}