/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 * 执行用时：60 ms, 在所有 JavaScript 提交中击败了69.84%的用户
 * 内存消耗：41.2 MB, 在所有 JavaScript 提交中击败了67.44%的用户
 */
var swapPairs = function (head) {
    if (head === null || head.next === null)
        return head;
    let dummyHead = new ListNode();
    dummyHead.next = head;
    let cur = dummyHead;
    while (head !== null) {
        let temp = head.next;
        if (temp !== null) {
            head.next = temp.next;
            temp.next = head;
            cur.next = temp;
        }
        cur = head;
        head = head.next;
    }
    return dummyHead.next;
};