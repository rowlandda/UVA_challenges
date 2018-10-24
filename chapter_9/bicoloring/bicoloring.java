/* @BEGIN_OF_SOURCE_CODE */
//bicolorable is just another word for bipartite so just use bipartite algorithm

import java.util.*;

class Main
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int num_vertices, edges;
        while (input.hasNext())
        {
            num_vertices = input.nextInt();
            //ending condition
            if (num_vertices == 0)
                break;
            edges = input.nextInt();
            int[][] graph = new int[num_vertices][num_vertices];
            for (int[] row: graph)
                Arrays.fill(row, 0);
            //create an adjacency matrix
            for (int i = 0; i < edges; i++)
            {
               int x, y;
               x = input.nextInt();
               y = input.nextInt();
               graph[x][y] = 1;
            }
            if (isBipartite(graph, num_vertices))
                System.out.println("BICOLORABLE.");
            else
                System.out.println("NOT BICOLORABLE.");
        }

    }

    //checks if a graph (represented by an adjacency matrix) is bipartite
    //https://www.geeksforgeeks.org/bipartite-graph/
    //doesn't work for graphs with loops
    static boolean isBipartite(int graph[][], int num_vertices)
    {
        int color[] = new int[num_vertices];
        //-1 means uncolored, 0 is red, 1 is black
        for (int i=0; i < num_vertices; i++)
            color[i] = -1;
        color[0] = 1;

        //queue of vertex numbers
        LinkedList<Integer> queue = new LinkedList<>();
        //start at vertex 0 because our graph is connected we can always start at
        //vertex 0
        queue.add(0);

        //while vertices in queue
        while (queue.size() != 0)
        {
            //deque color of first vertex in queue;
            int u = queue.poll();
            for (int i = 0; i < num_vertices; i++)
            {
                //if edge exists and vertex is uncolored
                if ( (graph[u][i] == 1) && (color[i] == -1) )
                {
                    //color red if uncolored
                    color[i] = 1 - color[u];
                    queue.add(i);
                }
                //if edge exists an the color is same as the color of the polled vertex
                else if ( (graph[u][i] == 1) && (color[i] == color[u]) )
                    return false;
            }
        }
        return true;
    }
}
/* @JUDGE_ID: 979449 10004 JAVA "Bicoloring" */
/* @END_OF_SOURCE_CODE */
