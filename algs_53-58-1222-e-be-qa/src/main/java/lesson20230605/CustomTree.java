package lesson20230605;

public class CustomTree {

    private Node root;

    private class Node {

        String key;
        Integer value;

        public Node(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        Node left;
        Node right;

    }

    public Integer find(String key) {
        Node tmp = root;

        while (tmp != null) {
            int result = key.compareTo(tmp.key);
            if (result == 0) return tmp.value;
            if (result < 0) tmp = tmp.left;
            if (result > 0) tmp = tmp.right;
        }
        return null;
    }

    public void put(String key, Integer value){
        root = put(root, key, value);
    }

    private Node put(Node node, String key, Integer value){
        if (node == null) return new Node(key, value);
        if (key.compareTo(node.key) == 0) node.value = value;
        if (key.compareTo(node.key) < 0) node.left = put(node.left, key, value);
        if (key.compareTo(node.key) > 0) node.right = put(node.right, key, value);
        return node;
    }

    public static void main(String[] args) {

        CustomTree tree = new CustomTree();
        tree.put("Ivan", 26);
        tree.put("Mary", 33);
        tree.put("Peter", 11);

        System.out.println(tree.find("Ivan"));
        System.out.println(tree.find("Mary"));
        System.out.println(tree.find("Peter"));
        System.out.println(tree.find("Tom"));

        tree.put("Peter", 50);
        System.out.println(tree.find("Peter"));

    }

    public Integer getMin(){
        return null;
    }








}
