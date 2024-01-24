import java.util.Iterator;
import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        // Defining a stack
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(0);
        stack.push(4);
        stack.push(7);
        stack.push(1);

        System.out.println("Before");
        topDownTraversal(stack);

        reverseStackRecursive(stack);

        System.out.println("After");
        topDownTraversal(stack);
    }

    private static void reverseStackRecursive(Stack<Integer> stack) {
        if (stack.size() == 1) return;
        int temp1 = stack.pop();
        reverseStackRecursive(stack);
        insertAtBaseRecursive(stack, temp1);
        return;
    }

    private static void insertAtBaseRecursive(Stack<Integer> stack, int temp1) {
        if (stack.isEmpty()) {
            stack.push(temp1);
            return;
        }
        int temp2 = stack.pop();

        insertAtBaseRecursive(stack, temp1);
        stack.push(temp2);
    }


    private static void topDownTraversal(Stack<Integer> stack) {
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
