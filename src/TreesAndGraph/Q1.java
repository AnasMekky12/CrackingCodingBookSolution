package TreesAndGraph;

import java.util.*;

public class Q1 {

    public static void main(String[] args) {
        Graph graph = new Graph(2);
        graph.addEdge(0, 1);
        int start = 0;
        int end = 1;
        boolean routeExists = graph.isRouteBetweenNodes(start, end);

        if (routeExists) {
            System.out.println("There is a route between " + start + " and " + end);
        } else {
            System.out.println("No route exists between " + start + " and " + end);
        }
    }
}

class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    public boolean isRouteBetweenNodes(int start, int end) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            if (currentNode == end) {
                return true;
            }
            visited[currentNode] = true;

            for (int neighbor : adjacencyList[currentNode]) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
}
