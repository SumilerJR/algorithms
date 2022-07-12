//执行用时：4 ms, 在所有 Java 提交中击败了99.97%的用户
//内存消耗：47.9 MB, 在所有 Java 提交中击败了55.60%的用户
// - 滑动窗口
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int length = nums.length;
        int count = 0;
        int left = 0, right = 0, s = 1;
        while (right < length) {
            s *= nums[right];
            while (s >= k && left <= right) {//左闭右闭
                s /= nums[left++];
            }
            count += right - left + 1;//需要+1
            right++;//最后自增
        }
        return count;
    }
}
// 注意两个写法的细微差异，深入理解滑动窗口的动态过程
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int length = nums.length;
        int count = 0;
        int left = 0, right = 0, s = 1;
        while (right < length) {
            s *= nums[right++];//直接自增
            while (s >= k && left < right) {//左闭右开
                s /= nums[left++];
            }
            count += right - left;//不需要+1
        }
        return count;
    }
}
