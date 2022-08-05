/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
// 递归
/**
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 * 执行用时：72 ms, 在所有 JavaScript 提交中击败了42.23%的用户
 * 内存消耗：43.5 MB, 在所有 JavaScript 提交中击败了25.66%的用户
 */
var mergeTwoLists = function (list1, list2) {
    if (!list1)
        return list2;
    else if (!list2)
        return list1;
    if (list1.val < list2.val) {
        list1.next = mergeTwoLists(list1.next, list2);
        return list1;
    }
    else {
        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
    }
};


// 迭代
/**
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 */
var mergeTwoLists = function (list1, list2) {
    const head = new ListNode();
    let cur = head;
    while (list1 != null && list2 != null) {
        if (list1.val < list2.val) {
            cur.next = list1;
            list1 = list1.next;
        }
        else {
            cur.next = list2;
            list2 = list2.next;
        }
        cur = cur.next;
    }
    cur.next = list1 == null ? list2 : list1;
    return head.next;
};