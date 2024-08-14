import java.util.ArrayList;

class SinglyLinkedList {
    private Node head;
    private int size;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public SinglyLinkedList() {
        this.head = null;
        size = 0;
    }

    public int get(int index) {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException("err");
        Node current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    public void set(int index, int val) {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException("err");
        Node current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = val;
    }

    public void insertHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }

    public void insertTail(int val) {
        Node node = new Node(val);
        if(head == null) head = node;
        else {
            Node current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    public boolean remove(int index) {
        if(index < 0 || index >= size){
            return false;
        }
        if(index == 0) {
            head = head.next;
        }
        else{
            Node current = head;
            for(int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
        return true;
    }

    public void printAllNodes() {
        Node current = head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
