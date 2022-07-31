// 执行用时：9 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：57.5 MB, 在所有 Java 提交中击败了100.00%的用户
class Solution {
    int[] edges;
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        this.edges = edges;
        int length = edges.length;
        int[] dis1 = new int[length], dis2 = new int[length];
        getDistance(dis1, node1);
        getDistance(dis2, node2);
        int node = -1, dis = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (dis1[i] != -1 && dis2[i] != -1) {
                //看了很久都没看懂的题意：使节点 node1 和节点 node2 到这个节点的距离 较大值最小化
                //也就是说要有一个节点到两个节点的距离中取一个大的，然后使这个距离取得最小……
                int temp = Math.max(dis1[i], dis2[i]);//较大值
                if (temp < dis) {//最小化
                    dis = temp;
                    node = i;
                }
            }
        }
        return node;
    }

    /**
     * 获取从index节点到其他节点的距离
     * @param dis
     * @param index
     */
    public void getDistance(int[] dis, int index) {
        Arrays.fill(dis, -1);
        for (int i = 0; i < dis.length && index != -1 && dis[index] == -1; i++) {
            dis[index] = i;
            index = edges[index];
        }
    }
}
