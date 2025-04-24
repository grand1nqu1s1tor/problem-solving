package heap.minheap;

public class MinHeap {

    //Representing heap as an array
    private int[] minHeap;
    //Size of the heap
    private int size;
    //Max size that the heap could be
    private int maxSize;

    //Initializing the heap
    public MinHeap(int maxSize){
        this.maxSize = maxSize;
        this.size = 0;
        this.minHeap = new int[maxSize];
    }

    //return smallest element
    public int peek(){
        if(size == 0) throw new IllegalStateException("Heap is empty");
        return minHeap[0];
    }

    //return and delete the top element
    public int pop(){
        if(size == 0) throw new IllegalStateException("Heap is empty");

        //Store the top element
        //Swap the last element
        //Heapify Down to balance
        int min = minHeap[0];
        minHeap[0] = minHeap[size - 1];
        size--;
        heapifyDown(0);
        return min;
    }

    private void heapifyDown(int i) {

    }

    //insert an element
    public void insert(int val){
        if(size == maxSize) throw new IllegalStateException("Heap is full");
        minHeap[size] = val;
        //Call the heapifyUp, since we add at the bottom and pass index
        heapifyUp(size);
        size++;
    }

    //Heapify up  the value when inserting at bottom
    public void heapifyUp(int idx){
        int parent = (idx - 1) / 2;
        while(idx > 0 && minHeap[parent] > minHeap[idx]){
            swap(idx, parent);
            // TRICKY : Now move one level up the tree and re-calculate the new parent to keep checking.
            idx = parent;
            parent = (idx - 1) / 2;
        }
    }

    private void swap(int idx, int parent) {
        int temp = minHeap[idx];
        minHeap[idx] = minHeap[parent];
        minHeap[parent] = temp;
    }


    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(5);
        minHeap.insert(-1);
        minHeap.insert(-10);
        minHeap.insert(2);
        minHeap.insert(4);
        minHeap.insert(2);
        minHeap.printHeap();
    }

    private void printHeap() {
        for(int num : minHeap){
            System.out.println(num);
        }
    }
}