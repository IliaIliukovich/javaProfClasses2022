package lesson20230605;

public class CustomTree {

    private Node root;



    private class Node {

        String key;
        Integer value;
        Node left;
        Node right;

    }

    public Integer find(String key) {
        return find(root, key);
    }

    public Integer find(Node node, String key) {
        if (node == null) return null;
        if (key.compareTo(root.key) == 0) return root.value;
        if (key.compareTo(root.key) < 0) find(root.left, key);
        if (key.compareTo(root.key) > 0) find(root.right, key);
        return null;
    }

    public void put(String key, Integer value){
        root = put(root, key, value);
    }

    public Node put(Node node, String key, Integer value){
        if (node == null){
            node = new Node();
            node.key = key;
            node.value = value;
            return node;
        }
        if (key.compareTo(node.key) == 0) node.value = value;
        if (key.compareTo(node.key) < 0) {
            node.left = put(node.left, key, value);
        }
        if (key.compareTo(node.key) > 0) {
            node.right = put(node.right, key, value);
        }
        return node;
    }

    public static void main(String[] args) {





    }








}
