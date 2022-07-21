/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING ANY SOURCES OUTSIDE OF THOSE APPROVED BY THE INSTRUCTOR. [Zac Israel, 2331238]*/
import java.util.*;

public class TSPMinimumSpanningTree {


    public static ArrayList<Line2D> computeMST(ArrayList<Point2D> points) {
        DisjointSet djs = new DisjointSet();
        return djs.kruskalAlgorithm(points, null);

    }

    public static ArrayList<Line2D> computeDFSTour(ArrayList<Point2D> points, ArrayList<Line2D> mst) {
        return getDFSPath(points, mst);
    }

//      This method uses stack, not recursion to tour around the incoming MST.  The traversal starts a given position
//      and continues until the next node is vertex and related neighbors have been traversed.  The tour is created from
//      the sequence of vertices that are popped from the stack.  If a vertex was previously encountered, it will be
//      skipped
//
    public static ArrayList<Line2D> getDFSPath(ArrayList<Point2D> vertices, ArrayList<Line2D> edges) {
        ArrayList<Point2D> dfsPath  = new ArrayList<>(); //Sequences of vertices to create the tour.  This is populated
        // during DFS
        Map<Point2D, Integer> vertexIndices = getVertexIndices(vertices);
        Map<Integer, Point2D> indexedVertices = getIndexedVertices(vertices);

        int[][] adjacency_matrix = createMSTAdjacencyMatrix(edges, vertexIndices, vertexIndices.size());
        Deque<Point2D> stack = new ArrayDeque<>();


        Point2D vertex = edges.get(0).getP1();
        stack.add(vertex);

        dfsStack(vertex,
                adjacency_matrix,
                dfsPath,
                vertexIndices,
                indexedVertices);

        //Create the sequence of edges
        ArrayList<Line2D> tour = new ArrayList<>();
        for (int i = 1; i < dfsPath.size(); i++) {
            Line2D edge = new Line2D(dfsPath.get((i-1)), dfsPath.get(i));


            tour.add(edge);

        }

        //Add last edge if necessary
        if (dfsPath.size() > 2) {
            tour.add(new Line2D(dfsPath.get(dfsPath.size() - 1), dfsPath.get(0)));
        }
        return tour;
    }



    public static void dfsStack(Point2D vertex,
                                int[][] adjacency_matrix,
                                ArrayList<Point2D> dfsPath,
                                Map<Point2D, Integer> vertexIndices,
                                Map<Integer, Point2D> indexedVertices) {

        Deque<Point2D> stack = new ArrayDeque<>();

        stack.add(vertex);

        while (!stack.isEmpty()) {
            vertex = stack.pop();
            if (!dfsPath.contains(vertex)) {
                dfsPath.add(vertex);
            }

            ArrayList<Integer> neighbors = findNeighbours(vertexIndices.get(vertex), adjacency_matrix);
          //  System.out.println("neighbor size:  " + neighbors.size());
            for (int neighborIndex : neighbors) {
                Point2D neighbor = indexedVertices.get(neighborIndex);
                if (!dfsPath.contains(neighbor)) {
                   // System.out.println("Neighbor with index " + neighborIndex + " has not been visited");
                    stack.add(neighbor);
                } else {
//                    System.out.println("The vertex with index " + neighborIndex +
//                            " has been visited and will not be added to the stack");
                }
            }

        }

    }


//     This method is used to return all the neighbors for a give vertex
//     @param sourceVertexIndex  - The index of the vertex in the incoming array list of vertices passed to the MST method
//
//     @param adjacency_matrix - The adjacency matrix build to capture connections of vertices where a connection  is indicated by a value of 1 in the matrix.
//
//     @return - An array list of vertex indices

    public static ArrayList<Integer> findNeighbours(int sourceVertexIndex, int[][] adjacency_matrix) {

        ArrayList<Integer> neighbors = new ArrayList<>();

        if(sourceVertexIndex >= 0 && sourceVertexIndex < adjacency_matrix.length) {
            for (int j = 0; j < adjacency_matrix[sourceVertexIndex].length; j++) {
                if(adjacency_matrix[sourceVertexIndex][j] == 1) neighbors.add(j);
            }
        }
        return neighbors;
    }


    // Helper method used to get the indices of the vertices
    private static Map<Point2D, Integer> getVertexIndices(ArrayList<Point2D> points) {
        Map<Point2D, Integer> vertexIndices = new HashMap<>();
        for (int i = 0; i < points.size(); i++) {
            vertexIndices.put(points.get(i), i);
        }

        return vertexIndices;
    }

    // Helper method used to retrieve the vertices of the indices
    private static Map<Integer, Point2D> getIndexedVertices(ArrayList<Point2D> points) {
        Map<Integer, Point2D> indexedVertices = new HashMap<>();
        for (int i = 0; i < points.size(); i++) {
            indexedVertices.put(i, points.get(i));
        }

        return indexedVertices;
    }


    private static ArrayList<Line2D> createSortedEdges(ArrayList<Point2D> points) {
        ArrayList<Line2D> edges = new ArrayList<>();

        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                if (i == j) continue;
                else edges.add(new Line2D(points.get(i), points.get(j)));
            }
        }
        Collections.sort(edges, new EdgeComparator());

        return edges;
    }


    // Inner class used to compare the edges
    public static class EdgeComparator implements Comparator<Line2D> {

        @Override
        public int compare(Line2D edge1, Line2D edge2) {
            return Double.compare(edge1.getP1().distance(edge1.getP2()),
                    edge2.getP1().distance(edge2.getP2()));
        }
    }



    public static int[][] createMSTAdjacencyMatrix(ArrayList<Line2D> mst, Map<Point2D, Integer> vertexIndices, int size) {
        int[][] adjacencyMatrix = new int[size][size];


        for (int i = 0; i < mst.size(); i++) {
            Line2D edge = mst.get(i);
            int p1Index = vertexIndices.get(edge.getP1());
            int p2Index = vertexIndices.get(edge.getP2());

            adjacencyMatrix[p1Index][p2Index] = 1; //Indicator for a connection between two points
            adjacencyMatrix[p2Index][p1Index] = 1;

        }

        return adjacencyMatrix;
    }


     // Disjoint class to help implement Kruskal's algorithm

    public static class DisjointSet {
        Map<Integer, Integer> parent = new HashMap<>();

        public void makeSet(int N) {
            for (int i = 0; i < N; i++)
                parent.put(i, i);
        }

        private int find(int k) {
            if (parent.get(k) == k)
                return k;

            return find(parent.get(k));
        }

        private void Union(int first, int second) {
            int x = find(first);
            int y = find(second);

            parent.put(x, y);
        }

        public ArrayList<Line2D> kruskalAlgorithm(ArrayList<Point2D> vertices, List<Line2D> edges) {
            Map<Point2D, Integer> vertexIndices = getVertexIndices(vertices);
            int numVertices = vertices.size();

            List<Line2D> sortedEdges = edges;
            if (sortedEdges == null) {
                sortedEdges = new ArrayList<>();
            }
            if (sortedEdges.isEmpty()) {
                sortedEdges = createSortedEdges(vertices);
            } else {
                Collections.sort(sortedEdges, new EdgeComparator());
            }

            ArrayList<Line2D> mstEdges = new ArrayList();

            DisjointSet ds = new DisjointSet();
            ds.makeSet(numVertices);

            int index = 0;

            // Create all edges
            while (mstEdges.size() != numVertices - 1) {

                Line2D currentEdge = sortedEdges.get(index++);  //Get the next shortest edge


                int vertex1Index = vertexIndices.get(currentEdge.getP1());
                int vertex2Index = vertexIndices.get(currentEdge.getP2());
                int x = ds.find(vertex1Index);
                int y = ds.find(vertex2Index);

                if (x != y) {
                    mstEdges.add(currentEdge);
                    ds.Union(x, y);
                }
            }
            return mstEdges;
        }
    }

}

