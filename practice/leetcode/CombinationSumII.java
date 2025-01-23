import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //Duplicates should be avoided to be used in the sum
        // Negatives plus duplicates are present.
        // Sort the Array to skip duplicates by aggreagting them

        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList();
        helper(target, 0, new ArrayList(), result, candidates);
        return result;
    }

    public void helper(int target, int idx, List<Integer> ds, List<List<Integer>> result, int[] cand) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList(ds));
            return;
        }

        for (int i = idx; i < cand.length; i++) {
            if (i > idx && cand[i] == cand[i - 1]) continue;
            ds.add(cand[i]);
            helper(target - cand[i], i + 1, ds, result, cand);
            ds.remove(ds.size() - 1);
        }
    }
}