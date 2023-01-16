public class Queue {
    private class Node {
        private int data;
        private Node next;
        private  Node (int data) {
            this.data = data;
        }
    }

    private Node head; // Remove from Head
    private Node tail; // Add from tail

    public boolean isEmpty() {
        return head == null;
    }
    public int peek() {
        if (head == null) throw new NullPointerException();
        return head.data;
    }
    public void add(int data) {
        Node node = new Node(data);
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null) {
            head = node;
        }
    }
    public  int remove() {
        if (head == null) throw new NullPointerException();
        int data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }
}