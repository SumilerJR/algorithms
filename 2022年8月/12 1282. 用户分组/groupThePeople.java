//执行用时：3 ms, 在所有 Java 提交中击败了99.39%的用户
//内存消耗：41.7 MB, 在所有 Java 提交中击败了93.90%的用户
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer>[] map = new List[groupSizes.length + 1];
        for (int i = 0; i < groupSizes.length; i++) {
            int key = groupSizes[i];
            if (map[key] == null)
                map[key] = new ArrayList<>();
            map[key].add(i);
            if (map[key].size() == key) {
                lists.add(new ArrayList<>(map[key]));
                map[groupSizes[i]].clear();
            }
        }
        return lists;
    }
}

//执行用时：3 ms, 在所有 Java 提交中击败了99.39%的用户
//内存消耗：41.8 MB, 在所有 Java 提交中击败了92.99%的用户
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer>[] map = new List[groupSizes.length + 1];
        for (int i = 0; i < map.length; i++)
            map[i] = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            map[groupSizes[i]].add(i);
            if (map[groupSizes[i]].size() == groupSizes[i]) {
                lists.add(new ArrayList<>(map[groupSizes[i]]));
                map[groupSizes[i]].clear();
            }
        }
        return lists;
    }
}