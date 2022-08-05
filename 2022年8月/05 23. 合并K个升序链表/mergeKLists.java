//执行用时：4 ms, 在所有 Java 提交中击败了70.32%的用户
//内存消耗：43.6 MB, 在所有 Java 提交中击败了22.16%的用户
// - 最小堆：k路合并
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int size = lists.length;
        if (size < 2)
            return size == 1 ? lists[0] : null;
        for (int i = 0; i < size; i++) {
            if (lists[i] != null)
                pq.offer(lists[i]);
        }
        if (pq.size() == 0)
            return null;
        ListNode root = pq.poll();
        ListNode cur = root;
        if (cur.next != null)
            pq.offer(cur.next);
        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
            if (cur.next != null)
                pq.offer(cur.next);
        }
        return root;
    }
}