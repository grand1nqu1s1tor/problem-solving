package leetcode;

import java.util.*;
//BFS from CLRS implementation
public class GraphBFS {

    static class Vertex {
        String id;
        int d;          // Distance from the source
        Vertex pi;      // Predecessor in the BFS tree
        Color color;    // The color of the vertex during BFS

        public Vertex(String id) {
            this.id = id;
            this.pi = null;
            this.color = Color.WHITE;
            this.d = Integer.MAX_VALUE;
        }
    }

    enum Color {
        WHITE, GRAY, BLACK
    }

    public static void main(String[] args) {
        // Initialize the graph
        Map<String, Vertex> vertices = new HashMap<>();
        vertices.put("q", new Vertex("q"));
        vertices.put("r", new Vertex("r"));
        vertices.put("s", new Vertex("s"));
        vertices.put("t", new Vertex("t"));
        vertices.put("u", new Vertex("u"));
        vertices.put("v", new Vertex("v"));
        vertices.put("w", new Vertex("w"));
        vertices.put("x", new Vertex("x"));
        vertices.put("y", new Vertex("y"));
        vertices.put("z", new Vertex("z"));

        Map<Vertex, List<Vertex>> graph = new HashMap<>();
        graph.put(vertices.get("q"), Arrays.asList(vertices.get("s"), vertices.get("t"), vertices.get("w")));
        graph.put(vertices.get("r"), Arrays.asList(vertices.get("u"), vertices.get("y")));
        graph.put(vertices.get("s"), Arrays.asList(vertices.get("v")));
        graph.put(vertices.get("t"), Arrays.asList(vertices.get("x"), vertices.get("y")));
        graph.put(vertices.get("u"), Arrays.asList(vertices.get("y")));
        graph.put(vertices.get("v"), Arrays.asList(vertices.get("w")));
        graph.put(vertices.get("w"), Arrays.asList(vertices.get("s")));
        graph.put(vertices.get("x"), Arrays.asList(vertices.get("z")));
        graph.put(vertices.get("y"), Arrays.asList(vertices.get("q")));
        graph.put(vertices.get("z"), Arrays.asList(vertices.get("x")));

        // Perform BFS
        bfs(graph, vertices.get("q"));

        // Print the distances and predecessors
        for (Vertex v : vertices.values()) {
            System.out.println("Vertex: " + v.id + ", Distance: " + v.d + ", Predecessor: " +
                    (v.pi == null ? "None" : v.pi.id));
        }
    }

    public static void bfs(Map<Vertex, List<Vertex>> graph, Vertex source) {
        source.color = Color.GRAY;
        source.d = 0;
        source.pi = null;

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex u = queue.poll();
            for (Vertex v : graph.getOrDefault(u, new ArrayList<>())) {
                if (v.color == Color.WHITE) {
                    v.color = Color.GRAY;
                    v.d = u.d + 1;
                    v.pi = u;
                    queue.add(v);
                }
            }
            u.color = Color.BLACK;
        }
    }
}
