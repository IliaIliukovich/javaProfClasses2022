package lesson20230912;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public String getMinKey(){
        if (root == null) return null;

        Node current = root;
        while (current.left != null){
            current = current.left;
        }
        return current.key;
    }

    private void inorder(List<String> keys, Node current) {
        if (current != null) {
            inorder(keys, current.left);
            keys.add(current.key);
            inorder(keys, current.right);
        }
    }

    // DFS (Depth First Search)
    public void dfs(){
       dfs(root);
    }

    private void dfs(Node node) {
        if (node != null) {
            System.out.println(node.key);
            dfs(node.left);
            dfs(node.right);
        }
    }

    // BFS (Breadth First Search)
    public void bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node current = queue.poll();
            System.out.println(current.key);
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

    }


    public static void main(String[] args) {
        CustomTree customTree = new CustomTree();
        customTree.put("C", 1);
        customTree.put("B", 2);
        customTree.put("D", 3);
        customTree.put("E", 4);
        customTree.put("G", 5);
        customTree.put("F", 6);
        customTree.put("A", 7);
        System.out.println(customTree.get("F"));
        System.out.println("Min key = " + customTree.getMinKey());

        System.out.println("Inorder keys from tree:");
        Iterable<String> keys = customTree.getKeys();
        for (String k : keys) {
            System.out.println(k);
        }
        System.out.println("DFS tree travers result:");
        customTree.dfs();
        System.out.println("BFS tree travers result:");
        customTree.bfs();


    }





}


