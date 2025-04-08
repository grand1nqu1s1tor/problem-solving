/**
 * Problem Breakdown:
 * <p>
 * A function generates a number every second.
 * The number is either +1 or -1 from the previous number.
 * You need to find the maximum possible number after N seconds.
 */


public class MaxFromDataStream {

    public static int findMaxAfterNSeconds(int start, int n) {
        // Implement your logic here
        for(int i = 0; i < n; i++){
            start = start + 1;
        }
        return start;
    }

    public static void main(String[] args) {
        int start = 10;  // Initial number
        int n = 10;     // Number of seconds

        int maxNumber = findMaxAfterNSeconds(start, n);
        System.out.println("Maximum number after " + n + " seconds: " + maxNumber);
    }
}
