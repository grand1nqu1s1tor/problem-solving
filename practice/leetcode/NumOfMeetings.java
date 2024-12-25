import java.util.ArrayList;

public class NumOfMeetings {

    public ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        // Create a list of meetings with start time, finish time, and original index
        ArrayList<int[]> meetings = new ArrayList<>();
        for (int i = 0; i < S.length; i++) {
            meetings.add(new int[]{S[i], F[i], i + 1});
        }

        // Sort meetings by their finish times (second element)
        meetings.sort((a, b) -> Integer.compare(a[1], b[1]));

        ArrayList<Integer> valid = new ArrayList<>();
        int prevEnd = 0; // To track the finish time of the last selected meeting

        // Iterate through all meetings to select valid ones
        for (int i = 0; i < meetings.size(); i++) {
            int[] curr = meetings.get(i);
            if (curr[0] > prevEnd) { // If the current meeting starts after the previous one ends
                valid.add(curr[2]);  // Add the original index of the meeting
                prevEnd = curr[1];   // Update the end time
            }
        }
        return valid;
    }

    public static void main(String[] args) {
        // Create an instance of the Solution class
        NumOfMeetings solution = new NumOfMeetings();

        // Test case 1: Standard input
        int N1 = 6;
        int[] S1 = {1, 3, 0, 5, 8, 5};
        int[] F1 = {2, 4, 6, 7, 9, 9};

        // Edge case: Overlapping meetings with the same end time
        int N2 = 4;
        int[] S2 = {1, 2, 3, 3};
        int[] F2 = {4, 4, 4, 4};

        // Test case 1
        System.out.println("Test Case 1:");
        ArrayList<Integer> result1 = solution.maxMeetings(N1, S1, F1);
        System.out.println("Selected meetings: " + result1);

        // Test case 2 (Edge case)
        System.out.println("\nEdge Case:");
        ArrayList<Integer> result2 = solution.maxMeetings(N2, S2, F2);
        System.out.println("Selected meetings: " + result2);
    }
}
