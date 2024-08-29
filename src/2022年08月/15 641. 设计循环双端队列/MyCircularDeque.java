//执行用时：4 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：42.2 MB, 在所有 Java 提交中击败了19.03%的用户
class MyCircularDeque {
    int size;
    int[] deque;
    int front, rear;
    public MyCircularDeque(int k) {
        this.size = k + 1;
        this.deque = new int[size];
        this.front = 0;
        this.rear = 0;
    }

    public boolean insertFront(int value) {
        if (this.isFull()) {
            return false;
        } else {
            this.front = (this.front - 1 + this.size) % this.size;
            this.deque[this.front] = value;
            return true;
        }
    }

    public boolean insertLast(int value) {
        if (this.isFull()) {
            return false;
        } else {
            this.deque[this.rear] = value;
            this.rear = (this.rear + 1) % this.size;
            return true;
        }
    }

    public boolean deleteFront() {
        if (this.isEmpty()) {
            return false;
        } else {
            this.front = (this.front + 1) % this.size;
            return true;
        }
    }

    public boolean deleteLast() {
        if (this.isEmpty()) {
            return false;
        } else {
            this.rear = (this.rear - 1 + this.size) % this.size;
            return true;
        }
    }

    public int getFront() {
        return this.isEmpty() ? -1 : this.deque[this.front];
    }

    public int getRear() {
        return this.isEmpty() ? -1 : this.deque[(this.rear - 1 + this.size) % this.size];
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public boolean isFull() {
        return (this.rear + 1) % this.size == this.front;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */