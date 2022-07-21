import java.util.Stack;
/*THIS CODE WAS OUR OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS
OR COPIED FROM ONLINE RESOURCES. Zac Israel*/

public class BSTIndex {

    private class Node {
        private String key;
        private MovieInfo data;
        private Node left, right;

        public Node(MovieInfo info) {
            data = info;
            key = data.shortTitle;
        }
    }

    private Node root;

    public BSTIndex() {
        root = null;
    }

    // --------- [DO NOT MODIFY!] public BST methods  --------- //
    /* Important: Notice that each public method here calls another private method while passing it a reference to the tree root. This is a common way of structuring BST functions such that external client code will not have direct access to the tree root. You will be implementing the code in the private methods, not the public ones. */

    /* Calculate and return the height of the current tree. */
    public int calcHeight() {
        return calcNodeHeight(this.root);
    }

    /* Insert the given data element into the proper place in the BST structure. */
    public void insertMovie(MovieInfo data) {
        root = insertMovie(data, this.root);
    }

    /* Find and return the data element (i.e. the MovieInfo object)
    of the node where the movie's shortTitle matches the given key.
    Return null if the movie is not found. */
    public MovieInfo findMovie(String key) {
        return findMovie(this.root, key);
    }

    /* Print out all movies in the database whose shortTitle begins with
    the passed prefix string. If no movies match the given prefix, nothing
    will be printed. The order of printing does not matter, but make sure
    to print each match in a separate line. */
    public void printMoviesPrefix(String prefix) {
        printMoviesPrefix(this.root, prefix);
    }
    // ----------------- end of public methods ------------------ //


    // ------------- [TODO] private BST methods --------------- //
    private int calcNodeHeight(Node t) {
        // ... TODO ... //
        int rightCounter = 0; // keeps track of the count going right of the root
        int leftCounter = 0; // keeps track of the count going left of the root

        if (t.right != null) {  // if the right reference is not equal to null
            // set the rightCounter equal to the  recursive call of the right reference

            rightCounter = calcNodeHeight(t.right);
        }
        if (t.left != null) { // if the left reference is not equal to null

            // set the leftCounter equal to the recursive call of the left refernce
            leftCounter = calcNodeHeight(t.left);

        }

        // returns the highest between the two
        if (leftCounter > rightCounter) {
            return 1 + leftCounter;
        } else {
            return 1 + rightCounter;
        }

    }

    private Node insertMovie(MovieInfo data, Node t) {
        // ... TODO ... //
        if(t == null){
            // if t == null, return a new Node with the data as the parameter
            return new Node(data);
        }

       if(data.shortTitle.compareTo(t.key) == 0){
           // if the short title is the same as the key as the node t, return Node t
           return t;
       }
       if(data.shortTitle.compareTo(t.key) < 0){
           // if the short title of the data alphabetically comes after the key value of the node,
           // set the left node of the t node = to this method but with the left node as the t parameter
           t.left = insertMovie(data, t.left);
       } else{
           t.right = insertMovie(data, t.right);
           // Otherwise, set the right node of the t node = to this method but with the right node as the t parameter
       }
       return t;
    }

    private MovieInfo findMovie(Node t, String key) {
        // ... TODO ... //
        if (t == null){
            return null;
        }
        if(key.compareTo(t.data.shortTitle) == 0) {
            // if the key is equal to the current node t's shortTitle,
            // return the data of the t node.
            return t.data;
        }
        if(key.compareTo(t.data.shortTitle) < 0){
            // if the key is alphabetically less than the t node's short title,
            // run this method with the left node as the parameter
            return findMovie(t.left, key);
        } else{
            // Otherwise, run this method with the right node as the parameter
            return findMovie(t.right, key);
        }
    }

    private void printMoviesPrefix(Node t, String prefix) {
        if(t == null){
            return;
        }
       if(t.key.startsWith(prefix.substring(0, prefix.length()-1))){
           // the substring of the prefix takes off the "*" from the user input
           System.out.println(t.data.fullTitle); // prints the fullTitle of the movie if the movie startsWith the prefix
       }
       printMoviesPrefix(t.left, prefix); // recursive call for the left node
       printMoviesPrefix(t.right, prefix); // recursive call for the right node
    }

}

