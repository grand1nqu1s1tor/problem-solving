import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Create the adjacency list
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            int src = times[i][0];
            int dest = times[i][1];
            int time = times[i][2];
            adj.get(src).add(new int[]{dest, time});
        }

        // Initialize the distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // PriorityQueue to process the nodes with the smallest distance first
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll(); // Get the node with the smallest distance
            int currNode = curr[0];
            int currTime = curr[1];

            if (currTime > dist[currNode]) continue; // Skip if we've already found a shorter path

            // Explore neighbors
            for (int[] neighbor : adj.get(currNode)) {
                int nextNode = neighbor[0];
                int travelTime = neighbor[1];
                int newTime = currTime + travelTime;

                if (newTime < dist[nextNode]) {
                    dist[nextNode] = newTime;
                    pq.add(new int[]{nextNode, newTime});
                }
            }
        }

        // Find the maximum time taken to reach any node
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // If any node is unreachable
            }
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
