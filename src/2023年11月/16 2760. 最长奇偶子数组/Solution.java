/*
 * @Author: 九日 mail@sumiler.com
 * @Date: 2023-11-16 14:23:27
 * @LastEditors: 九日 mail@sumiler.com
 * @LastEditTime: 2023-11-16 14:36:31
 * @FilePath: \Algorithm\2023年11月\16 2760. 最长奇偶子数组\Solution.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int l = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                l = i;
                while (i < nums.length - 1 && nums[i] % 2 != nums[i + 1] % 2 && nums[i + 1] <= threshold) {
                    i++;
                }
                ans = Math.max(ans, i - l + 1);
            }
        }
        return ans;
    }
}
