package lesson20230912;

import java.util.ArrayList;
import java.util.List;

public class CustomGraph {

    private List<List<Integer>> adjacencyList;

    public CustomGraph(List<Edge> edges) {
        int maxIndex = 0;
        for (Edge e : edges) {
            maxIndex = Math.max(maxIndex, Math.max(e.destination, e.source));
        }

        adjacencyList = new ArrayList<>(maxIndex + 1);
        for (int i = 0; i < maxIndex + 1; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (Edge e : edges) {
            adjacencyList.get(e.source).add(e.destination);
//            adjacencyList.get(e.destination).add(e.source); // undirected graph
        }

    }

    public static class Edge {
        private int source;
        private int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }


    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1));
        edges.add(new Edge(0, 2));
        edges.add(new Edge(1, 3));

        CustomGraph customGraph = new CustomGraph(edges);

        customGraph.print();
    }

    public void print() {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.println(i + " --> " + adjacencyList.get(i));
        }
    }


}
