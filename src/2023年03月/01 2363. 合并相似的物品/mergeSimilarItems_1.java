// Sumiler 22:27:49
// 很久没刷力扣

// Sumiler 22:27:52
// 今天做一道每日一题

// Sumiler 22:27:55
// 提交了才发现

// Sumiler 22:27:56
// 以前做过

// Sumiler 22:28:02
// 看看代码  一点都没变。。。

// Sumiler 22:28:10
// 感觉毫无进步
class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> ret = new ArrayList<>();
        int[] map = new int[10002];
        for (int[] item : items1) {
            map[item[0]] += item[1];
        }
        for (int[] item : items2) {
            map[item[0]] += item[1];
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(map[i]);
                ret.add(list);
            }
        }
        return ret;
    }
}