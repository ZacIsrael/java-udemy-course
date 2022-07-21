/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING ANY SOURCES OUTSIDE OF THOSE APPROVED BY THE INSTRUCTOR. [Zac Israel, 2331238]*/

import java.util.Comparator;

public class MedianHeap<K extends Comparable> {


    private PriorityQueue<K> maxRootHeap = new TernaryHeap<>(new MaxComparator());
    // This heap stores the values that are smaller than the median, the root of this heap could be the median. I used
    // MaxComparator for this heap because I want it to be a max heap so it would be easy to access the root (possible median)
    private PriorityQueue<K> minRootHeap = new TernaryHeap<>();
    // This heap stores the values that are greater than the median, the root of this heap could be the median. Min heap
    private Comparator<K> objectComparator = new DefaultComparator<K>(); // comparator used to compare the two objects

    public boolean isEmpty() {
        return maxRootHeap.isEmpty() && minRootHeap.isEmpty(); // return true if both heaps are empty, false otherwise
    }

    public int size() {
        return maxRootHeap.size() + minRootHeap.size(); // return the size of both heaps added together
    }

    private void rebalance() {
        int maxRootHeapSize = maxRootHeap.size();
        int minRootHeapSize = minRootHeap.size();
        K removedElement = null;
        if (maxRootHeapSize > minRootHeapSize + 1) { // If the maxHeap's size is larger than the minHeap's size by more
            // than 1 (meaning the median heap is unbalanced), remove the root of the maxHeap and add it to the minHeap
            removedElement = maxRootHeap.removeMin();
            minRootHeap.insert(removedElement);
        }
        if (minRootHeapSize > maxRootHeapSize + 1) { // If the minHeap's size is larger than the maxHeap's size by more
            // than 1 (meaning the median heap is unbalanced), remove the root of the minHeap and add it to the maxHeap
            removedElement = minRootHeap.removeMin();
            maxRootHeap.insert(removedElement);
        }
    }

    private boolean isGreater(K a, K b) {
        // checks if element a is greater than elements b
        if (b == null) {
            return true;
        }
        return objectComparator.compare(a, b) > 0;
    }

    public void insert(K k) {
        K median = median();
        if (isGreater(k, median)) {
            // if the element k is greater than the median, insert k into the minHeap
            minRootHeap.insert(k);
        } else {
            // Otherwise, insert k into the maxHeap
            maxRootHeap.insert(k);
        }
        rebalance(); // balance out the median heap
    }

    public K removeMedian() {
        if (maxRootHeap.size() >= minRootHeap.size()) {
            // If the maxHeap's (The heap with the elements smaller or equal to the median) size is greater than or equal
            // to the minHeap's size, return the root of the maxHeap
            return maxRootHeap.removeMin();
        }
        // Otherwise, return the root of the minHeap (the heap with elements greater or equal to the median)
        return minRootHeap.removeMin();
    }

    public K median() {
        int minHeapSize = maxRootHeap.size();
        int maxHeapSize = minRootHeap.size();
        K median = null;
        if (minHeapSize == 0 && maxHeapSize == 0) {
            // if both heaps are empty, return null
            return median;
        }
        if (minHeapSize > maxHeapSize) {
            // If the minHeap is larger than the maxHeap, return the root of the minHeap
            median = maxRootHeap.min();
            return median;
        }
        if (maxHeapSize > minHeapSize) {
            // If the maxHeap is larger than the minHeap, return the root of the maxHeap
            median = minRootHeap.min();
            return median;
        }

        // Both heaps are the same size
        K a = maxRootHeap.min();
        K b = minRootHeap.min();

        if (isGreater(a, b)) {
            // if the root of the maxHeap is greater than the root of the minHeap, return the root of the minHeap
            return b;
        } else {
            // otherwise, return the root  of the maxHeap
            return a;
        }
    }

    @Override
    public String toString() { // to string method for testing purposes
        return "{" +
                "maxRootHeap =" + maxRootHeap +
                ", minRootHeap =" + minRootHeap +
                "},\nmedian: " + median();
    }

    public static void main(String[] args) {
        MedianHeap<Integer> medianHeap = new MedianHeap<>();
        medianHeap.insert(1);
        medianHeap.insert(0);
        medianHeap.insert(15);
        medianHeap.insert(-2);
        medianHeap.insert(17);
        medianHeap.insert(-3);
        medianHeap.insert(11);
        medianHeap.insert(51);
        System.out.println(medianHeap);

        medianHeap.removeMedian();
        System.out.println(medianHeap);
        medianHeap.removeMedian();
        System.out.println(medianHeap);
        medianHeap.removeMedian();
        System.out.println(medianHeap);
        medianHeap.removeMedian();
        System.out.println(medianHeap);
        medianHeap.removeMedian();
        System.out.println(medianHeap);
        medianHeap.removeMedian();
        System.out.println(medianHeap);


    }

}
