import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSelect {
//Quickselect is an efficient algorithm to find the k-th smallest (or largest) element in an unsorted array.
//Inspired by Quicksort
//Uses partitioning, but only recurses into one side
//Finds the element at the exact index you care about, not the full sort

public int findKthLargest(int[] nums, int k) {
    int indexToFind = nums.length - k;
    return quickSelect(nums, 0, nums.length - 1, indexToFind);
}

private int quickSelect(int[] nums, int left, int right, int k) {
    int pivotIndex = partition(nums, left, right);

    if (pivotIndex == k) return nums[pivotIndex];
    else if (pivotIndex < k) return quickSelect(nums, pivotIndex + 1, right, k);
    else return quickSelect(nums, left, pivotIndex - 1, k);
}

private int partition(int[] nums, int left, int right) {
    //TODO
    return -1;
}

private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}
}