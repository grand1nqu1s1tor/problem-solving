package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MatrixTopoSortTemplate {
    public List<Integer> graphTopoSort(int numNodes, int[][] edges) {
        // Initialize graph and visited array
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
        }

        boolean[] visited = new boolean[numNodes];
        boolean[] onPath = new boolean[numNodes]; // To detect cycles
        Stack<Integer> stack = new Stack<>();
        List<Integer> order = new ArrayList<>();

        // Perform DFS for each unvisited node
        for (int i = 0; i < numNodes; i++) {
            if (!visited[i]) {
                if (!dfs(i, graph, visited, onPath, stack)) {
                    return null; // Return null if a cycle is detected
                }
            }
        }

        // Convert the stack into the result list
        while (!stack.isEmpty()) {
            order.add(stack.pop());
        }

        return order;
    }

    // Helper method to perform DFS and detect cycles
    private boolean dfs(int node, List<List<Integer>> graph, boolean[] visited, boolean[] onPath, Stack<Integer> stack) {
        if (onPath[node]) {
            return false; // Cycle detected
        }
        if (visited[node]) {
            return true; // Already processed
        }

        // Mark the node as visited and add to the current path
        visited[node] = true;
        onPath[node] = true;

        // Visit all neighbors
        for (int neighbor : graph.get(node)) {
            if (!dfs(neighbor, graph, visited, onPath, stack)) {
                return false; // Cycle detected in the subgraph
            }
        }

        // Mark the node as not on the path and add to the stack
        onPath[node] = false;
        stack.push(node);
        return true;
    }

    public static void main(String[] args) {
        MatrixTopoSortTemplate matrixTopoSortTemplate = new MatrixTopoSortTemplate();
        int numNodes = 4;
        int[][] edges = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(matrixTopoSortTemplate.graphTopoSort(numNodes, edges));
        // Possible Output: [0, 1, 2, 3] or [0, 2, 1, 3]
    }
}
