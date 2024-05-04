import java.util.*;

public class DijkstraAlgo {
    private static final int INF = Integer.MAX_VALUE;
    private int vertices;
    private HashMap<Character, List<Node>> graph = new HashMap<>();
    private Map<Character, Integer> cityIndex = new HashMap<>();

    public DijkstraAlgo(int vertices) {
        this.vertices = vertices;
    }

    public void addEdge(char src, char dest, int toll) {
        graph.computeIfAbsent(src, k -> new ArrayList<>()).add(new Node(dest, toll));
    }

    public void findShortestPath(char start, char end) {
        // Initialize arrays for Dijkstra's algorithm
        int[] dist = new int[vertices];
        char[] prev = new char[vertices];
        Arrays.fill(dist, INF);
        Arrays.fill(prev, '?');
        dist[cityIndex.get(start)] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(n -> n.cost));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            char u = node.vertex;

            if (!graph.containsKey(u)) {
                continue;
            }

            for (Node adj : graph.get(u)) {
                char v = adj.vertex;
                int weight = adj.cost;
                if (dist[cityIndex.get(u)] != INF && dist[cityIndex.get(u)] + weight < dist[cityIndex.get(v)]) {
                    dist[cityIndex.get(v)] = dist[cityIndex.get(u)] + weight;
                    prev[cityIndex.get(v)] = u;
                    pq.add(new Node(v, dist[cityIndex.get(v)]));
                }
            }
        }

        printPath(prev, end);
        System.out.println(" -> " + end);
        System.out.println("Minimum toll cost: $" + dist[cityIndex.get(end)]);
    }

    private void printPath(char[] prev, char current) {
        if (prev[cityIndex.get(current)] == '?') {
            return;
        }
        printPath(prev, prev[cityIndex.get(current)]);
        System.out.print(" -> " + prev[cityIndex.get(current)]);
    }

    static class Node {
        char vertex;
        int cost;

        Node(char vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        DijkstraAlgo pathFinder = new DijkstraAlgo(vertices);

        System.out.println("Enter the vertices as single characters:");
        for (int i = 0; i < vertices; i++) {
            char city = scanner.nextLine().trim().charAt(0);
            pathFinder.cityIndex.put(city, i);
        }

        System.out.println("Enter the number of edges:");
        int edges = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter the edges and toll costs (source destination toll):");
        for (int i = 0; i < edges; i++) {
            String[] input = scanner.nextLine().split(" ");
            char src = input[0].charAt(0);
            char dest = input[1].charAt(0);
            int toll = Integer.parseInt(input[2]);
            pathFinder.addEdge(src, dest, toll);
        }

        System.out.println("Enter the starting city:");
        char src = scanner.nextLine().trim().charAt(0);

        System.out.println("Enter the destination city:");
        char dest = scanner.nextLine().trim().charAt(0);

        pathFinder.findShortestPath(src, dest);
    }
}
