class Solution {
    public int[] numberOfPairs(int[] nums) {
        if (nums.length == 1)
            return new int[]{0, 1};
        int num1 = 0, num2 = nums.length;
        boolean[] map = new boolean[101];
        for (int i = 0; i < nums.length; i++) {
            if (map[nums[i]]) {
                num1++;
                map[nums[i]] = false;
                num2 -= 2;
            }
            else 
                map[nums[i]] = true;
        }
        return new int[]{num1, num2};
    }
}
