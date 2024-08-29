//执行用时：4 ms, 在所有 Java 提交中击败了67.28%的用户
//内存消耗：51.6 MB, 在所有 Java 提交中击败了25.56%的用户
// - 双指针
class Solution {
    public int maxArea(int[] height) {
        int length = height.length;
        int left = 0, right = length - 1;
        int maxArea = right * Math.min(height[left], height[right]);
        while (left < right) {
            if (height[left] < height[right])
                left++;
            else
                right--;
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
        }
        return maxArea;
    }
}
