/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING ANY SOURCES OUTSIDE OF THOSE APPROVED BY THE INSTRUCTOR. [Zac Israel, 2331238]*/
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class TreeSet<K> implements Set<K>, PriorityQueue<K> {
    protected LinkedBinaryTree<K> tree = new LinkedBinaryTree<>();
    private Comparator<K> comp;

    public TreeSet() {
        this(new DefaultComparator<K>());
    }

    public TreeSet(Comparator<K> comp) {
        this.comp = comp;
        tree.addRoot(null);
    }

    public int size() {
        return (tree.size() - 1) / 2;
    }

    /**
     * Utility used when inserting a new entry at a leaf of the tree
     */
    private void expandExternal(Position<K> p, K key) {
        tree.set(p, key);
        tree.addLeft(p, null);
        tree.addRight(p, null);
    }

    protected int compare(K a, K b) {
        return comp.compare(a, b);
    }

    protected Position<K> root() {
        return tree.root();
    }

    protected Position<K> parent(Position<K> p) {
        return tree.parent(p);
    }

    protected Position<K> left(Position<K> p) {
        return tree.left(p);
    }

    protected Position<K> right(Position<K> p) {
        return tree.right(p);
    }

    protected Position<K> sibling(Position<K> p) {
        return tree.sibling(p);
    }

    protected boolean isRoot(Position<K> p) {
        return tree.isRoot(p);
    }

    protected boolean isExternal(Position<K> p) {
        return tree.isExternal(p);
    }

    protected boolean isInternal(Position<K> p) {
        return !isExternal(p);
    }

    protected void set(Position<K> p, K e) {
        tree.set(p, e);
    }

    protected K remove(Position<K> p) {
        return tree.remove(p);
    }

    protected void rotate(Position<K> p) {
        tree.rotate(p);
    }

    protected Position<K> restructure(Position<K> x) {
        return tree.restructure(x);
    }

    public BinaryTree<K> getTree() {
        return tree;
    }

    private Position<K> treeSearch(Position<K> p, K key) {
        if (isExternal(p))
            return p;
        int comp = compare(key, p.getElement());
        if (comp == 0)
            return p;
        else if (comp < 0)
            return treeSearch(left(p), key);
        else
            return treeSearch(right(p), key);
    }

    protected Position<K> treeMin(Position<K> p) {
        Position<K> walk = p;
        while (isInternal(walk))
            walk = left(walk);
        return parent(walk);
    }

    protected Position<K> treeMax(Position<K> p) {
        Position<K> walk = p;
        while (isInternal(walk))
            walk = right(walk);
        return parent(walk);
    }

    public boolean contains(K key) throws IllegalArgumentException {
        Position<K> p = treeSearch(root(), key);
        rebalanceAccess(p);
        return !isExternal(p);
    }

    public boolean put(K key) throws IllegalArgumentException {
        Position<K> p = treeSearch(root(), key);
        if (isExternal(p)) {
            expandExternal(p, key);
            rebalanceInsert(p);
            return true;
        }
        return false;
    }

    public K remove(K key) throws IllegalArgumentException {
        Position<K> p = treeSearch(root(), key);
        if (isExternal(p)) {
            rebalanceAccess(p);
            return null;
        } else {
            K old = p.getElement();
            if (isInternal(left(p)) && isInternal(right(p))) {
                Position<K> replacement = treeMax(left(p));
                set(p, replacement.getElement());
                p = replacement;
            }
            Position<K> leaf = (isExternal(left(p)) ? left(p) : right(p));
            Position<K> sib = sibling(leaf);
            remove(leaf);
            remove(p);
            rebalanceDelete(sib);
            return old;
        }
    }

    public void insertList(ArrayList<K> list) {
        for (K key : list) put(key);
    }

    protected void rebalanceInsert(Position<K> p) {
    }

    protected void rebalanceDelete(Position<K> p) {
    }

    protected void rebalanceAccess(Position<K> p) {
    }

    public ArrayList<K> inOrder() {
        ArrayList<K> list = new ArrayList<>();
        placeInOrder(list, root());
        return list;
    }

    protected void placeInOrder(ArrayList<K> output, Position<K> node) {
        if (!isExternal(left(node))) {
            placeInOrder(output, left(node));
        }
        output.add(node.getElement());
        if (!isExternal(right(node))) {
            placeInOrder(output, right(node));
        }
    }


    public K min() {

        if (tree.isEmpty()) {
            throw new IllegalStateException("The tree is empty.");
        }
        if (isEmpty()) {
            System.out.println("The tree is empty, the root has no key. Therefore, there is no minimum node.");
        }
        LinkedBinaryTree.Node<K> curr = tree.root;
       // System.out.println("The root of the tree is " + curr.getElement());
        while (curr.getLeft() != null && curr.getLeft().getElement() != null) {
            // iterate to the left most node in the tree to find the minimum
          //  System.out.println("Iterating to the left child " + curr.getLeft().getElement());
            curr = curr.getLeft();
        }
       // System.out.println("The minimum element is " + curr.getElement());
        return curr.getElement(); // return the element of the minimum node
    }

    public K removeMin() {
        if (tree.isEmpty()) {
            throw new IllegalStateException("The tree is empty.");
        }

        if(isEmpty()) {
            System.out.println("The tree is empty, there are no nodes to remove.");
            return null;

        }
        LinkedBinaryTree.Node<K> min = null;
        LinkedBinaryTree.Node<K> curr = tree.root;
        while (curr != null && curr.getElement() != null) {
            // Iterate to the left most node in the tree to find the minimum
            min = curr;
            curr = curr.getLeft();
        }

        rebalanceDelete(min); // splays minimum node to the root


        // Below are all od the different edge cases when removing a node: if the minimum node has two children (either two external nodes
        // or one external child and one internal node ), at least one must be removed before removing the minimum node because
        // you cannot delete a node with two children.


        if (tree.isRoot(min)) { // if the root is the smallest node, meaning there left subtree is just an external node
            if (min.getLeft() == null && min.getRight() == null) {
                // if the root has no children
                tree.set(root(), null);
            } else if(min.getLeft() == null && min.getRight() != null){
                // root has no left child & has a right child
                tree.remove(min);

            } else if(min.getLeft()!= null && min.getLeft().getElement() == null && min.getRight().getElement() == null){
                // if the root just has external nodes for children
                tree.remove(min.getLeft());
                tree.remove(min.getRight());
                tree.set(root(), null);

            }
            else if(min.getLeft().getElement() == null && min.getRight().getElement() != null ){
                // root's left child is external, root's right child has an element != null
                tree.remove(min.getLeft());
                tree.remove(min);

            } else if(min.getRight().getElement() == null){
                tree.set(root(),null);
            }

        } else if(min.getLeft() == null && min.getRight() == null){
            // minimum node has no children
            tree.remove(min);
        }else if(min.getLeft() == null && min.getRight() != null){
            // minimum node has a right child but no left child
            tree.remove(min);
        }else if(min.getLeft().getElement() == null && min.getRight().getElement() != null){
            // minimum node has an external node for a left child and a node with an element != null for a right child
            tree.remove(min.getLeft());
            tree.remove(min);
        } else if(min.getLeft().getElement() == null && min.getRight().getElement() == null) {
            // minimum node has two eternal nodes as children
            tree.remove(min.getLeft());
            tree.remove(min.getRight());
            tree.remove(min);
        } else{
            tree.remove(min);
        }
        return min.getElement(); // return the element of the minimum node
    }

    public void insert(K key) {
        if (isEmpty()) {
            tree.set(root(), key);
        } else {
            LinkedBinaryTree.Node<K> curr = tree.root;

            while (curr != null) { // while the current node is not equal to null

                if (compare(curr.getElement(), key) > 0) { // if the key is less than the current node's element,
                    if (curr.getLeft() == null) {
                        // if the current node's left child is null,
                        tree.addLeft(curr, key);// add a new node with the key as the left child of the current node.
                        break; // break out of the loop
                    }
                    // otherwise, iterate to the current node's left child
                    curr = curr.getLeft();
                }

                if (compare(curr.getElement(), key) < 0) { // if the key is greater than the current node's element,
                    if (curr.getRight() == null) {
                        // if the current node's right child is null,
                        // add a new node with the key as the right child of the current node.
                        tree.addRight(curr, key);
                        break; // break out of the loop
                    }
                    // otherwise, iterate to the current node's right child
                    curr = curr.getRight();
                }

            }
            return; // if the key is equal to the current element

        }

    }

    public boolean isEmpty() {
        return tree.root.getElement() == null;
    }


    public static void main(String[] args) {

        Integer[] testKeys = new Integer[]{15, 19,22, 0, 7, 14, 12, 3,32,43,51};

        TreeSet<Integer> treeSet = new TreeSet<>();

        for(Integer n: testKeys){
            treeSet.insert(n);
            System.out.println("Just added " + n + " to the tree.");
            System.out.println("The root of the tree is now " + treeSet.root().getElement() + "\n");
        }

        int size = treeSet.tree.size();

        for(int i = 0; i < size; i++){
            System.out.println("The minimum node is " + treeSet.min());
            treeSet.removeMin();
            System.out.println("Just removed the minimum element. The minimum element is now " + treeSet.min());
            System.out.println("The root of the tree is now " + treeSet.root().getElement() + "\n");
        }
    }

}

