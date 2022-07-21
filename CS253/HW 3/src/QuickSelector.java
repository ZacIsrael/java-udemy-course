/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING ANY SOURCES OUTSIDE OF THOSE APPROVED BY THE INSTRUCTOR. [Zac Israel, 2331238]*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class QuickSelector<T extends Comparable<? super T>> {


    public T quickSelect(ArrayList<T> array, int index) {
        // your implementation goes here
        if(index <= 0 || index >= array.size()){
            // if invalid index is passed, throw illegal argument exception

        }

        if(array.size() == 1){
            // if the array only contains 1 element, return that element
            return array.get(0);
        }

        int pivotIndex = partition(array);


        int pivotNumber = pivotIndex + 1;


        // If the indexth element is the median, return it
        if(pivotNumber == index){

            return array.get(pivotIndex);
        }

        ArrayList<T> newSubList = null;

        if(pivotNumber > index){
            // If the pivot number is greater than the index,

            // This list refers to the sublist L in the pseudocode in the text book
            newSubList = createSubList(array, 0, pivotIndex-1);
            // Create sublist newSubList which stores the elements in the array less than the pivot

            return quickSelect(newSubList, index);
            // recur with the newSubList and the same index

        } else{
            //Otherwise,

            // This list refers to the sublist G in the pseudocode in the text book
            newSubList = createSubList(array, pivotIndex+1, array.size()-1);
            // Create sublist newSublist which stores the elements in the array greater than the pivot

            return quickSelect(newSubList, index-pivotNumber);
            // recur with the newSubList and the same index
        }

    }

    private ArrayList<T> createSubList(ArrayList<T> orginalList, int inclusiveStartIndex, int inclusiveEndIndex){
        // Helper method used to create a sublist

        ArrayList<T> newList = new ArrayList<>(orginalList.subList(inclusiveStartIndex, inclusiveEndIndex));

        newList.add(orginalList.get(inclusiveEndIndex));
        // java's sublist method includes the elements from the start index UP TO the end index.
        // That is why I have to add the end index of the original array here

        return newList; // return the new sublist
    }


    private T medianOfMedians(ArrayList<T> array) {
        // your implementation goes here

        if(array.size() > 0 && array.size() <= 5){
            // if the array has no more than 5 elements,
            // insertion sort the elements in the array,
            // then return the size/2 index to get the median of the array
           ArrayList<T> arr = insertionSort(array);
           return arr.get(arr.size()/2);
        }


        ArrayList<T> medians = new ArrayList<>();
        // initialize a new array list to store the medians from each sublist

        int currentIndex = 0;
        int highestIndex = array.size()-1;

        while (currentIndex <= highestIndex){
            // while the current index of the array is less than or equal to the last index of the array,

            // Get group size which is 5 except for may be the last group which will be array.size() mod 5
            int groupSize =  Math.min(5, highestIndex-currentIndex+1);


            ArrayList<T> groups = new ArrayList<>();
            // Initializes a new array list every iteration in the while loop to create these sub lists that contain at most 5 elements


            for (int i = 0; i < groupSize && currentIndex <= highestIndex; i++) {
                // iterate through this loop as long as i is less than 5 or n mod 5 AND
                // the current index is less than or equal to the array's last index.

                groups.add(array.get(currentIndex));
                currentIndex++;
                // increment the current index each time through the for loop so at the start of the next while loop iteration,
                // the current index will be 5 greater than the old current index
            }

           ArrayList<T> sorted = insertionSort(groups);
            // create a list and set it equal to the insertion sorted groups array list

           medians.add(sorted.get(sorted.size()/2));
           // add the median of the insertion sorted groups arraylist to the medians array list

        }

        return medianOfMedians(medians);  // recurs using the medians sublist
    }

    private T getMedian(ArrayList<T> subList){
        ArrayList<T> sortedList = insertionSort(subList);
        T median = null;
        int medianIndex = sortedList.size()/2;
        for (int i = 0; i < medianIndex; i++) {
            median = sortedList.get(i);
        }
        return median;

    }
    private void exch(ArrayList<T> a, int i, int j) {
        // simple helper method that swaps elements
        T swap = a.get(i);
        a.set(i, a.get(j));
        a.set(j, swap);
    }
    public ArrayList<T> insertionSort(ArrayList<T> a) {
        int N = a.size();
        for (int i = 0; i < N; i++) {


            for (int j = i; j > 0 && a.get(j).compareTo(a.get(j -1)) < 0; j--) {
                exch(a, j, j - 1);
            }
        }

        return a;
    }
    private int partition(ArrayList<T> array) {
        // Partition method that moves all of the elements less than the pivot below it,
        // and all the elements greater than the pivot above it.

        T pivot = medianOfMedians(array); // pivot is equal to the element equal to the medianOfMedians of the array
        int currentIndex = 0;
        int highestIndex = array.size() - 1;

        // Find the sorted position for pivotVale and return it's index
        while(currentIndex < highestIndex) {
            // while the current index is less than the highest index
            while(array.get(currentIndex).compareTo(pivot) < 0) {
                // While the element at the current index of the array is less than the pivot,
                // increment the currentIndex
                currentIndex ++;
            }

            while(array.get(highestIndex).compareTo(pivot) > 0) {
                // While the element at the highest index is greater than the element at the pivot,
                // decrement the highest index
                highestIndex--;
            }

            if(array.get(currentIndex).compareTo(array.get(highestIndex)) == 0) {
                // If the element at the current index is equal to the element at the highest index,
                // increment the current index
                currentIndex ++;
            } else if(currentIndex < highestIndex) {
                // if the current index is less than the highest index,
                // swap the element at the current index with the element at the highest index
                exch(array, currentIndex, highestIndex);

            }

        }
        return highestIndex;
    }

    public static void main(String[] args) {
        Integer arr[] = {7, 10, 4, 3, 20, 15, 27, 11, 13, 5,16,39,0,12,77,2,1,4,23,24};
        ArrayList<Integer> test = new ArrayList<>();
        for (Integer n : arr) {
            test.add(n);
        }
        QuickSelector<Integer> quickSelector = new QuickSelector<>();
        System.out.println(test);
        System.out.println(quickSelector.quickSelect(test, 15));
        System.out.println(quickSelector.insertionSort(test));

    }
}

