//1 交换律：a ^ b ^ c <=> a ^ c ^ b
//2 任何数于0异或为任何数 0 ^ n => n
//3 相同的数异或为0: n ^ n => 0
class Solution {
    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            nums[0] ^= nums[i];
        return nums[0];
    }
}
