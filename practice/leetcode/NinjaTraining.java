import java.util.Arrays;

class NinjaTraining {
    public int maximumPoints(int arr[][]) {

        //Array has 3 columns representing tasks
        //Array has n columns representing days
        //Objective is to maximize merit points using tasks

        //Memoization array : Days * Tasks
        int days = arr.length;
        int tasks = arr[0].length;
        int[][] dp = new int[days][tasks + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(days - 1, 3, arr, dp);
    }

    public int helper(int currDay, int lastTask, int arr[][], int[][] dp) {
        int days = arr.length;
        int tasks = arr[0].length;

        //BC 1
        if (currDay < 0) return 0;

        //BC2
        if (currDay == 0) {
            int maxi = 0;
            for (int task = 0; task < tasks; task++) {
                if (task != lastTask) {
                    maxi = Math.max(maxi, arr[currDay][task]);
                }
            }
            return maxi;
        }

        //Use Memoization
        if (dp[currDay][lastTask] != -1) {
            return dp[currDay][lastTask];
        }

        //Induction
        //Select the maximum from the current day and move to the next day
        int maxi = 0;
        for (int task = 0; task < tasks; task++) {
            if (task != lastTask) {
                int currPoint = arr[currDay][task] + helper(currDay - 1, task, arr, dp);
                maxi = Math.max(currPoint, maxi);
            }
        }

        //Memoize it
        dp[currDay][lastTask] = maxi;
        return maxi;
    }
}