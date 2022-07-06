//执行用时：19 ms, 在所有 Java 提交中击败了91.10%的用户
//内存消耗：44.8 MB, 在所有 Java 提交中击败了97.80%的用户
 - 双指针
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int length = nums.length;
        if (length < 3)
            return lists;//不长于3的直接返回
        Arrays.sort(nums);//排序
        if (nums[0] > 0 || nums[length - 1] < 0)
            return lists;//最小的大于0或最大的小于0不可能组成三数之和为0的结果
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] > 0)
                break;//第一个数大于0时后面全大于0，不可能再组成0
            if (i > 0 && nums[i] == nums[i - 1])
                continue;//跳过重复的值
            int left = i + 1, right = length - 1;//左臂和右臂
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];//求和
                if (sum > 0)
                    right--;//太大时右臂减小
                else if (sum < 0)
                    left++;//太小时左臂增大
                else {
                    lists.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    while(left < right && nums[left++] == nums[left]);//跳过重复的值
                    while (left < right && nums[right--] == nums[right]);
                }
            }
        }
        return lists;
    }
}


//  - 2022/03/27 之前写的
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {// 总时间复杂度：O(n^2)
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) return ans;
 
        Arrays.sort(nums); // O(nlogn)
 
        for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
            if (nums[i] > 0) break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    
                    // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = -2, left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    left++; right--; // 首先无论如何先要进行加减操作
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {  // nums[left] + nums[right] > target
                    right--;
                }
            }
        }
        return ans;
    }
}
