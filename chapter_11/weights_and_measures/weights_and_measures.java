/* @BEGIN_OF_SOURCE_CODE */
import java.util.*;


//help from https://reponroy.wordpress.com/2016/06/07/uva-volume-101/
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String line;
        int weight, strength;
        int[] stack = new int[6000];
        ArrayList<Turtle> turtles = new ArrayList<>();

        while (input.hasNextLine())
        {
            line = input.nextLine();
            if (line.equals("0 0"))
                break;
            String[] arr = line.split(" ");
            weight = Integer.parseInt(arr[0]);
            strength = Integer.parseInt(arr[1]);
            turtles.add(new Turtle(weight, strength));
        }

        Collections.sort(turtles);
        int size = turtles.size();
        //biggest number we can stack
        int max = 0;
        Arrays.fill(stack, Integer.MAX_VALUE);
        stack[0] = 0;

        for (int i = 0; i < size; i++)
        {
            int W = turtles.get(i).weight;
            int S = turtles.get(i).strength;
            for (int j = max; j >= 0; j--)
            {
                if ((S >= stack[j] + W) &&
                        (W + stack[j] < stack[j + 1]))
                {
                    stack[j + 1] = stack[j] + W;
                    max = Math.max(max, j + 1);
                }
            }
        }
        System.out.println(max);


    }

    static class Turtle implements Comparable<Turtle>
    {
        int weight;
        int strength;

        public Turtle(int weight, int strength)
        {
            this.weight = weight;
            this.strength = strength;
        }

        @Override
        public int compareTo(Turtle other)
        {
            if (this.strength == other.strength)
                return this.weight - other.weight;
            return this.strength - other.strength;
        }
    }
}
/* @JUDGE_ID: 979449 10154 JAVA "Weights and Measures" */
/* @END_OF_SOURCE_CODE */
