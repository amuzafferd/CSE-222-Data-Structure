import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        ListGraph listGraph = new ListGraph(10, true);
        MyControllerClass myControllerClass = new MyControllerClass();


        for (int i = 0; i < 10; i++){
            listGraph.insert(new Edge(random.nextInt(10), random.nextInt(10), random.nextInt(50)));
            listGraph.insert(new Edge(random.nextInt(10), random.nextInt(10), random.nextInt(50)));
        }

        myControllerClass.plot_graph(listGraph);
        System.out.println("is_undirected: " + myControllerClass.is_undirected(listGraph));
        System.out.println("is_acyclic_graph: "+myControllerClass.is_acyclic_graph(listGraph));
        BreadthFirstSearch BFS = new BreadthFirstSearch();
        DepthFirstSearch DFS = new DepthFirstSearch(listGraph);
        int[] BFSArray = BFS.breadthFirstSearch(listGraph,0);
        System.out.print("BreadthFirstSearch: ");
        for (int i = 0; i <10 ; i++) {
            System.out.print(BFSArray[i]+" ");
        }
        System.out.println();
        System.out.print("DepthFirstSearch: ");
        DFS.depthFirstSearch(0);
        int[] DFSArray = DFS.getFinishOrder();
        for (int i = 0; i <10 ; i++) {
            System.out.print(DFSArray[i]+" ");
        }
        System.out.println();

    }
}
