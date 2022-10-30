/**
 * @param {number} k
 * 执行用时：140 ms, 在所有 JavaScript 提交中击败了5.60%的用户
 * 内存消耗：48.8 MB, 在所有 JavaScript 提交中击败了84.48%的用户
 */
var MyCircularDeque = function (k) {
    this.size = k + 1;
    this.deque = new Array(this.size).fill(0);
    this.front = 0;
    this.rear = 0;
};

/** 
 * @param {number} value
 * @return {boolean}
 */
MyCircularDeque.prototype.insertFront = function (value) {
    if (this.isFull()) {
        return false;
    } else {
        this.front = (this.front - 1 + this.size) % this.size;
        this.deque[this.front] = value;
        return true;
    }
};

/** 
 * @param {number} value
 * @return {boolean}
 */
MyCircularDeque.prototype.insertLast = function (value) {
    if (this.isFull()) {
        return false;
    } else {
        this.deque[this.rear] = value;
        this.rear = (this.rear + 1) % this.size;
        return true;
    }
};

/**
 * @return {boolean}
 */
MyCircularDeque.prototype.deleteFront = function () {
    if (this.isEmpty()) {
        return false;
    } else {
        this.front = (this.front + 1) % this.size;
        return true;
    }
};

/**
 * @return {boolean}
 */
MyCircularDeque.prototype.deleteLast = function () {
    if (this.isEmpty()) {
        return false;
    } else {
        this.rear = (this.rear - 1 + this.size) % this.size;
        return true;
    }
};

/**
 * @return {number}
 */
MyCircularDeque.prototype.getFront = function () {
    return this.isEmpty() ? -1 : this.deque[this.front];
};

/**
 * @return {number}
 */
MyCircularDeque.prototype.getRear = function () {
    return this.isEmpty() ? -1 : this.deque[(this.rear - 1 + this.size) % this.size];
};

/**
 * @return {boolean}
 */
MyCircularDeque.prototype.isEmpty = function () {
    return this.front === this.rear;
};

/**
 * @return {boolean}
 */
MyCircularDeque.prototype.isFull = function () {
    return (this.rear + 1) % this.size === this.front;
};

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * var obj = new MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */