public class LinkedListExample {

    public static void main(String[] args) {
        StringLinkedList stringLinkedList = new StringLinkedList();

        stringLinkedList.add("Hello");
        stringLinkedList.add("my");
        stringLinkedList.add("dear");
        stringLinkedList.add("students !");

        stringLinkedList.printData();

    }

    private static class StringLinkedList {
        private Node head;
        private Node tail;

        public StringLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public boolean add(String data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
            return true;
        }

        public void printData() {
            Node currentNode = head;
            if (head == null) {
                System.out.println("Our LinkedList doesn't contain any data.");
                return;
            }

            while (currentNode != null) {
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }
            System.out.println();
        }

        private static final class Node {
            private String data;
            private Node next;

            public Node(String data) {
                this.data = data;
                this.next = null;
            }

            public String getData() {
                return data;
            }

            public void setData(String data) {
                this.data = data;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }
        }
    }
}
