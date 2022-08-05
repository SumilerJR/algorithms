//33. 搜索旋转排序数组
//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：41 MB, 在所有 Java 提交中击败了47.54%的用户
class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 1)
            return nums[0] == target ? 0 : -1;//只有一个元素时直接判断
        int k = 1;
        while (k < length && nums[k - 1] < nums[k])
            k++;//找到分界点k
        int left = 0, right = k - 1;//分界点左边数组进行二分
        while (left <= right) {//这里要用<=左闭右闭的形式
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                return mid;
        }
        left = k;
        right = length - 1;//分界点右边数组进行二分
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
