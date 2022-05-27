import java.util.*;

public class Graph<V>{
    private final boolean undirected;
    private Map<V, List<V>> map = new HashMap<>();
    ArrayList<V> marked = new ArrayList<V>();

    public Graph() {
        this.undirected = true;
    }
    public Graph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(V v) {
        map.put(v, new LinkedList<>());
    }

    public void addEdge(V source, V dest) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest) || source.equals(dest))
            return;

        map.get(source).add(dest);

        if (undirected)
            map.get(dest).add(source);
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (V v : map.keySet()) {
            count += map.get(v).size();
        }
        if (undirected)
            count /= 2;
        return count;
    }

    public boolean hasVertex(V v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(V source, V dest) {
        if (!hasVertex(source)) return false;
        return map.get(source).contains(dest);
    }

    public Iterable<V> adjacencyList(V v) {
        if (!hasVertex(v)) return null;
        return map.get(v);
    }

    public void dfs(V s){
        marked.add(s);
        System.out.print(s + " -> ");
        for(V to : map.get(s)){ if(!marked.contains(to)){ dfs(to); } }
    }

    void bfs(V s){;
        Map<V, Integer> dst = new HashMap<>();

        dst.put(s, 0);

        Queue<V> q = new ArrayDeque<>();

        q.add(s);

        while(!q.isEmpty()) {
            V cur = q.poll();
            for (V to : map.get(cur)) {
                if(!dst.containsKey(to)) {
                    dst.put(to, dst.get(cur) + 1);
                    q.add(to);
                }
            }
        }

        System.out.println();

        System.out.println("Distance to all vertices from " + s);
        for(Map.Entry<V, Integer> entry : dst.entrySet()){
            System.out.println("to: " + entry.getKey() + ", distance: " + entry.getValue());
        }
    }

}
