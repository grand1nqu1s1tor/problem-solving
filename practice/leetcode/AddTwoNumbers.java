class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Have a carry at each add step : 0 or 1
        // Traverse the LLs from the head

        int sum = 0;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        // Break outta the loop if both are null
        while (l1 != null || l2 != null) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // Add of two digits and carry
            int currSum = (carry + val1 + val2);
            carry = currSum / 10;

            current.next = new ListNode(currSum % 10);

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
            current = current.next;
        }
        // At the end if we have a pending carry
        if (carry == 1)
            current.next = new ListNode(carry);
        return dummy.next;
    }
}