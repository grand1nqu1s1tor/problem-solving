import java.util.*;

public class BellmanFord {
    static final int INF = Integer.MAX_VALUE;

    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    private Map<Character, Integer> vertexMap = new HashMap<>();
    private List<Edge> edges;
    private int[] distance;
    private Integer[] predecessor;

    public BellmanFord(int vertices) {
        edges = new ArrayList<>();
        distance = new int[vertices];
        predecessor = new Integer[vertices];
    }

    public void addEdge(char src, char dest, int weight) {
        if (!vertexMap.containsKey(src)) {
            vertexMap.put(src, vertexMap.size());
        }
        if (!vertexMap.containsKey(dest)) {
            vertexMap.put(dest, vertexMap.size());
        }
        edges.add(new Edge(vertexMap.get(src), vertexMap.get(dest), weight));
    }

    public void execute(char sourceChar) {
        if (!vertexMap.containsKey(sourceChar)) {
            System.out.println("Source vertex does not exist.");
            return;
        }
        int source = vertexMap.get(sourceChar);
        Arrays.fill(distance, INF);
        distance[source] = 0;

        int vertices = vertexMap.size();
        for (int i = 1; i < vertices; i++) {
            for (Edge edge : edges) {
                int u = edge.src;
                int v = edge.dest;
                int weight = edge.weight;

                if (distance[u] != INF && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                    predecessor[v] = u;
                }
            }
            printStep(i);
        }

        // Check for negative weight cycles
        for (Edge edge : edges) {
            int u = edge.src;
            int v = edge.dest;
            int weight = edge.weight;
            if (distance[u] != INF && distance[u] + weight < distance[v]) {
                System.out.println("Graph contains a negative weight cycle.");
                return;
            }
        }
    }

    private void printStep(int step) {
        System.out.println("Step " + step + ":");

        // Headers
        System.out.print("Vertex\t");
        for (char vertex : vertexMap.keySet()) {
            System.out.print(vertex + "\t");
        }
        System.out.println();

        // Distances
        System.out.print("Distance\t");
        for (char vertex : vertexMap.keySet()) {
            int idx = vertexMap.get(vertex);
            System.out.print((distance[idx] == INF ? "INF" : distance[idx]) + "\t");
        }
        System.out.println();

        // Predecessors
        System.out.print("Predecessor\t");
        for (char vertex : vertexMap.keySet()) {
            int idx = vertexMap.get(vertex);
            System.out.print((predecessor[idx] == null ? "NIL" : getKeyByValue(vertexMap, predecessor[idx])) + "\t");
        }
        System.out.println();
        System.out.println(); // Add a blank line for better separation between steps
    }

    // Helper method to get key by value for mapping integer indices back to character vertices
    private char getKeyByValue(Map<Character, Integer> map, Integer value) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return '?';  // Return '?' if no matching character is found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of edges:");
        int edgeCount = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        BellmanFord graph = new BellmanFord(edgeCount);

        System.out.println("Enter the edges in the format <src> <dest> <weight>:");
        for (int i = 0; i < edgeCount; i++) {
            String input = scanner.nextLine();
            char src = input.split(" ")[0].charAt(0);
            char dest = input.split(" ")[1].charAt(0);
            int weight = Integer.parseInt(input.split(" ")[2]);
            graph.addEdge(src, dest, weight);
        }

        System.out.println("Enter the source vertex:");
        char source = scanner.nextLine().charAt(0);

        graph.execute(source);
    }
}


/*
Enter the number of edges:
10
Enter the edges in the format <src> <dest> <weight>:
s t 6
s y 7
t y 8
t x 5
t z -4
x t -2
y x -3
y z 9
z x 7
z s 2
Enter the source vertex:
s
*/
