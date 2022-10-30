function ListNode(val, next) {
    this.val = (val === undefined ? 0 : val);
    this.next = (next === undefined ? null : next);
}
var MyLinkedList = function () {
    this.size = 0;
    this.head = new ListNode();
};

/** 
 * @param {number} index
 * @return {number}
 * 执行用时：128 ms, 在所有 JavaScript 提交中击败了29.58%的用户
 * 内存消耗：49.4 MB, 在所有 JavaScript 提交中击败了42.74%的用户
 */
MyLinkedList.prototype.get = function (index) {
    if (index < 0 || index >= this.size)
        return -1;
    let cur = this.head.next;
    for (let i = 0; i < index; i++) {
        cur = cur.next;
    }
    return cur.val;
};

/** 
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtHead = function (val) {
    this.head.next = new ListNode(val, this.head.next);
    this.size++;
};

/** 
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtTail = function (val) {
    let cur = this.head;
    for (let i = 0; i < this.size; i++) {
        cur = cur.next;
    }
    cur.next = new ListNode(val, null);
    this.size++;
};

/** 
 * @param {number} index 
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtIndex = function (index, val) {
    if (index > this.size)
        return;
    if (index < 0)
        indedx = 0;
    let cur = this.head;
    for (let i = 0; i < index; i++) {
        cur = cur.next;
    }
    cur.next = new ListNode(val, cur.next);;
    this.size++;
};

/** 
 * @param {number} index
 * @return {void}
 */
MyLinkedList.prototype.deleteAtIndex = function (index) {
    if (index < 0 || index >= this.size || this.size == 0)
        return;
    let cur = this.head;
    for (let i = 0; i < index; i++) {
        cur = cur.next;
    }
    cur.next = cur.next.next;
    this.size--;
};

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = new MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(val)
 * obj.addAtTail(val)
 * obj.addAtIndex(index,val)
 * obj.deleteAtIndex(index)
 */