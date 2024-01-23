import java.util.Iterator;
import java.util.Stack;

public class DeleteMiddle {
    public static void main(String[] args) {
        // Defining a stack
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(0);
        stack.push(4);
        stack.push(7);
        stack.push(1);

        topDownTraversal(stack);
        delete(stack, (stack.size() / 2) + 1); // Corrected middle element calculation
        System.out.println("After");
        topDownTraversal(stack);
    }

    private static void delete(Stack<Integer> stack, int k) {
        if (k == 1) {
            stack.pop();
            return;
        }
        int temp = stack.pop();
        delete(stack, k - 1);
        stack.push(temp);
    }

    private static void topDownTraversal(Stack<Integer> stack) {
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
