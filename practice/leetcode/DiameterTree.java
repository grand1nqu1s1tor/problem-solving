package leetcode;

import java.util.*;

public class DiameterTree {

    static int maxDepth = 0;   // Global variable to track the maximum depth
    static int farthestNode = 0;  // Global variable to store the farthest node


    // Function to create the graph (adjacency list) from edges
    public static Map<Integer, List<Integer>> createGraph(int numNodes, int[][] edges) {
        // Adjacency list to represent the tree
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Initialize the adjacency list with empty lists for each node
        for (int i = 1; i <= numNodes; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Add the edges to the adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // Since it's an undirected tree, add both directions
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int numNodes = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int numEdges = sc.nextInt();

        // Input the edges of the tree
        int[][] edges = new int[numEdges][2];
        System.out.println("Enter the edges (node1 node2): ");
        for (int i = 0; i < numEdges; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        Map<Integer, List<Integer>> graph = createGraph(numNodes, edges);

        // Print the adjacency list (graph)
        System.out.println("Adjacency List of the Tree:");
        for (int node : graph.keySet()) {
            System.out.print(node + " -> ");
            for (int neighbor : graph.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }

        //Solution
        calculateDiameter(graph, 1, -1, 0);
        int startNode = farthestNode;
        calculateDiameter(graph, startNode, -1, 0);  // DFS from the farthest node
        System.out.println("The diameter of the tree is: " + maxDepth);
    }

    private static void calculateDiameter(Map<Integer, List<Integer>> graph, int currentNode, int parentNode, int depth) {

        if (depth > maxDepth) {
            maxDepth = depth;
            farthestNode = currentNode;
        }

        List<Integer> neighbors = graph.get(currentNode);
        for (int neighbor : neighbors) {
            if (neighbor != parentNode) {
                calculateDiameter(graph, neighbor, currentNode, depth + 1);
            }
        }
    }
}

/*
Input:
Enter number of nodes: 7
Enter number of edges: 6
Enter the edges (node1 node2):
1 2
2 3
2 4
3 5
4 6
4 7
*/