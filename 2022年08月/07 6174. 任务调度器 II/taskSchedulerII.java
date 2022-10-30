//执行用时：41 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：55 MB, 在所有 Java 提交中击败了100.00%的用户
class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> map = new HashMap<>();
        long count = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (!map.containsKey(tasks[i]))
                map.put(tasks[i], ++count);
            else {
                long temp = map.get(tasks[i]);
                if (count - temp > space) {
                    map.remove(tasks[i]);
                    map.put(tasks[i], ++count);
                }
                else {
                    count = temp + space + 1;//直接算出跳过需要休息的天数，别总想着模拟
//                    while (count - temp <= space)
//                        count++;
                    map.put(tasks[i], count);
                }
            }
        }
        return count;
    }
}