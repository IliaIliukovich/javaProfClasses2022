package lesson20230522;

public class LinkedListQueue {

    private int size;

    private Node first;

    private Node last;

    private static class Node {
        Node next;
        String item;
    }

    public LinkedListQueue() {
        size = 0;
        first = null;
        last = null;
    }

    public void enqueue(String item){
            Node node = new Node();
            node.item = item;
        if (isEmpty()){
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public String dequeue(){
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        Node node = first;
        first = first.next;
        if (first == null) last = null;
        size--;
        return node.item;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }


    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
        queue.enqueue("D");
        queue.enqueue("E");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }



}
