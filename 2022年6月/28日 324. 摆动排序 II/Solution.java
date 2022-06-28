//好难 还是继续做我的学习计划吧……
//数组克隆
//执行用时：3 ms, 在所有 Java 提交中击败了72.42%的用户
//内存消耗：45.4 MB, 在所有 Java 提交中击败了14.53%的用户
class Solution {
    public void wiggleSort(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int length = nums.length;
        int index = length - 1;
        for (int i = 1; i < length; i += 2) {
            nums[i] = clone[index--];
        }
        for (int i = 0; i < length; i += 2) {
            nums[i] = clone[index--];
        }
    }
}

//最小堆
//执行用时：17 ms, 在所有 Java 提交中击败了14.68%的用户
//内存消耗：43 MB, 在所有 Java 提交中击败了99.63%的用户
class Solution {
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int num : nums)
            maxHeap.add(num);
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = maxHeap.poll();
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = maxHeap.poll();
        }
    }
}
