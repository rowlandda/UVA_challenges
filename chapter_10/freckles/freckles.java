/* @BEGIN_OF_SOURCE_CODE */
import java.util.*;


class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        double[][] dist = new double[110][110];
        int cases = input.nextInt();
        for (int i = 0; i < cases; i++)
        {
            //fill array with -1
            for (double[] row: dist)
                Arrays.fill(row, 0);
            //number of vertices
            int V = input.nextInt();
            input.nextLine();//burn endline char
            ArrayList<double[]> vertices = new ArrayList<>();
            //parse vertex input
            for (int j = 0; j < V; j++)
            {
                String[] verts_string = input.nextLine().split(" ");
                double[] verts = new double[2];
                verts[0] = Double.parseDouble(verts_string[0]);
                verts[1] = Double.parseDouble(verts_string[1]);
                vertices.add(verts);
            }
            //create weighted adjacency matrix dist[][]
            for (int j = 0; j < V; j++)
            {
                for (int k = 0; k < V; k++)
                    dist[j][k] = distance(vertices.get(j), vertices.get(k));
            }
            double weight = prims(dist,V);
            System.out.printf("%.2f\n", weight);
            if (i < cases -1)
                System.out.println();
        }
        
    }
    //calculate distance between two points represented as a double[2].
    // double[0] x coord and double[1] y coord
    static double distance(double[] a, double[] b)
    {
        double x = Math.pow(a[0] - b[0], 2);
        double y = Math.pow(a[1] - b[1], 2);
        return Math.sqrt(x + y);
    }

    //helper to find minimum vertex that hasn't been visited
    static int findMin(double[] weights, boolean[] visited)
    {
        double min = Double.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < visited.length; i++)
        {
            if (!visited[i] && weights[i] < min)
            {
                min = weights[i];
                index = i;
            }
        }
        return index;
    }

    //uses Prim's algorithm from https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
    //to find the weight of the shortest spanning tree
    static double prims(double graph[][], int V)
    {
        // Array to store constructed MST
        int parent[] = new int[V];
        double weights[] = new double[V];
        // To represent set of vertices not yet included in MST
        boolean visited[] = new boolean[V];
        Arrays.fill(weights, Double.MAX_VALUE);
        Arrays.fill(visited, false);
        // Always include first 1st vertex in MST.
        weights[0] = 0;     // Make key 0 so that this vertex is
        // picked as first vertex
        parent[0] = -1; // First node is always root of MST

        // The MST will have V vertices
        for (int count = 0; count < V-1; count++)
        {
            // Pick thd minimum key vertex from the set of vertices
            // not yet included in MST
            int u = findMin(weights, visited);

            // Add the picked vertex to the MST Set
            visited[u] = true;

            // Update key value and parent index of the adjacent
            // vertices of the picked vertex. Consider only those
            // vertices which are not yet included in parent
            for (int v = 0; v < V; v++)

                // graph[u][v] is non zero only for adjacent vertices of m
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v]!=0 && !visited[v] &&
                        graph[u][v] < weights[v])
                {
                    parent[v] = u;
                    weights[v] = graph[u][v];
                }
        }
        //traverse the tree and sum the weights as we go
        double weight = 0;
        for (int j = 1; j < V; j++)
            weight+=graph[j][parent[j]];
        return weight;
    }

}
/* @JUDGE_ID: 979449 10034 JAVA "Freckles" */
/* @END_OF_SOURCE_CODE */
