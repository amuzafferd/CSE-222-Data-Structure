import java.util.Iterator;
import java.util.Vector;

public class MyControllerClass {

    public boolean is_connected(Graph other, int v1, int v2) throws Exception {

        if(v1<0 || v1>other.getNumV() || v2<0 || v2>other.getNumV() )
            throw new IndexOutOfBoundsException("Index out of bounds exception in is_connetced method");

        for (int i = 0; i < other.getNumV(); i++) {
            if (other.isEdge(v1,i)){
                Edge edge = other.getEdge(v1,i);
                if(edge.getDest() == v2)
                    return true;
            }
        }

        return false;
    }

    public Vector<Integer> shortest_path(Graph other, int v1, int v2){
        int [] tempInt = new int[other.getNumV()];
        double [] tempDouble = new double[other.getNumV()];
        Vector<Integer> temp = new Vector<>();

        DijkstrasAlgorithm myDijkstrasAlgorithm = new DijkstrasAlgorithm();
        myDijkstrasAlgorithm.dijkstrasAlgorithm(other, v1, v2, tempInt, tempDouble);

        for (int i = 0; i < other.getNumV(); i++) {
            System.out.println(tempInt[i] + " -> " + tempDouble[i]);
        }

        return temp;
    }

    public boolean is_undirected(Graph other){
        return other.isDirected() ? this.is_acyclic_graph(other) : true;
    }

    private boolean is_undirected_helper(ListGraph other, int v, boolean visited[], int parent){
        visited[v] = true;
        Edge i;
        Iterator<Edge> it = other.getEdges()[v].iterator();
        while (it.hasNext())
        {
            i = it.next();
            if (!visited[i.getDest()])
            {
                if (is_undirected_helper(other, i.getDest(), visited, v))
                    return true;
            }
            else if (i.getDest() != parent)
                return true;
        }
        return false;

    }

    public boolean is_acyclic_graph(Graph other){
        boolean visited[] = new boolean[other.getNumV()];
        for (int i = 0; i < other.getNumV(); i++)
            visited[i] = false;
        for (int u = 0; u < other.getNumV(); u++)
            if (!visited[u])
                if (is_undirected_helper((ListGraph) other, u, visited, -1))
                    return false;
        return true;
    }

    public void plot_graph(Graph other){

        for (int i = 0; i < other.getNumV(); i++) {
            int weight = 0;
            System.out.print(i);
            for (int j = 0; j < other.getNumV(); j++) {
                if(other.isEdge(i,j)){
                    Edge edge = new Edge(i,j);
                    System.out.print(" -> " + edge.getDest());
                    weight += edge.getWeight();
                }
            }
            System.out.println("\nTotal Weight: " + weight + "\n");
        }
    }
}
