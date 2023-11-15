/*
 * @Author: 九日 mail@sumiler.com
 * @Date: 2023-11-15 21:19:54
 * @LastEditors: 九日 mail@sumiler.com
 * @LastEditTime: 2023-11-15 21:26:08
 * @FilePath: \Algorithm\2023年11月\15 2656. K 个元素的最大和\Solution.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
// 纯模拟
class Solution {
    public int maximizeSum(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < k; i++) {
            int m = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] > nums[m]) {
                    m = j;
                }
            }
            ans += nums[m];
            nums[m] += 1;
        }
        return ans;
    }
}
