/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING ANY SOURCES OUTSIDE OF THOSE APPROVED BY THE INSTRUCTOR. [Zac Israel, 2331238]*/
import java.security.KeyStore;
import java.util.*;

public class SelfBalancingTreeSet<K> extends TreeSet<K> {
    //your implementation goes here
    // Splay tree

    public SelfBalancingTreeSet() {
        super();
    }

    public SelfBalancingTreeSet(Comparator<K> comp) {
        super(comp);
    }

    private void splay(Position<K> p) {
        while (!isRoot(p)) {
            Position<K> parent = parent(p);
            Position<K> grand = parent(parent);
            if (grand == null) {
                rotate(p);
            } else if ((parent == left(grand)) == (p == left(parent))) {
                rotate(parent);
                rotate(p);
            } else {
                rotate(p);
                rotate(p);
            }
        }
    }

    protected void rebalanceInsert(Position<K> p) {
        splay(p);
    }

    protected void rebalanceDelete(Position<K> p) {
        if (!isRoot(p)) {
            splay(parent(p));
        }
    }

    protected void rebalanceAccess(Position<K> p) {
        if (isExternal(p)) {
            p = parent(p);
        }
        if (p != null) {
            splay(p);
        }
    }

}