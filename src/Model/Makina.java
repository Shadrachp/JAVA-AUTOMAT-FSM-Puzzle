package Model;

import java.util.ArrayList;
import java.util.List;

public class Makina {
    private ArrayList<Integer>[] makina;
    private int states = 23;

    public Makina(int start, int end){
        makina = new ArrayList[states];
        initArraylist();
        createMakina();
        printShortestDistance(makina, start, end);
    }

    private void createMakina(){
        insertConnection(0, 1);
        insertConnection(1, 2);
        insertConnection(1, 5);
        insertConnection(2, 3);
        insertConnection(2, 6);
        insertConnection(2, 9);
        insertConnection(3, 4);
        insertConnection(3, 5);
        insertConnection(3, 11);
        insertConnection(5, 6);
        insertConnection(5, 8);
        insertConnection(5, 9);
        insertConnection(6, 7);
        insertConnection(7, 8);
        insertConnection(8, 10);
        insertConnection(8, 17);
        insertConnection(9, 10);
        insertConnection(11,12);
        insertConnection(11,14);
        insertConnection(11,16);
        insertConnection(12,13);
        insertConnection(13,19);
        insertConnection(14,15);
        insertConnection(14,17);
        insertConnection(14,20);
        insertConnection(15,16);
        insertConnection(15,19);
        insertConnection(17,18);
        insertConnection(17,19);
        insertConnection(19,20);
        insertConnection(20,21);
    }

    private void initArraylist(){
        for (int i = 0; i < makina.length; i++)
            makina[i] = new ArrayList<>();
    }

    private void insertConnection(int src, int dest){
        makina[src].add(dest);
        makina[dest].add(src);
    }

    // utility function to print the shortest distance
// between source vertex and destination vertex
    public void printShortestDistance(ArrayList[] makina, int s, int dest)
    {
        // predecessor[i] array stores predecessor of
        // i and distance array stores distance of i
        // from s
        int[] prev = new int[states];
        int[] dist = new int[states];

        if (!BFS(makina, s, dest, states, prev, dist))
        {
            System.out.println("Given source and destination are not connected");
            return;
        }

        // vector path stores the shortest path
        ArrayList<Integer> path = new ArrayList<>();
        int crawl = dest;
        path.add(crawl);
        System.out.println(crawl);
        System.out.println("-----------------");
        for (int i = 0; i < prev.length; i++) {
            System.out.println(prev[i]);
        }
        System.out.println("-----------------");

        while (prev[crawl] != -1) {
            System.out.println("path: " + path);
            path.add(prev[crawl]);
            crawl = prev[crawl];
        }

        // distance from source is in distance array
        System.out.println("Shortest path length is : " + dist[dest]);

        // printing path from source to destination
        System.out.println("Path is:");
        for (int i = path.size() - 1; i >= 0; i--)
            System.out.println(path.get(i) + " ");
    }

    // a modified version of BFS that stores predecessor
    // of each vertex in array p
    // and its distance from source in array d
    boolean BFS(ArrayList<Integer>[] makina, int src, int dest, int v,
             int prev[], int dist[]) {

        List<Integer> q = new ArrayList<>();

        // boolean array visited[] which stores the
        // information whether ith vertex is reached
        // at least once in the Breadth first search
        boolean[] visited = new boolean[v];

        // initially all vertices are unvisited
        // so v[i] for all i is false
        // and as no path is yet constructed
        // dist[i] for all i set to infinity
        for (int i = 0; i < v; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            prev[i] = -1;
        }

        // now source is first to be visited and
        // distance from source to itself should be 0
        visited[src] = true;
        dist[src] = 0;
        q.add(src);

        // standard BFS algorithm
        while (!q.isEmpty()) {
            int u = q.get(0);
            q.remove(0);
            for (int i = 0; i < makina[u].size(); i++) {
                if (visited[makina[u].get(i)] == false) {
                    visited[makina[u].get(i)] = true;
                    dist[makina[u].get(i)] = dist[u] + 1;
                    prev[makina[u].get(i)] = u;
                    q.add(makina[u].get(i));

                    // We stop BFS when we find
                    // destination.
                    if (makina[u].get(i) == dest)
                        return true;
                }
            }
        }

        return false;
    }
}
