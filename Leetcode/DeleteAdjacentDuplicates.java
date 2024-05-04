public class DeleteAdjacentDuplicates {
    public String removeDuplicates(String s) {
        // Use a StringBuilder as a stack for its efficiency in append and delete operations
        StringBuilder stack = new StringBuilder();

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the stack is not empty and the top character of the stack is the same as the current character
            if (stack.length() > 0 && stack.charAt(stack.length() - 1) == c) {
                // Remove the top character from the stack (simulating a pop operation)
                stack.deleteCharAt(stack.length() - 1);
            } else {
                // Push the current character onto the stack
                stack.append(c);
            }
        }

        // Convert the StringBuilder back to a String to return the result
        return stack.toString();
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        DeleteAdjacentDuplicates solution = new DeleteAdjacentDuplicates();
        String input = "abbaca";
        String output = solution.removeDuplicates(input);
        System.out.println(output);
    }
}
