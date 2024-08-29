// 0 ms	40.8 MB
class Solution {
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        if (length == 1)
            return 0;
        int left = 0, right = length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1])//有上坡必有顶点
                left = mid + 1;//上坡路上能看到前面还是上坡，继续走
            else
                right = mid;//下坡了，先停住观望一下
        }
        return left;
    }
}
