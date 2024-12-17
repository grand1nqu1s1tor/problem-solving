package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSetNoDups {
    private List<List<Integer>> ansList = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        generateSubsets(0, nums, new ArrayList<>());
        return ansList;
    }

    private void generateSubsets(int index, int[] nums, List<Integer> subList) {
        System.out.println("GENERATE SUBSETS(" + index + ", " + subList + ")");
        ansList.add(new ArrayList<>(subList));
        System.out.println("Added subList: " + subList + " to the final list: " + ansList);

        for (int i = index; i < nums.length; i++) {
            System.out.println("enter for loop with i: " + i + " and index: " + index);
            if (i > index && nums[i - 1] == nums[i]) {
                System.out.println("Skipping duplicate at index " + i + " (num: " + nums[i] + ")");
                continue;
            }

            System.out.println("Adding element: " + nums[i] + " in  the subList: " + subList);
            subList.add(nums[i]);
            generateSubsets(i + 1, nums, subList);

            System.out.println("Removing element from index: " + i + " which is: " + nums[i]);
            subList.remove(subList.size() - 1); // Backtracking step
            System.out.println("subList after removal" + subList);
        }
        System.out.println("Returning from index: " + index + " with subList: " + subList);
    }

    public static void main(String[] args) {
        PowerSetNoDups solution = new PowerSetNoDups();
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        System.out.println("Final Result: " + result);
    }
}
