public class Main {


    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(true);
        graph.addEdge("Mega Silk Way", "Khan-Shatyr", 3.2);
        graph.addEdge("Khan-Shatyr", "Keruen City", 6.1);
        graph.addEdge("Keruen City", "Abu-Dabi Plaza", 2.9);
        graph.addEdge("Abu-Dabi Plaza", "Akorda", 11.5);
        graph.addEdge("Akorda", "Astana IT University", 8.8);

        System.out.println("Dijkstra algorithm:");
        Search<String> djk = new DijkstraSearch<>(graph, "Mega Silk Way");
        printPath(djk, "Astana IT University");

        Graph<String> graphNew = new Graph<>(true);
        graphNew.addEdge("Mega Silk Way", "Khan-Shatyr");
        graphNew.addEdge("Khan-Shatyr", "Keruen City");
        graphNew.addEdge("Keruen City", "Abu-Dabi Plaza");
        graphNew.addEdge("Abu-Dabi Plaza", "Akorda");
        graphNew.addEdge("Akorda", "Astana IT University");
        graphNew.addEdge("Astana IT University", "Baiterek");

        System.out.println("\n--------------------------------");

        System.out.println("DFS Traversal:");
        Search<String> dfs = new DepthFirstSearch<>(graphNew, "Mega Silk Way");
        graphNew.dfs("Baiterek");

        System.out.println("\n--------------------------------");

        System.out.print("BFS Traversal:" + '\n');
        Search<String> bfs = new BreadthFirstSearch<>(graphNew, "Mega Silk Way");
        graphNew.bfs("Baiterek");

    }

    public static void printPath(Search<String> search, String key) {
        for (String v : search.pathToDestination(key)) {
            System.out.print(v + " --> ");
        }
    }
}
