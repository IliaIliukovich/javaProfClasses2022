package lesson20230912;

import java.util.LinkedList;
import java.util.List;

public class CustomTree {

    private Node root;

    private static class Node {
        String key;
        Integer value;

        Node left;
        Node right;

        public Node(String key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(String key, Integer value){
        root = put(root, key, value);
    }

    private Node put(Node node, String key, Integer value) {
        if (node == null) return new Node(key, value);

        if (key.compareTo(node.key) == 0) {
            node.value = value;
        } else if (key.compareTo(node.key) < 0){
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }
        return node;
    }

    public Integer get(String key){
        Node current = root;
        while (current != null){
            if (key.compareTo(current.key) == 0) {
                return current.value;
            } else if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public Iterable<String> getKeys() {
        List<String> keys = new LinkedList<>();
        inorder(keys, root);
        return keys;
    }

    private void inorder(List<String> keys, Node current) {
        if (current != null) {
            inorder(keys, current.left);
            keys.add(current.key);
            inorder(keys, current.right);
        }
    }


    public static void main(String[] args) {
        CustomTree customTree = new CustomTree();
        customTree.put("B", 1);
        customTree.put("A", 2);
        customTree.put("C", 3);
        customTree.put("F", 3);
        customTree.put("H", 3);
        customTree.put("S", 3);
        System.out.println(customTree.get("B"));

        Iterable<String> keys = customTree.getKeys();
        for (String k : keys) {
            System.out.println(k);
        }


    }





}


