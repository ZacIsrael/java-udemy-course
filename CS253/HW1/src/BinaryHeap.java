/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING ANY SOURCES OUTSIDE OF THOSE APPROVED BY THE INSTRUCTOR. [Zac Israel, 2331238]*/
import java.util.ArrayList;
import java.util.Comparator;
public class BinaryHeap<K> extends Heap<K> {
    private Comparator<K> comp;
    public BinaryHeap(){
        this(new DefaultComparator<K>());
    }
    public BinaryHeap(Comparator<K> comp){
        array = new ArrayList<>();
        this.comp = comp;
    }


      private void swap(int i, int j){
        K test = array.get(i);
        array.set(i, array.get(j));
        array.set(j, test);
      }

     private int root(){
        return 0;
     }

     private int left(int i){
        return 2 * i + 1;
     }
     private int right(int i){
        return 2 * i + 2;
     }
     private int parent(int i){
        return (i-1)/2;
     }
     public boolean hasLeft(int i){
        return left(i) < array.size();
     }
     public boolean hasRight(int i){
        return right(i) < array.size();
     }

     private void sink(int i){
       while(hasLeft(i)){
           int leftIndex = left(i);
           int smallChildIndex = leftIndex;
           if(hasRight(i)){
               int rightIndex = right(i);
               if(comp.compare(array.get(leftIndex), array.get(rightIndex)) > 0){ // right child is smaller
                   smallChildIndex = rightIndex;
               }
           }
           if(comp.compare(array.get(smallChildIndex), array.get(i)) >= 0){
               break;
           }
           swap(i, smallChildIndex);
           i = smallChildIndex;
       }



     }
     private void swim(int i){
        while(i > 0){
            int test = parent(i);
            if(comp.compare(array.get(i),array.get(test)) >= 0) break;
            swap(i, test);
            i = test;
        }
     }

    public void insert(K k){
        array.add(k);
        swim(array.size()-1);
    }
    public K removeMin(){
        if(isEmpty()){
            return null;
        } else{
            K tempRoot = array.get(0);
            array.set(0, array.get(size() - 1));
            array.remove(array.get(array.size()-1));
            sink(0);
            return tempRoot;

        }

    }
    public K min(){
        if(array.isEmpty()){
            return null;
        }
        return array.get(0);
    }


    @Override
    public String toString() {
        return "{" + array +
                '}';
    }

    public static void main(String[] args) {
        BinaryHeap<Integer> ternaryHeap = new BinaryHeap<>();
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
        ternaryHeap.removeMin();
        System.out.println(ternaryHeap);
        ternaryHeap.removeMin();
        System.out.println(ternaryHeap);

    }
}
