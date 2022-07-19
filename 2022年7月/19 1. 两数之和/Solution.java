class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();//创建一个哈希表，键存数，值存下标（这里不反过来是因为get方法可以返回对应数的下标）
        for(int i = 0; i < nums.length; i++){
            if(hashmap.containsKey(target - nums[i])){
                return new int[]{hashmap.get(target - nums[i]), i};//若有该数对应的差数，则直接返回这两个数的下标
            }
            hashmap.put(nums[i], i);//添加
        }
        return new int[]{0};//按题来说不会到这一步，在循环里一定有对应的数并返回
    }
}
