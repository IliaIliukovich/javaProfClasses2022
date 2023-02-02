import java.util.LinkedList;
import java.util.Queue;

public class SearchTree {

    private Node root;

    private class Node {
        String key;
        int value;

        Node left;
        Node right;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void add(String key, int value) {
        root = addToTheTree(root, key, value);
    }

    private Node addToTheTree(Node tmp, String key, int value) {
        if (tmp == null) return new Node(key, value);
        if (key.compareTo(tmp.key) < 0) tmp.left = addToTheTree(tmp.left, key, value);
        if (key.compareTo(tmp.key) > 0) tmp.right = addToTheTree(tmp.right, key, value);
        if (key.compareTo(tmp.key) == 0) tmp.value = value;
        return tmp;
    }

    public int get(String key){
        Node tmp = root;

        while (tmp != null) {
            int result = key.compareTo(tmp.key);
            if (result == 0) return tmp.value;
            if (result < 0) tmp = tmp.left;
            if (result > 0) tmp = tmp.right;
        }
        return 0;
    }

    public Iterable<String> keys(){
        Queue<String> queue = new LinkedList<>();
        inorder(root, queue);
        return queue;
    }

    private void inorder(Node tmp, Queue<String> queue) {
        if (tmp == null) return;
        inorder(tmp.left, queue);
        queue.add(tmp.key);
        inorder(tmp.right, queue);
    }

    public static void main(String[] args) {
        SearchTree studentInfo = new SearchTree();

        studentInfo.add("Tom", 4);
        studentInfo.add("Martin", 3);
        studentInfo.add("Mary", 1);
        studentInfo.add("Edd", 4);
        studentInfo.add("Jimmy", 8);

        System.out.println(studentInfo.get("Tom"));
        System.out.println(studentInfo.get("Martin"));
        System.out.println(studentInfo.get("Mary"));
        System.out.println(studentInfo.get("Edd"));
        System.out.println(studentInfo.get("Jimmy"));
        System.out.println(studentInfo.get("Someone"));

        System.out.println("Ordered list of students in the tree:");
        Iterable<String> iterator = studentInfo.keys();
        iterator.forEach(System.out::println);
    }


}
