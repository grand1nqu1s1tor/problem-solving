import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsIII {
    /*
        Given an integer n, an alternating permutation is a permutation of the first n positive integers
        such that no two adjacent elements are both odd or both even.
        Return all such alternating permutations sorted in lexicographical order.

        Example 1:
        Input: n = 4
        Output: [[1,2,3,4],[1,4,3,2],[2,1,4,3],[2,3,4,1],[3,2,1,4],[3,4,1,2],[4,1,2,3],[4,3,2,1]]

        Example 2:
        Input: n = 2
        Output: [[1,2],[2,1]]

        Example 3:
        Input: n = 3
        Output: [[1,2,3],[3,2,1]]

        Constraints : n is ranging from 1 to 10.
     */

    public int[][] alternatingPermutations(int n) {
        //Result list and Numbers already used in the permutation
        List<int[]> result = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];

        //Helper method call
        backtrack(new ArrayList<>(), visited, n, result);

        int[][] res = result.toArray(new int[result.size()][]);
        Arrays.sort(res, Arrays::compare);
        return res;
    }

    public void backtrack(List<Integer> path, boolean[] visited, int n, List<int[]> result) {
        //Base Case : If we got the complete permutation
        if (path.size() == n) {
            //Create the permutation
            int[] temp = new int[n];
            for (int i = 0; i < n; i++) {
                temp[i] = path.get(i);
            }
            //Add the permutation
            result.add(temp);
            return;
        }

        //Try each candidate number starting from 1 to n
        for (int i = 1; i <= n; i++) {
            //If already used, skip
            if (visited[i]) continue;

            //Check if parity is same, skip
            if (!path.isEmpty()) {
                int last = path.get(path.size() - 1);
                boolean sameParity = (i % 2) == (last % 2);
                if (sameParity) continue;
            }

            //CHOOSE
            //visit and include current number
            visited[i] = true;
            path.add(i);

            backtrack(path, visited, n, result);

            //UNDO
            //remove and mark unvisited
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        PermutationsIII obj = new PermutationsIII();
        System.out.println(Arrays.deepToString(obj.alternatingPermutations(1))); // [[1]]
        System.out.println(Arrays.deepToString(obj.alternatingPermutations(2))); // [[1, 2], [2, 1]]
        System.out.println(Arrays.deepToString(obj.alternatingPermutations(3))); // [[1, 2, 3], [3, 2, 1]]
        System.out.println(Arrays.deepToString(obj.alternatingPermutations(4)));
    }

}
