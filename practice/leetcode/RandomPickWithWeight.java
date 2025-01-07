import java.util.Random;

public class RandomPickWithWeight {


    // Step 1 -
    // We will create an array which contains the prefix sums/ sunning cummulative
    // sum
    // The length of each interval(index) is proprtionate to it's weight.
    // w = [1, 3, 2]
    // 0: [1, 1]
    // 1: [2, 4]
    // 2: [5, 6]
    int[] nums;
    Random rand;
    int total;

    public RandomPickWithWeight(int[] w) {
        this.nums = new int[w.length];
        this.rand = new Random();

        int prefixSum = 0;
        for (int i = 0; i < w.length; i++) {
            prefixSum += w[i];
            nums[i] = prefixSum;
        }

        // since the range for finding a random nmber will be [1, total]
        this.total = prefixSum;
    }

    public int pickIndex() {
        // pick index : 0 -> w.length - 1
        // Ex : w :[1, 3, 10, 12]
        // nums :[1, 4, 14, 26]

        // Generate a random number and find the interval it belongs to in nums
        int target = this.rand.nextInt(this.total) + 1; // Add a one to alter the range from [0, total - 1] -> [1,
        // total]

        int low = 0;
        int high = nums.length - 1;

        // Ex : target = 9
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
