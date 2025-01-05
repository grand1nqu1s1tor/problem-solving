import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // The courses are represented as dependencies of once course on other in the
        // prerequisites array.
        // For example : [1, 2] -> 2 should be completed before 1
        // [2, 3]
        // Order : 3 -> 2 -> 1

        // Since we do not know the order yet, I am taking an ArrayList.
        ArrayList<Integer> result = new ArrayList();

        // Return an empty array if finishing all the courses is impossible
        int E = prerequisites.length;
        int V = numCourses;

        // Build a graph
        List<List<Integer>> graph = new ArrayList();
        for (int v = 0; v < V; v++) {
            graph.add(new ArrayList());
        }

        // Connect the course where complete b -> a
        for (int e[] : prerequisites) {
            graph.get(e[1]).add(e[0]);
        }

        int[] visited = new int[V];

        // Explore through the courses and keep adding to the Order
        for (int v = 0; v < V; v++) {
            // If a cycle is found, return null
            if (dfs(graph, v, visited, result)) {
                return new int[0];
            }
        }
        Collections.reverse(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean dfs(List<List<Integer>> graph, int current, int[] visited, List<Integer> result) {
        if (visited[current] == 1)
            return true;

        if (visited[current] == 2)
            return false;

        // Exporation started
        visited[current] = 1;

        // DFS to explore neighbors
        for (int neighbor : graph.get(current)) {
            if (dfs(graph, neighbor, visited, result)) {
                return true;
            }
        }

        // Add to result since the course is explored
        result.add(current);

        // Exploration Completed
        visited[current] = 2;

        // Major Minor Bug
        return false;
    }
}