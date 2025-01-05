import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        // Use BFS
        // Count the number of fresh oranges so that we know when to stop the BFS

        int minutes = 0;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList();

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // If orange is rotten add it to the queue to rot other oranges
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
                // Else increase fresh count
                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while (!queue.isEmpty() && fresh > 0) {
            int sz = queue.size();

            for (int i = 0; i < sz; i++) {

                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                for (int[] dir : dirs) {
                    // Rot the neighbors
                    int new_row = row + dir[0];
                    int new_col = col + dir[1];

                    // If the neighbor is fresh, rot it and add it to the queue
                    if (new_row < grid.length && new_row >= 0 && new_col < grid[0].length && new_col >= 0
                            && grid[new_row][new_col] == 1) {
                        grid[new_row][new_col] = 2;
                        fresh--;
                        queue.add(new int[]{new_row, new_col});
                    }
                }

            }
            minutes++;
        }
        //After the BFS completes if there are fresh oranges still, return -1.
        return (fresh > 0) ? -1 : minutes;
    }
}
