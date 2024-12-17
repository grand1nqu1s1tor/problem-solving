package leetcode;

import java.util.*;

class Subsets {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> subList = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        generateSubsets(0, nums);
        return result;
    }

    private void generateSubsets(int index, int[] nums) {
        if (index == nums.length) {
            result.add(new ArrayList<>(subList));
            return;
        }

        // Include the current number
        subList.add(nums[index]);
        generateSubsets(index + 1, nums);

        // Exclude the current number
        subList.remove(subList.size() - 1); // Backtracking step
        generateSubsets(index + 1, nums);
    }

    public static void main(String args[]) {
        Subsets sol = new Subsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = sol.subsets(nums);
        System.out.println("All possible subsequences are: ");
        for (List<Integer> subsequence : result) {
            System.out.println(subsequence);
        }
    }
}
