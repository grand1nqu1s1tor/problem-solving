import java.util.*;

public class TopKFrequent {


    public int[] topKFrequentBruteForce(int[] nums, int k) {
        //BRUTE FORCE APPROACH


/*

    Map Storage:
        O(m),for storing frequencies of unique elements.
        Heap Storage:
        O(m),for storing all unique elements in the heap.
        Result Array:
        O(k),for storing the top k elements.

 */

        //Create a map to track frequencies
        Map<Integer, Integer> map = new HashMap();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[k];

        //MaxHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        //Map traversal to add frequencies of key to the heap
        //O(mlogm)
        for (int key : map.keySet()) {
            maxHeap.offer(key);
        }

        //O(klogm)
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }


    public int[] topKFrequentOptimal(int[] nums, int k) {
        //O(N) Optimal Solution
        //Approach : What  we can do is use the frequency of elements as the index of an Array/List

        // Index : Value
        //Frequency : Elements with that frequency

        // O(N) Optimal Solution
        // Approach : What we can do is use the frequency of elements as the index of an
        // Array/List

        // Index : Value
        // Frequency : Elements with that frequency

        Map<Integer, Integer> freqMap = new HashMap();
        // Important Declaration
        List<Integer>[] freqBuckets = new ArrayList[nums.length + 1];

        // Count frequencies
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // (Count : Element) -> (3 : 1), (2 : 2), (3 : 3)
        for (int key : freqMap.keySet()) {
            int frequency = freqMap.get(key);

            // Create a new bucket for the current index
            if (freqBuckets[frequency] == null) {
                freqBuckets[frequency] = new ArrayList();
            }
            freqBuckets[frequency].add(key);
        }

        // Starting from the highest frequency buvcket
        int[] result = new int[k];
        int idx = 0;
        for (int i = freqBuckets.length - 1; i >= 0; i--) {
            if (freqBuckets[i] != null) {
                List<Integer> elements = freqBuckets[i];
                for (int j = 0; idx < k && j < elements.size(); j++, idx++) {
                    result[idx] = elements.get(j);
                }
            }
        }

        return result;

    }
}

