/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING ANY SOURCES OUTSIDE OF THOSE APPROVED BY THE INSTRUCTOR. [Zac Israel, 2331238]*/
import java.util.Comparator;
public class MaxComparator<K> implements Comparator<K> {
    public int compare(K a, K b) throws ClassCastException {
        return ((Comparable<K>)b).compareTo(a); // opposite of default comparator
    }
}
