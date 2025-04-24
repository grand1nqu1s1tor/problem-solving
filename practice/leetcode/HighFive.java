import java.util.*;

public class HighFive {
    /*
       Given a list of scores of different students,
       return the average score of each student's top five scores
       in the order of each student's id.

        Each entry items[i] has items[i][0] the student's id,
        and items[i][1] the student's score.
        The average score is calculated using integer division.*/

    public int[][] findHighFive(int[][] items) {
        //Map of <ID, Heap of Scores>
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        //Step 1.
        for (int[] pair : items) {
            int id = pair[0];
            int score = pair[1];

            //Add a minHeap if a Key is not in place corresponding to the ID
            if (!map.containsKey(id)) {
                PriorityQueue minHeap = new PriorityQueue<>();
                map.put(id, minHeap);
            }
            map.get(id).offer(score);

            //Balance the min heap
            if (map.get(id).size() > 5) {
                map.get(id).poll();
            }
        }

        //Step 2. find the average
        int[][] result = new int[map.size()][];

        int i = 0;
        for (int id : map.keySet()) {
            PriorityQueue<Integer> tempHeap = map.get(id);

            int sum = 0;
            while (!tempHeap.isEmpty()) {
                sum += tempHeap.poll();
            }
            int average = sum / 5;

            result[i] = new int[]{id, average};
            i++;
        }

        //Sort the result by ID
        Arrays.sort(result, (a, b) -> Integer.compare(b[0], a[0]));

        return result;
    }

    public static void main(String[] args) {
        HighFive hf = new HighFive();
        int[][] scores = {
                {1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60},
                {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100},
                {2, 76}
        };
        int[][] output = hf.findHighFive(scores);
        for (int[] pair : output) {
            System.out.println(Arrays.toString(pair));
        }
    }
}
