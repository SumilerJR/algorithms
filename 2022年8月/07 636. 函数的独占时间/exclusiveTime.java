// 执行用时：11 ms, 在所有 Java 提交中击败了58.68%的用户
// 内存消耗：42 MB, 在所有 Java 提交中击败了52.26%的用户
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[n];
        for (String log : logs) {
            String[] temp = log.split(":");
            int i = Integer.parseInt(temp[0]);
            int time = Integer.parseInt(temp[2]);
            if ("start".equals(temp[1])) {
                stack.push(new int[]{i, time});
            }
            else {//end
                int[] pop = stack.pop();
                int interval = time - pop[1] + 1;
                result[pop[0]] += interval;
                if (!stack.isEmpty())
                    result[stack.peek()[0]] -= interval;
            }
        }
        return result;
    }
}