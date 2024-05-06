import java.util.Arrays;

public class FloydWarshall {
    static int INF = 99999;
    static int n = 6;
    public static int[][] next = new int[n][n];

    static void FloydWarshall(int g[][]) {
        int[][] dist = new int[n][n];
        int i, j, k;
        dist = g;

        int[][] predMatrix = new int[n][n];
        /*
         * Predecessor Matrix: is defined as the predecessor of vertex i on a shortest
         * path from vertex j with all intermediate vertices in the set 1,2,...,k
         */
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++)
                if (i != j)
                    predMatrix[i][j] = j + 1;
        }

        for (k = 0; k < n; k++) {
            System.out.println("Iteration " + (k + 1) + " using vertex " + (k + 1) + " as intermediate:");
            for (j = 0; j < n; j++) {
                for (i = 0; i < n; i++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        predMatrix[i][j] = predMatrix[i][k];
                    }
                }
            }
            printSolution(dist); // Print the matrix after each update
        }

        printResult(dist, predMatrix);
    }

    static void printResult(int[][] dist, int[][] pred) {
        System.out.println("pair     dist    path");
        for (int i = 0; i < pred.length; i++) {
            for (int j = 0; j < pred.length; j++) {
                if (i != j) {
                    int u = i + 1;
                    int v = j + 1;
                    String path = String.format("%d -> %d    %2d     %s", u, v, (int) dist[i][j], u);
                    do {
                        u = pred[u - 1][v - 1];
                        path += " -> " + u;
                    } while (u != v);
                    System.out.println(path);
                }
            }
        }
    }

    static void Path(int[][] dist, int[][] pred) {
        for (int i = 0; i < pred.length; i++) {
            for (int j = 0; j < pred.length; j++) {
                if (i != j) {
                    int u = i + 1;
                    int v = j + 1;
                    String path = String.format("%d -> %d    %2d     %s", u, v, (int) dist[i][j], u);
                    do {
                        System.out.println("  " + pred[i][j]);
                        u = pred[u - 1][v - 1];
                        path += " -> " + u;
                    } while (u != v);
                    System.out.println(path);
                }
            }
        }

    }

    static void printSolution(int dist[][]) {
        System.out.println("Following matrix: ");
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF\t");
                else
                    System.out.print(dist[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println(); // Add an extra newline for better separation between iterations
    }

    private static int[][] fastAPSP(int[][] W) {
        int n = W.length;
        int[][] L = W.clone();
        for (int i = 0; i < n; i++) {
            L[i] = W[i].clone();
        }
        for (int m = 1; m < n - 1; m *= 2) {
            L = minPlusMultiply(L, L);
        }
        return L;
    }
    private static int[][] minPlusMultiply(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(C[i], INF);
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (A[i][k] != INF && B[k][j] != INF)
                        C[i][j] = Math.min(C[i][j], A[i][k] + B[k][j]);
                }
            }
        }
        return C;
    }

    public static void main(String[] args) {

        //Input weighted directed graph
        int[][] adjacencyMatrix = {
                {0, INF, INF, INF, -1, INF},
                {1, 0, INF, 2, INF, INF},
                {INF, 2, 0, INF, INF, -8},
                {-4, INF, INF, 0, 3, INF},
                {INF, 7, INF, INF, 0, INF},
                {INF, 5, 10, INF, INF, 0}
        };

        printSolution(adjacencyMatrix);
        System.out.println("\n\tSolution Matrix:");
        FloydWarshall(adjacencyMatrix);
       /* System.out.println("FAST-APSP Solution Matrix:");
        int[][] fastApspResult = fastAPSP(adjacencyMatrix);
        printSolution(fastApspResult);*/
    }
}
//Can't be used for noegative edge cycles.