//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：41.7 MB, 在所有 Java 提交中击败了26.38%的用户
// - 迭代
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = lists.size();
            for (int j = 0; j < size; j++) {
                List<Integer> temp = new ArrayList<>(lists.get(j));
                temp.add(nums[i]);
                lists.add(temp);
            }
        }
        return lists;
    }
}

//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：41.7 MB, 在所有 Java 提交中击败了14.11%的用户
// - 回溯
class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
         List<Integer> list = new ArrayList<>();
         subsets(list, nums, 0);
         return lists;
    }
    public void subsets (List<Integer> list, int[] nums, int index) {
        if (index <= nums.length)
            lists.add(new ArrayList<>(list));
        else
            return;
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            subsets(list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
