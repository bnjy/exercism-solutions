class DoublyLinkedList<T> {
    //init head & tail node
    private Node<T> head;
    private Node<T> tail;

    private static final class Node<T> {
        private final T value;
        private Node<T> prev;
        private Node<T> next;

        /**
         * Constructor of Element. Creates a new node that can be added/deleted from the double linked list.
         * @param value the node value.
         */
        Node(T value) {
            this.value = value;
        }
    }

    void push(T value) {
        Node<T> newNode = new Node<T>(value);
        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    T pop() {
        Node<T> returnNode = tail;
        if(head == tail){
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
        }
        return returnNode.value;

    }
    //(*insert value at front*).
    void unshift(T value) {
        Node<T> newNode = new Node<T>(value);
        if(head == null){
            push(newNode.value);
        } else{
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }
    //(*remove value at front*).
    T shift() {
        Node<T> returnNode = head;
        if(head == tail){
            return returnNode.value;
        } else {
            head = head.next;
            return returnNode.value;
        }
    }
}
