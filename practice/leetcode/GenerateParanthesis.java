import java.util.ArrayList;
import java.util.List;

class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        // List to store valid combinations
        List<String> valid = new ArrayList<>();
        // Start backtracking
        generateParenthesis(new StringBuilder(), 0, 0, n, valid);
        return valid;
    }

    private void generateParenthesis(StringBuilder current, int open, int close, int n, List<String> valid) {
        // Base case: if the length of the current string equals 2 * n
        if (current.length() == 2 * n) {
            valid.add(current.toString());
            return; // Terminate further recursion
        }

        // If more closing parentheses can be added
        if (close < open) {
            current.append(")");
            generateParenthesis(current, open, close + 1, n, valid);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }

        // If more opening parentheses can be added
        if (open < n) {
            current.append("(");
            generateParenthesis(current, open + 1, close, n, valid);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}
