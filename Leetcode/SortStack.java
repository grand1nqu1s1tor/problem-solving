import java.util.Iterator;
import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        //Defining a stack
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(4);
        stack.push(7);
        stack.push(1);
        stack.push(0);

        System.out.println("Before");
        topDownTraversal(stack);

        //Sorting the Stack using Recursion
        recursiveSortStack(stack);

        System.out.println("After");
        topDownTraversal(stack);
    }

    private static void recursiveSortStack(Stack<Integer> stack) {

        if (!stack.isEmpty()) {
            int top = stack.pop();

            recursiveSortStack(stack);
            insertInt(stack, top);
        }
    }

    private static void insertInt(Stack<Integer> stack, int top) {
        if (stack.isEmpty() || top > stack.peek()) {
            stack.push(top);
            return;
        }

        int temp = stack.pop();
        insertInt(stack, top);

        stack.push(temp);
    }

    //Traversing the Stack
    private static void topDownTraversal(Stack<Integer> stack) {
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


}
