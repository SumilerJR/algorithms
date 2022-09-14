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
 * 执行用时：64 ms, 在所有 JavaScript 提交中击败了67.80%的用户
 * 内存消耗：42.9 MB, 在所有 JavaScript 提交中击败了51.68%的用户
 */
var reverseList = function (head) {
    let pre = null, cur = head;
    while (cur !== null) {
        let temp = cur.next;
        cur.next = pre;
        pre = cur;
        cur = temp;
    }
    return pre;
};
//执行用时：56 ms,在所有JavaScript提交中击败了;95.45%的用户;
//内存消耗：42.9 MB,在所有JavaScript提交中击败了;57.71 %的用户;
var reverseList = function (head) {
    let pre = null, next = null;
    while (head !== null) {
        next = head.next;
        head.next = pre;
        pre = head;
        head = next;
    }
    return pre;
};