import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RandomizedSet {

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
//        boolean param_1 = obj.insert(1);
//        System.out.println("Just inserted 1 "+obj);
//        boolean param_2 = obj.remove(2);
//        boolean param_3 = obj.insert(2);
//        System.out.println("Just inserted 2 "+obj);
//        int param_4 = obj.getRandom();
//        boolean param_5 = obj.remove(1);
//        System.out.println("Just removed 1 "+obj);
//        boolean param_6 = obj.insert(2);
//        System.out.println("Just tried to insert 2 "+obj);
//        int param_7 = obj.getRandom();
//
//        System.out.println(param_1 + ", " + param_2 + ", "+ param_3 + ", " + param_4 + ", " +
//                param_5 + ", " + param_6 + ", " + param_7);

        obj.insert(22);
        System.out.println(obj);
        System.out.println("Random int is "+obj.getRandom());

        obj.insert(65);
        System.out.println(obj);
        System.out.println("Random int is "+obj.getRandom());

        obj.insert(12);
        System.out.println(obj);
        System.out.println("Random int is "+obj.getRandom());


        obj.insert(91);
        System.out.println(obj);
        System.out.println("Random int is "+obj.getRandom());

        obj.insert(39);
        System.out.println(obj);
        System.out.println("Random int is "+obj.getRandom());

        obj.insert(2);
        System.out.println(obj);
        System.out.println("Random int is "+obj.getRandom());

        obj.insert(1);
        System.out.println(obj);
        System.out.println("Random int is "+obj.getRandom());

        obj.insert(71);
        System.out.println(obj);
        System.out.println("Random int is "+obj.getRandom());


    }


    private ArrayList<Integer> set;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        set = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        }
        set.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (set.contains(val)) {
            set.removeAll(Collections.singleton(val));
            return true;

        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {

        if (set.isEmpty()) {
            throw new IndexOutOfBoundsException("The Randomized set is empty.");
        }
        if (set.size() == 1) return set.get(0);

        int rand = (int) (Math.random() * set.size());
        return set.get(rand);

    }

    @Override
    public String toString() {
        return "RandomizedSet{" + set +
                '}';
    }
}
