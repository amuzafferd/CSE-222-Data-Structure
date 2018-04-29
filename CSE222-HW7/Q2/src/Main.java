import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        try{
            Random random = new Random();
            ListGraph listGraph = new ListGraph(15, true);
            MyControllerClass myControllerClass = new MyControllerClass();


            for (int i = 0; i < 15; i++){
                listGraph.insert(new Edge(random.nextInt(15), random.nextInt(15), random.nextInt(50)));
                listGraph.insert(new Edge(random.nextInt(15), random.nextInt(15), random.nextInt(50)));
                listGraph.insert(new Edge(random.nextInt(15), random.nextInt(15), random.nextInt(50)));
                listGraph.insert(new Edge(random.nextInt(15), random.nextInt(15), random.nextInt(50)));
                listGraph.insert(new Edge(random.nextInt(15), random.nextInt(15), random.nextInt(50)));
                listGraph.insert(new Edge(random.nextInt(15), random.nextInt(15), random.nextInt(50)));
            }

            myControllerClass.plot_graph(listGraph);
            System.out.println("is_acyclic_graph: " + myControllerClass.is_acyclic_graph(listGraph));
            System.out.println("is_connected: " + myControllerClass.is_connected(listGraph,0, 5));
            System.out.println("is_undirected: " + myControllerClass.is_undirected(listGraph));
            System.out.println(myControllerClass.shortest_path(listGraph, 0, 5));
        }catch (Exception e){
            System.err.println(e.getMessage());
        }



    }
}
