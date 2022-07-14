//执行用时：1 ms, 在所有 Java 提交中击败了99.69%的用户
//内存消耗：41.4 MB, 在所有 Java 提交中击败了75.41%的用户
// - 回溯
//比昨天那题多了个去重的操作
class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);//先排序，方便后面通过循环跳过重复元素
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
            while (i < nums.length - 1 && nums[i] == nums[i + 1])
                i++;//跳过重复元素
        }
    }
}
