class Solution {
    public int edgeScore(int[] edges) {
        long[] map = new long[edges.length];
        for (int i = 0; i < edges.length; i++) {
            map[edges[i]] += i;
        }
        long max = map[0];
        int node = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] > max) {
                max = map[i];
                node = i;
            }
        }
        return node;
    }
}