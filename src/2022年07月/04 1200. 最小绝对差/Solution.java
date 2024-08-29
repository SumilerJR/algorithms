//执行用时：17 ms, 在所有 Java 提交中击败了63.46%的用户
//内存消耗：50.8 MB, 在所有 Java 提交中击败了75.17%的用户
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i] - arr[i - 1]);
        }
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == min) {
                list.add(arr[i - 1]);
                list.add(arr[i]);
                lists.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return lists;
    }
}
