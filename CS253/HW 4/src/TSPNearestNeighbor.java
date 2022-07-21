/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING ANY SOURCES OUTSIDE OF THOSE APPROVED BY THE INSTRUCTOR. [Zac Israel, 2331238]*/
import java.util.*;

public class TSPNearestNeighbor {


//      This method iterates over a list points to determine which position is optimal.
//      However, it would suffice to use a random starting point or one specific point.

    public static ArrayList<Line2D> computeNearestNeighbor(ArrayList<Point2D> vertices) {
        ArrayList<Line2D> neighbors = new ArrayList<>();

        // Make a copy of the incoming list
        ArrayList<Point2D> vertexCopies = new ArrayList<>();
        vertexCopies.addAll(vertices);

        //This data structure is used in order to find a vertex's nearest neighbor
        PriorityQueue<Line2D> priorityQueue = new PriorityQueue<>(new EdgeComparator());

        //Remove the first element from the list and find its nearest neighbor from the list
        Point2D currentVertex = vertexCopies.get(0);
        vertexCopies.remove(0);

        //Counter used only in log statement to display the position of each vertex when display the internal details of
        //the priority queue has has all the edges connected to point in queue.  This a way to verify the shortest path
        //found
        int counter = 0;
        while (neighbors.size() < vertices.size() - 1) {
            int currentVertexIndex = -1;

            for (int i = 0; i< vertexCopies.size(); i++) {
                //Find the index of the current vertex in order to remove it from the list
                if (vertexCopies.get(i).equals(currentVertex)) {
                    currentVertexIndex = i;
                } else {
                    Line2D edge = new Line2D(currentVertex, vertexCopies.get(i));
                    priorityQueue.add(edge);
                }
            }

            // If the index is greater than 0, i.e. not -1, remove it from the list and its neighbor in the next
            // iteration of the loop.
            if (currentVertexIndex >=0)
                vertexCopies.remove(currentVertexIndex);

            Line2D shortestEdge = priorityQueue.peek();
            neighbors.add(shortestEdge);
            currentVertex = shortestEdge.getP2();

            priorityQueue.clear();
        }

        // This is the edge which connects to the origin vertex
        Line2D lastEdge = new Line2D(currentVertex, vertices.get(0));
        neighbors.add(lastEdge);

        return neighbors;
    }

    public static class EdgeComparator implements Comparator<Line2D> {

        @Override
        public int compare(Line2D edge1, Line2D edge2) {
            return Double.compare(edge1.getP1().distance(edge1.getP2()),
                    edge2.getP1().distance(edge2.getP2()));
        }
    }
}

