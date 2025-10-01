package problem26;

class MyCircularDeque {

    static class DoublyLinkedList {
        DoublyLinkedList left;
        DoublyLinkedList right;
        int value;

        public DoublyLinkedList(int val) {
            this.value = val;
        }
    }

    int length;
    int size;
    DoublyLinkedList head;
    DoublyLinkedList tail;

    public MyCircularDeque(int size) {
        head = new DoublyLinkedList(0);
        tail = new DoublyLinkedList(0);
        head.right = tail;
        tail.left = head;
        this.size = size;
        this.length = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        DoublyLinkedList node = new DoublyLinkedList(value);

        node.right = head.right;
        node.left = head;
        head.right.left = node;
        head.right = node;
        length++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        DoublyLinkedList node = new DoublyLinkedList(value);

        node.left = tail.left;
        node.right = tail;
        tail.left.right = node;
        tail.left = node;
        length++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head.right = tail.right;
        head.left = tail.right.right;
        length--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail.left.left.right = tail;
        tail.left = tail.left.left;
        length--;
        return true;
    }

    public int getFront() {
        return (isEmpty()) ? -1 : head.right.value;
    }

    public int getRear() {
        return (isEmpty()) ? -1 : tail.left.value;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == size;
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