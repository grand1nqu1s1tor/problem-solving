/*
* Prefix Scores Problem Statement
Given an array arr of n integers, perform the following operations:

For each prefix subarray arr[0:i] (1-based index), modify its elements such that:

Each element at index j is incremented by the maximum value in arr[0:i].
Compute the score for each prefix subarray, which is the sum of elements after applying the transformation.

Return an array of size n where the i-th element represents the score of the prefix subarray arr[0:i] after transformations.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrefixScores {

    public static List<Integer> prefixScores(int[] arr) {

        int n = arr.length;
        int[] result = new int[n];
        int currMax = Integer.MIN_VALUE;
        int currSum = 0;
        int sumOfCurrSum = 0;


        // Compute prefix sums
        for (int i = 0; i < n; i++) {
            //Add current element to currSum
            currSum += arr[i];
            sumOfCurrSum += currSum;

            if (arr[i] > currMax) currMax = arr[i];

            result[i] = sumOfCurrSum + currMax * (i + 1);
        }

        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(prefixScores(arr));
    }
}




