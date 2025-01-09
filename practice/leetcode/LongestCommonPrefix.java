
class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // because the first and last elements are the elements that are gonna be the
        // least similar. In this problem, if we find even only one letter that is
        // different then we don't have ton continue. So comparing the most different
        // strings is the most efficient solution

        // GO over and check if the character for each index is same , if not then we
        // break out of the loop.

        // Index for character
        StringBuilder result = new StringBuilder();
        int c = 0;

        while (c < strs[0].length()) {
            char currChar = strs[0].charAt(c);

            for (int i = 0; i < strs.length; i++) {
                // Ensure c is within bounds for the current string
                if (c >= strs[i].length() || currChar != strs[i].charAt(c)) {
                    return result.toString();
                }
            }
            //If reached hear means that character was found in every string
            result.append(currChar);
            c++;
        }
        return result.toString();

    }
}