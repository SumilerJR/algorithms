/*
执行用时：108 ms, 在所有 JavaScript 提交中击败了40.53 % 的用户
内存消耗：49.2 MB, 在所有 JavaScript 提交中击败了5.26 % 的用户
*/
/**
 * @param {number} k
 */
var MyCircularQueue = function (k) {
    this.size = k + 1;
    this.queue = new Array(size);
    this.front = 0;
    this.rear = 0;
};

/** 
 * @param {number} value
 * @return {boolean}
 */
MyCircularQueue.prototype.enQueue = function (value) {
    if (this.isFull())
        return false;
    else {
        this.queue[this.rear] = value;
        this.rear = (this.rear + 1) % this.size;
        return true;
    }
};

/**
 * @return {boolean}
 */
MyCircularQueue.prototype.deQueue = function () {
    if (this.isEmpty())
        return false;
    else {
        this.front = (this.front + 1) % this.size;
        return true;
    }
};

/**
 * @return {number}
 */
MyCircularQueue.prototype.Front = function () {
    return this.isEmpty() ? -1 : this.queue[this.front];
};

/**
 * @return {number}
 */
MyCircularQueue.prototype.Rear = function () {
    return this.isEmpty() ? -1 : this.queue[(this.rear + this.size - 1) % this.size];
};

/**
 * @return {boolean}
 */
MyCircularQueue.prototype.isEmpty = function () {
    return this.front === this.rear;
};

/**
 * @return {boolean}
 */
MyCircularQueue.prototype.isFull = function () {
    return (this.rear + 1) % this.size === this.front;
};

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = new MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */
