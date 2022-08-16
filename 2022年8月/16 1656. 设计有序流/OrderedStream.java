//执行用时：72 ms, 在所有 Java 提交中击败了69.88%的用户
//内存消耗：42.9 MB, 在所有 Java 提交中击败了26.51%的用户
class OrderedStream {
    String[] map;
    int ptr;
    public OrderedStream(int n) {
        this.map = new String[n + 1];
        this.ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        List<String> list = new ArrayList<>();
        if (map[idKey] == null) {
            map[idKey] = value;
        }
        while (ptr < map.length && map[ptr] != null) {
            list.add(map[ptr++]);
        }
        return list;
    }
}