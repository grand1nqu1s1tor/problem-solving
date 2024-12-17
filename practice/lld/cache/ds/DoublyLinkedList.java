package cache.ds;

public class DoublyLinkedList<E> {

    //Two temporary pointers to point to the first and the last node of the DLL
    DoublyLinkedListNode<E> dummyHead;
    DoublyLinkedListNode<E> dummyTail;

    //A constructor to initialize the DLL and the temp pointers
    public DoublyLinkedList() {
        dummyHead = new DoublyLinkedListNode<>(null);
        dummyTail = new DoublyLinkedListNode<>(null);

        //Connect the temp pointers since there are no elements currently.
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public DoublyLinkedListNode<E> getFirstNode() {
        DoublyLinkedListNode item = null;
        if (!isItemPresent()) {
            return null;
        }
        return dummyHead.next;
    }

    DoublyLinkedListNode<E> getLastNode() {
        DoublyLinkedListNode item = null;
        if (!isItemPresent()) {
            return null;
        }
        return dummyTail.prev;
    }

    public void addNodeLast(DoublyLinkedListNode<E> node) {
        DoublyLinkedListNode temp = dummyTail.prev;
        dummyTail.prev = node;
        node.next = dummyTail;
        temp.next = node;
        node.prev = temp;
    }

    public void detachNode(DoublyLinkedListNode<E> node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private boolean isItemPresent() {
        return dummyHead.next != dummyTail;
    }
}
