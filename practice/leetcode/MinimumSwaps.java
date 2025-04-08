import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* You have N cups numbered 1 to N, but they are arranged in a random order.
You are allowed to swap two cups at a time to bring them back into the correct order (1, 2, 3, ..., N).
Your task is to find the minimum number of swaps needed to sort them.*/
public class MinimumSwaps {


    class Solution {
        // Function to find the minimum number of swaps required to sort the array.
        public int minSwaps(int arr[]) {
            // Code here
            Map<Integer, Integer> map = new HashMap<>();
            int[] temp = arr.clone();
            Arrays.sort(temp);
            int swaps = 0, item = 0;
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], i);
            }
            for (int i = 0; i < arr.length; i++) {
                if (temp[i] != arr[i]) {
                    int index = map.get(temp[i]);
                    item = arr[i];
                    arr[i] = arr[index];
                    arr[index] = item;
                    swaps++;
                    map.put(arr[i], i);
                    map.put(arr[index], index);
                }
            }
            return swaps;
        }
    }
}
