//执行用时：4 ms, 在所有 Java 提交中击败了42.14%的用户
//内存消耗：41.2 MB, 在所有 Java 提交中击败了99.21%的用户
//  - 回溯
class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2(candidates, target, new ArrayList<>(), 0);
        return lists;
    }

    public void combinationSum2(int[] can, int target, List<Integer> list, int index) {
        if (target == 0)
            lists.add(new ArrayList<>(list));
        else if (target < 0)
            return;
        else {
            for (int i = index; i < can.length; i++) {
                list.add(can[i]);
                combinationSum2(can, target - can[i], list, i + 1);
                list.remove(list.size() - 1);
                while (i < can.length - 1 && can[i] == can[i + 1])
                    i++;
            }
        }
    }
}
