import java.util.PriorityQueue;
import java.util.Queue;


class MedianFinder {

    Queue<Integer> large;
    Queue<Integer> small;

    public MedianFinder() {
        // Min Heap to hold the large nums
        large = new PriorityQueue();
        // Max heap to hold the small nums
        small = new PriorityQueue<>((a, b) -> b - a);
    }

    // Always add the new number to large.
    // Move the smallest number in large to small.
    // If small has more elements than large, move the largest number in small back
    // to large.
    public void addNum(int num) {
        large.offer(num);
        // Balance the heaps now
        small.offer(large.poll());

        // Conditonal check
        if (small.size() > large.size()) {
            large.offer(small.poll());
        }
    }

    // Always return the top of the minHeap
    public double findMedian() {
        return (large.size() > small.size()) ? (double) large.peek() : (double) (large.peek() + small.peek()) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */