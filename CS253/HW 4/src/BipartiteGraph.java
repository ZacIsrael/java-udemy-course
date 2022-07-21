/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING ANY SOURCES OUTSIDE OF THOSE APPROVED BY THE INSTRUCTOR. [Zac Israel, 2331238]*/
import java.util.ArrayList;
import java.util.HashMap;
public class BipartiteGraph {
	// to get the edges incident with a vertex v, just call adjacencyMap.get(v)
    private HashMap<Vertex, ArrayList<Edge>> adjacencyMap;
    private ArrayList<Vertex> leftVertices;
    private ArrayList<Vertex> rightVertices;
    public BipartiteGraph(int nLeft, int nRight, ArrayList<int[]> edges){
        leftVertices = new ArrayList<>();
        rightVertices = new ArrayList<>();
        adjacencyMap = new HashMap<>();
        for (int i = 0; i < nLeft; i++){
            Vertex v = new Vertex(i, true);
            leftVertices.add(v);
            adjacencyMap.put(v, new ArrayList<Edge>());
        }
        for (int i = 0; i < nRight; i++){
            Vertex v = new Vertex(i, false);
            rightVertices.add(v);
            adjacencyMap.put(v, new ArrayList<Edge>());
        }
        for (int[] edge : edges){
            Vertex u = leftVertices.get(edge[0]);
            Vertex v = rightVertices.get(edge[1]);
            Edge e = new Edge(leftVertices.get(edge[0]), rightVertices.get(edge[1]));
            adjacencyMap.get(u).add(e);
            adjacencyMap.get(v).add(e);
        }
    }
    public ArrayList<Vertex> getVertices(){
        ArrayList<Vertex> verts = new ArrayList<>();
        for (Vertex v : leftVertices)
            verts.add(v);
        for (Vertex v : rightVertices)
            verts.add(v);
        return verts;
    }
    public ArrayList<Edge> getEdges(){
        ArrayList<Edge> edgeList = new ArrayList<>();
        for (Vertex v : leftVertices){
            for (Edge e : adjacencyMap.get(v)){
                edgeList.add(e);
            }
        }
        return edgeList;
    }
    public boolean augmentFlow(ArrayList<Edge> augmentingPath){
        if (augmentingPath == null || augmentingPath.size() == 0){
            return false;
        }
        for (int i = 0; i < augmentingPath.size(); i++){
            if ((i%2==0) == augmentingPath.get(i).isInMatching()){
				// just a sanity check to make sure it alternates blue/red
                return false;
            }
        }
		//as long as the order of the edges is correct, augmenting a flow
		//can be done in this way
        for (int i = 0; i < augmentingPath.size(); i++){
            augmentingPath.get(i).setInMatching(i%2==0);
        }
        return true;
    }


    public ArrayList<Edge> findAugmentingPath(){

        //insert your implementation here
        ArrayList<Edge> augmentedPath = new ArrayList<>(); // augmentedPath
        ArrayList<Edge> edges = getEdges(); // array list to store all of the edges in tne graph
        int size = augmentedPath.size();
        ArrayList<Edge> inMatching = new ArrayList<>(); // array list used to store the the edges that are inMatching

        for (int i = 0; i < size; i++) {
            if (edges.get(i).isInMatching()) inMatching.add(edges.get(i));
            // if the current edge's inMatching value is set to true, add this edge to the inMatching array list
        }

        // keeps track of what right vertices have an edge or not; initially all are false
        HashMap<Vertex, Boolean> map = new HashMap<>();
        for (int i = 0; i < rightVertices.size(); i++) map.put(rightVertices.get(i), false);



        ArrayList<Edge> notMatching = new ArrayList<>(); // used to store the edges that are not currently inMatching
        for (int i = 0; i < edges.size(); i++) {
            if (!edges.get(i).isInMatching()) notMatching.add(edges.get(i));
        }


        for (int i = 0; i < leftVertices.size(); i++) {
            // iterates through all of the vertices and gives each one an edge
            ArrayList<Edge> vertexEdges = adjacencyMap.get(leftVertices.get(i));
            for (int j = 0; j < vertexEdges.size(); j++) {
                if (!notMatching.contains(vertexEdges.get(j))) vertexEdges.remove(vertexEdges.get(j));
                // if the notMatching array list does not contain the current edge in the vertex edges array list,
                // remove this edge from the the vertexEdges array list
            }
            for (int k = 0; k < vertexEdges.size(); k++) {
                if (map.get(vertexEdges.get(k).getTail()) == false) {
                    vertexEdges.get(k).setInMatching(true);
                    map.put(vertexEdges.get(k).getTail(), true);
                    augmentedPath.add(vertexEdges.get(k));
                    break;
                }
            }
        }
        if (augmentedPath.isEmpty()) return null;

        for (int i = 0; i < inMatching.size(); i++) inMatching.get(i).setInMatching(false);


        return augmentedPath; // return the augmentedPath list of edges


    }
}
