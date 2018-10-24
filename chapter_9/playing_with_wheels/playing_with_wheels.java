/* @BEGIN_OF_SOURCE_CODE */

import java.util.*;

class Main
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        input.nextLine();
        for (int i = 0; i < cases; i++)
        {
            //parse input
            int start = parseInt(input);
            int end = parseInt(input);
            ArrayList<Integer> forbidden = new ArrayList<>();
            int num_forbidden = input.nextInt();
            //get forbidden combinations
            for (int j = 0; j < num_forbidden; j++)
            {
                int not_allowed = parseInt(input);
                forbidden.add(not_allowed);
            }
            input.nextLine();
            System.out.println(BFS(start, end, forbidden));
            if (input.hasNext())
                input.nextLine();//blank line
        }
    }

    //modification of BFS to include forbidden nodes in calculation
    static int BFS(int start, int end, ArrayList<Integer> forbidden)
    {
        if (start == end)
            return 0;
        boolean visited[] = new boolean[10010];
        //keeps track of the node visited previously
        int[] prev = new int[10010];
        //keeps track of the distance from start to any node
        int[] dist = new int[10010];
        Arrays.fill(visited, false);
        Arrays.fill(prev, -1);
        //create queue
        LinkedList<Integer> queue = new LinkedList<>();
        visited[start] = true;
        //mark forbidden as visited
        for (int i = 0; i < forbidden.size(); i++)
            visited[forbidden.get(i)] = true;
        dist[start] = 0;
        queue.add(start);

        while (!queue.isEmpty())
        {
            int element = queue.remove();
            ArrayList<Integer> neighbours = findAdjacencies(element);
            for (int i = 0; i < neighbours.size(); i++)
            {
                int n = neighbours.get(i);
                if (!visited[n])
                {
                    visited[n] = true;
                    prev[n] = element;
                    //increment distance
                    dist[n] = dist[element] + 1;
                    queue.add(n);
                }
            }
        }
        //if there is no path distance[end] is 0 but the judge wants us to return -1
        if (dist[end] == 0)
            return -1;
        return dist[end];
    }

    //returns an adjacency list for each node (each possible button push is another node)
    static ArrayList<Integer> findAdjacencies(int number)
    {
        int[] arr = new int[4];
        ArrayList<Integer> adjacencies = new ArrayList<>();
        int factor = 1000;
        for (int i = 0; i < 4; i++)
        {
            arr[i] = number / factor %10;
            factor /= 10;
        }
        for (int i = 0; i < 4; i++)
        {
            int temp = arr[i];
            arr[i] = (arr[i] + 1) % 10;
            adjacencies.add(creatInt(arr));
            arr[i] = temp;
            arr[i] = (arr[i] - 1);
            //special case for 0 to 9
            if (arr[i] < 0)
                arr[i] = 9;
            adjacencies.add(creatInt(arr));
            arr[i] = temp;
        }
        return adjacencies;
    }

    //helper tocreate an integer from an array[4] representing an int < 10000
    static int creatInt(int[] arr)
    {
        int ans = 0;
        ans += 1000 * arr[0];
        ans += 100 * arr[1];
        ans += 10 * arr[2];
        ans += arr[3];
        return ans;
    }

    static int parseInt(Scanner input)
    {
        int n = input.nextInt() * 1000;
        n += input.nextInt() * 100;
        n += input.nextInt() *10;
        n += input.nextInt();
        return n;
    }
}
/* @JUDGE_ID: 979449 10067 JAVA "Playing With Wheels" */
/* @END_OF_SOURCE_CODE */
