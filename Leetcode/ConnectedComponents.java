import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


class ConnectedComponents {
    public static void main(String args[]) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] dimensions = br.readLine().split(" ");
        int V = Integer.parseInt(dimensions[0]);
        int E = Integer.parseInt(dimensions[1]);


        //Adjacency List Creation
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        //Connecting Vertices with edges
        for (int i = 0; i < E; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);

            // Add edge to adjacency list (undirected graph)
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int count = 0;
        int[] visited = new int[V + 1];

        for (int i = 0; i < V; i++) {
            if (visited[i] == 1) continue;
            dfs(i, graph, visited);
            count++;
        }
        System.out.println(count);
    }

    public static void dfs(int vertex, ArrayList<ArrayList<Integer>> graph, int[] visited) {
        visited[vertex] = 1;
        for (int child : graph.get(vertex)) {
            if (visited[child] == 0)
                dfs(child, graph, visited);
        }
    }
}
