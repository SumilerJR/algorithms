//执行用时：1 ms, 在所有 Java 提交中击败了99.77%的用户
//内存消耗：41.9 MB, 在所有 Java 提交中击败了75.54%的用户
class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new ArrayList<>();
        boolean[] flag = new boolean[8];
        Arrays.sort(nums);//排序，方便后面通过循环跳过重复元素
        permuteUnique(nums, flag, list);
        return lists;
    }
    public void permuteUnique(int[] nums, boolean[] flag, List<Integer> list) {
        if (list.size() == nums.length)
            lists.add(new ArrayList<>(list));//已全排列，则添加
        else {
            for (int i = 0; i < nums.length; i++) {
                if (flag[i])
                    continue;//当前位置元素已在排列中
                flag[i] = true;//标记为已排列
                list.add(nums[i]);//添加当前元素
                permuteUnique(nums, flag, list);//递归
                flag[i] = false;//撤销标记
                list.remove(list.size() - 1);//删除当前元素
                while (i < nums.length - 1 && nums[i] == nums[i + 1])
                    i++;//利用循环跳过重复元素
            }
        }
    }
}
