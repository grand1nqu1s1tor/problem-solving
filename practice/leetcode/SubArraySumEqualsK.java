import java.util.HashMap;
import java.util.Map;

class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        //Number of subarrays where sum equal to k
        //Can the elements be negative
        //Contiguous set of elements
        // We are given a target, so we can sort the array and then use the two pointer technique
        // Where the pointers include the subarray between the pointers
        // We shrink the window from the left if sum > k
        // We expand the window to the right if sum < k

    /*
    => THE TWO POINTER APPROACH WON'T WORK SINCE WE CAN HAVE NEGATIVE NUMBERS AND
    A NEGATIVE NUMBER CAN AFFECT THE SUM AND MOVE THE WRONG POINTER
    => SORTING WON'T WORK IN THIS CASE SINCE IT WOULD DESTROY THE CONTIGUOUS PROPERTY.
    */

        //APPROACH :PREFIX SUM
        // If at position i, the running sum is prefixSum and,
        // we are looking for a subarray ending at i with a sum of k,
        // then there will be an old prefixSum in the map which is (prefixSum - k)

        //a map of prefix sum and occurrences
        Map<Integer, Integer> map = new HashMap();
        int prefixSum = 0;
        map.put(prefixSum, 1);
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (map.containsKey(prefixSum - k)) {
                count = count + map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;

    }
}
