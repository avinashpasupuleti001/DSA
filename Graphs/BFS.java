import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Bfs {
    static HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();

    static void addVertex(int v) {
        graph.putIfAbsent(v, new LinkedList<>());
    }

    
    static void addEdge(int src, int dest) {
        graph.get(src).add(dest);
        graph.get(dest).add(src); 
    }

    static void display() {
        for (int vertex : graph.keySet()) {
            System.out.print(vertex + " -> ");
            for (int neighbor : graph.get(vertex)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        addVertex(1);
        addVertex(2);
        addVertex(3);
        addVertex(4);
        addVertex(5);
        addVertex(6);
        addVertex(7);

        addEdge(1, 4);
        addEdge(1, 3);
        addEdge(1, 2);
        addEdge(4, 6);
        addEdge(4, 7);
        addEdge(2, 5);

        System.out.println("Adjacency List:");
        display();

        System.out.println("\nDFS Traversal:");
        dfsIterative(1);

    }

    private static void dfsIterative(int i) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            if (!visited.contains(vertex)) {
                System.out.print(vertex + " ");
                visited.add(vertex);
                for (int neighbor : graph.get(vertex)) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }
        }
    }
}
