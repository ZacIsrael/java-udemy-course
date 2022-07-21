import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS.
 Zac Israel */

public class Sorting {

    //-------------------------------------------------------------
    //---------- Below is an implementation of Bubble Sort --------
    //-------------------------------------------------------------
    public static void BubbleSort(long[] a) {
        int out, in;
        for (out = a.length - 1; out > 0; out--) {
            boolean swapped = false;
            for (in = 0; in < out; in++) {
                if (a[in] > a[in + 1]) {
                    exch(a, in, in + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    //------------------------------------------------------------------
    //---------- Below is an implementation of Insertion Sort ----------
    //------------------------------------------------------------------
    public static void InsertionSort(long[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                exch(a, j, j - 1);
            }
        }
    }

    //------------------------------------------------------------
    //---- TODO: Complete the implementation of Selection Sort ---
    //------------------------------------------------------------
    public static void SelectionSort(long[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // j must start from i + 1, because the numbers at index i and below are
                // already sorted
                if (a[j] < a[i]) {
                    // the current j is less than the i number in the array,
                    // exchange them
                    exch(a, i, j);
                }
            }
        }
    }

    //-----------------------------------------------------------------------
    //---------- Below is an implementation of recursive MergeSort ----------
    //-----------------------------------------------------------------------
    public static void MergeSort(long[] a) {
        long[] aux = new long[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(long[] a, long[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(long[] a, long[] aux, int lo, int mid, int hi) {
        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        // merge back to a[]
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[j] < aux[i]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    //-------------------------------------------------------------
    //---------- Below is an implementation of Quicksort ----------
    //-------------------------------------------------------------
    public static void QuickSort(long[] a) {
        QuickSort(a, 0, a.length - 1);
    }

    private static void QuickSort(long[] a, int left, int right) {
        if (right - left <= 0)
            return;
        int pIdx = partition(a, left, right, right);    // always uses the right end element as pivot
        QuickSort(a, left, pIdx - 1);
        QuickSort(a, pIdx + 1, right);
    }

    private static int partition(long[] a, int left, int right, int pIdx) {
        long pivot = a[pIdx];
        exch(a, pIdx, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (a[i] <= pivot)
                exch(a, i, storeIndex++);
        }
        exch(a, right, storeIndex);
        return storeIndex;
    }

    //-----------------------------------------------------------------------
    // TODO: Implement Optimized Quicksort below (see A4 handout for details)
    //-----------------------------------------------------------------------
    public static void QuickSortOptimized(long[] a) {
        for (int i = 0; i < a.length; i++) {
            int randomInt = i + (int) (Math.random() * (a.length - 1)); // generates a random number and adds it to i
            if (randomInt < a.length) {
                // if the random number is smaller than the length of the array,
                // exchange the element at index i with the element at the index of the random number
                exch(a, randomInt, i);
            }
        }
        QuickSortOptimized(a, 0, a.length - 1);
    }

    private static void QuickSortOptimized(long[] a, int left, int right) {
        if (right - left <= 5) {
            //when the number of elements in the list is 5 or lower, the array will be sorted using insertion sort
            InsertionSort(a);
            return;
        }
        int pIdx = partition(a, left, right, right);
        QuickSortOptimized(a, left, pIdx - 1); // recursive call similar to regular QuickSort method

    }

    //---------------------------------------------------------------------------
    // TODO: Implement Non-Recursive MergeSort below (see A4 handout for details)
    //---------------------------------------------------------------------------
    public static void MergeSortNonRec(long[] a) {
        int lo = 0;
        int hi = a.length - 1;

        long[] aux = new long[a.length]; // initializing empty auxiliary array

        for (int i = 1; i <= hi -lo; i *= 2) {
            // first loop will divide the array into sub arrays the size of i.

            // The next i is equal to i * 2 , because the sub arrays with i elements in them have already been sorted.
            // Now the method will merge & sort elements in sub arrays with i *2 elements and so on until the loop is finished
            // and the entire array of a is sorted.
            for (int j = lo; j < hi; j += 2*i) {
                int left = j; // left is always equal to the current j because the elements with an index below j have
                // already been merged and sorted in sub arrays of size i.
                int mid = j + i - 1; // the middle is equal to the left element plus i -1
                // ex: If i = 2 ( the sub arrays contain 2 elements in them) and j = 0 (the first sub array of size 2 is being created),
                // the middle will be 0 + 2 - 1 = 1.
                int right;
                if(j + 2 *i -1 < hi){
                    right = j + 2 *i -1;
                    // The hi parameter of the merge method must be equal to j + 2 *i -1, because we want to copy
                    // i * 2 elements on to the auxiliary array in order to merge. We add j to 2*1 because we want to start
                    // copying from the element at index j. We subtract 1 because the for loop that copies the elements in the
                    // merge method starts from index lo and ends at hi. So in the case of i = 2, j = 0, merge will copy
                    // elements starting from index 0 all the way to index 3. The method will then be able to merge the
                    // sub arrays of size i = 2. The sub array from index 0 to 1 and the sub array from index 2 to 3.
                    //
                } else{
                    // Otherwise, we must be at the end of the array so the hi parameter in the merge method will just be
                    // the index of the last element in the array.
                    right = hi;
                }

                merge(a,aux,left,mid,right); // merges the sub array
            }
        }


    }




    //---------------------------------------------------------------------
    // TODO: Apply MergeSort to the Linked List (see A4 handout for details)
    //---------------------------------------------------------------------
    public static void MergeSortLL(MyLinkedList list) {
        // Uncomment below when you implement mergeSort() in class MyLinkedList
         list.mergeSort();
    }

    //------------------------------------------------------
    //---------- Below are several helper methods ----------
    //------------------------------------------------------
    // This tests whether your sorted result is correct by comparing it to reference result
    public static boolean testSort(long[] a) {
        long[] a2 = new long[a.length];
        System.arraycopy(a, 0, a2, 0, a.length);
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++)
            if (a2[i] != a[i])
                return false;
        return true;
    }

    // This creates an array with n randomly generated elements between (0, n*10]
    private static long[] randArray(int n) {
        long[] rand = new long[n];
        for (int i = 0; i < n; i++)
            rand[i] = (int) (Math.random() * n * 10);
        return rand;
    }

    // This creates an ordered array with n elements in ascending order
    private static long[] orderedArray(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = i + 1;
        return arr;
    }

    // This method copies the elements from an array to a linked list
    private static void copyArrayToLinkedList(long[] arr, MyLinkedList list) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            list.addLast(arr[i]);
        }
    }

    private static void startTimer() {
        timestamp = System.nanoTime();
    }

    private static double endTimer() {
        return (System.nanoTime() - timestamp) / 1000000.0;
    }

    // Exchange a[i] and a[j]
    private static void exch(long[] a, int i, int j) {
        long swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static long timestamp;

    //---------------------------------------------
    //---------- This is the main method ----------
    //---------------------------------------------
    public static void main(String[] args) {
        
        // TODO: set this flag to true when you want to test your
        // methods with an ordered array (corner case!)
        boolean useOrderedArray = true;

        // run experiments
        final int BUBBLE = 0, SELECT = 1, INSERT = 2, QUICK = 3, QUICKOPT = 4, MERGEREC = 5, MERGENONREC = 6, MERGELINKEDLIST = 7;
        int[] algorithms = {BUBBLE, SELECT, INSERT, MERGEREC, MERGENONREC, MERGELINKEDLIST, QUICK, QUICKOPT};

        // max defines the maximum size of the array to be tested, which is 2^max
        // runs defines the number of rounds to be performed per test, in order to get an average running time.
        int max = 14, runs = 5;
        double[][] stats = new double[algorithms.length][max];
        MyLinkedList list; //for MergeSortLL
        for(int i=0; i < algorithms.length; i++) {  //loop through each sorting algorithm
            switch(i) {
                case BUBBLE: System.out.print("Running Bubble Sort ..."); break;
                case SELECT: System.out.print("Running Selection Sort ..."); break;
                case INSERT: System.out.print("Running Insertion Sort ..."); break;
                case QUICK: System.out.print("Running Quicksort..."); break;
                case QUICKOPT: System.out.print("Running Optimized Quicksort..."); break;
                case MERGEREC: System.out.print("Running MergeSort Recursive ..."); break;
                case MERGENONREC: System.out.print("Running MergeSort Non Recursive ..."); break;
                case MERGELINKEDLIST: System.out.print("Running MergeSort for Linked List ..."); break;
            } //end of switch
            for(int j = 0; j < max; j++) { //loop through each array size
                double avg = 0;
                for(int k = 0; k < runs; k++) { //loop through each run
                    int n = (int) Math.pow(2, j+1);
                    long[] a;
                    if(useOrderedArray){ a = orderedArray(n); }
                    else { a = randArray(n); }

                    list = new MyLinkedList(); //for MergeSortLL
                    copyArrayToLinkedList(a, list); //for MergeSortLL

                    startTimer();
                    switch(i) {
                        case BUBBLE: BubbleSort(a); break;
                        case SELECT: SelectionSort(a); break;
                        case INSERT: InsertionSort(a); break;
                        case MERGEREC: MergeSort(a); break;
                        case MERGENONREC: MergeSortNonRec(a); break;
                        case MERGELINKEDLIST: MergeSortLL(list); break;
                        case QUICK: QuickSort(a); break;
                        case QUICKOPT: QuickSortOptimized(a); break;
                    }
                    avg += endTimer();
                    // if this was MergeSortLL, copy list back to array
                    if( i == MERGELINKEDLIST ) a = list.toArray();

                    if (testSort(a) == false)
                        System.out.println("The sorting is INCORRECT!" + "(N=" + a.length + ", round=" + k + ").");
                }//end of k runs
                avg /= runs;
                stats[i][j] = avg;
            }//end of max array sizes
            System.out.println("done.");
        }//done running all sorting algorithms!

        DecimalFormat format = new DecimalFormat("0.0000");
        System.out.println();
        System.out.println("Average running time:");
        System.out.println("N\t Bubble Sort\t Selection Sort\tInsertion Sort\tQuickSort\tQuickSortOpt\tMergeSortRec\tMergeSortNon\tMergeSortList");
        for(int i=0; i<stats[0].length; i++) {
            System.out.print((int) Math.pow(2, i+1) + "\t  ");
            for(int j=0; j<stats.length; j++) {
                System.out.print(format.format(stats[j][i]) + "\t  ");
            }
            System.out.println();
        }
      //  */
    }//end of main method

}//end of class

