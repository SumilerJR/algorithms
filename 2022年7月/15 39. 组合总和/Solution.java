//执行用时：3 ms, 在所有 Java 提交中击败了54.53%的用户
//内存消耗：41.5 MB, 在所有 Java 提交中击败了84.62%的用户
// -  回溯
class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    int target;//参数太多了，来个全局变量吧
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Deque<Integer> deque = new ArrayDeque<>();
        this.target = target;
        combinationSum(candidates, deque, 0, 0);
        return lists;
    }

    public void combinationSum(int[] candidates, Deque<Integer> deque, int index, int sum) {
        if (sum == target)//相等时添加到结果集
            lists.add(new ArrayList<>(deque));
        else if (sum > target)
            return;//当前方案无法构成目标和，返回
        else {
            for (int i = index; i < candidates.length; i++) {
                sum += candidates[i];//加上当前元素值
                deque.offerLast(candidates[i]);//添加当前元素
                combinationSum(candidates, deque, i, sum);//递归
                sum -= candidates[i];//回溯，减回去
                deque.pollLast();//回溯，删掉当前元素
            }
        }
    }
}
