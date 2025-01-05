import java.util.HashSet;
import java.util.Set;

/*
Using a Set
A Set can be used effectively for this problem. The reasoning:

The goal is to identify whether a character is already present in the current substring.
A Set can efficiently track characters in the substring because:
Insertion and lookup in a Set take
𝑂
(
1
)
O(1) time on average.
You don't need to count occurrences because the condition is binary:
Is the character already in the substring?
If yes, remove characters from the start until the substring becomes valid again.
*/

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            // If the character is already in the Set, remove characters from the left
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            // Add the current character to the Set
            set.add(s.charAt(right));
            // Update the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}