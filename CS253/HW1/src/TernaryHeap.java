/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING ANY SOURCES OUTSIDE OF THOSE APPROVED BY THE INSTRUCTOR. [Zac Israel, 2331238]*/
import java.util.ArrayList;
import java.util.Comparator;
public class TernaryHeap<K> extends Heap<K> {
    private Comparator<K> comp;
    public TernaryHeap(){
        this(new DefaultComparator<K>());
    }
    public TernaryHeap(Comparator<K> comp){
        array = new ArrayList<>();
        this.comp = comp;
    }

    private void swap(int i, int j){
        K test = array.get(j); // create a variable for the element at index j
        array.set(j, array.get(i)); // set the element at index j equal to the element at index i
        array.set(i, test); // set the element at index i equal to the original element at index j
    }
    private int root(){
        // returns the index of the root
        return 0;
    }
    private int left(int i){
        return 3 * i + 1;
    }
    private int middle(int i){
        return 3 * i + 2;
    }
    private int right(int i){
        return 3 * i + 3;
    }
    private int parent(int i){
        if(i % 3 == 1 || i % 3 ==2){
            return i/3;
        } else{
            return (i/3) -1;
        }
    }
    public boolean hasLeft(int i){ // checks is the element at index i has a left child
        return left(i) < array.size();
    }
    public boolean hasRight(int i){ // checks is the element at index i has a right child
        return right(i) < array.size();
    }
    public boolean hasMiddle(int i){ // checks if the element at index i has a middle child
        return middle(i) < array.size();
    }
    private void sink(int i){
        while(hasLeft(i)) { // while the element at the current index has a left child
            int leftIndex = left(i);
            int smallChildIndex = leftIndex; // set the smallChildIndex equal to the index of the leftChild
            if(hasMiddle(i) && !hasRight(i)){
                // If the element at the current index has a middleChild but not a right child,
                int midIndex = middle(i); // create a variable to store the index of the current element's middle child
                if(comp.compare(array.get(leftIndex),array.get(midIndex)) > 0){
                    // If the middle child is smaller than the leftChild,
                    smallChildIndex = midIndex; // set the smallChildIndex equal to the index of the middleChild
                }
            }
            if(hasMiddle(i) && hasRight(i)){ // If the element at the current index has a middle and a right child,
                int rightIndex = right(i);// create a variable to store the index of the current element's right child
                int midIndex = middle(i); // create a variable to store the index of the current element's middle child
                if(comp.compare(array.get(midIndex),array.get(rightIndex)) > 0 && comp.compare(array.get(leftIndex),array.get(rightIndex)) > 0){
                    // If the rightChild is smaller than the leftChild and the middleChild, set the smallChildIndex equal to the rightChildIndex
                    smallChildIndex = rightIndex;
                }
                if(comp.compare(array.get(rightIndex),array.get(midIndex)) > 0 && comp.compare(array.get(leftIndex),array.get(midIndex)) > 0){
                    // If the middleChild is smaller than the rightChild and the leftChild, set the smallChildIndex equal to the middleChildIndex
                    smallChildIndex = midIndex;
                }
            }

            if (comp.compare(array.get(smallChildIndex), array.get(i)) >= 0) {
                // If the smallestChild of the current element is greater than the current element,
                // break out of the while loop because the heap conditions have been satisfied.
                break;
            }

            // The smallestChild is smaller than it's parent
            swap(i, smallChildIndex); // swap the two elements
            i = smallChildIndex; // set i equal to the smallChildIndex so we can go through the while loop again

        }


        }
    private void swim(int i){
        while(i > 0){ // while the current element is not the root,
            int parent = parent(i); // create a variable that stores the index of the i element's parent
            if(comp.compare(array.get(i),array.get(parent)) >= 0) {
                // If the element at index i is greater or equal to its parent, break out of the while loop because
                // the heap condition has been satisfied.
                break;
            }
            // The element at index i is smaller than its parent
            swap(i, parent); // swap the two
            i = parent; // set i equal to its parent so we can continue through the loop
        }

    }

    public void insert(K k){
        array.add(k); // Insert the element
        swim(array.size()-1); // swim it up the heap
    }
    public K removeMin(){
        if(isEmpty()){ // If the array is empty, return null
            return null;
        }
        K tempRoot = array.get(0); // Create a variable that stores the value of the root
        array.set(0, array.get(size() - 1)); // set the root element's value equal to the last element added's value
        array.remove(array.size()-1); // remove the last element added
        sink(0); // sink the root until heap conditions are satisfied
        return tempRoot; // return the original root
    }
    public K min(){
        if(array.isEmpty()){// If the array is empty, return null
            return null;
        }
        return array.get(0); // return the root
    }

    @Override
    public String toString() { // to string method for testing purposes
        return "{" +
                "array=" + array +
                '}';
    }

    public static void main(String[] args) {
        TernaryHeap<Integer> ternaryHeap = new TernaryHeap<>();
        ternaryHeap.insert(100);
        ternaryHeap.insert(90);
        ternaryHeap.insert(120);
        ternaryHeap.insert(88);
        ternaryHeap.insert(40);
        ternaryHeap.insert(2);
        ternaryHeap.insert(3);
        ternaryHeap.insert(4);

        System.out.println(ternaryHeap);

        ternaryHeap.removeMin();
        System.out.println(ternaryHeap);
        ternaryHeap.removeMin();
        System.out.println(ternaryHeap);
        ternaryHeap.removeMin();
        System.out.println(ternaryHeap);

    }
}
