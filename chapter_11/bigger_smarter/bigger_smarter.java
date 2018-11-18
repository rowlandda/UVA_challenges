/* @BEGIN_OF_SOURCE_CODE */
import java.util.*;

class Main
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int sub_length = 0;
        ArrayList<Elephant> elephants = new ArrayList<>();
        int weight, iq;
        int i = 1;
        while (input.hasNextLine())
        {
            String line = input.nextLine();
            String[] arr = line.split(" ");
            weight = Integer.parseInt(arr[0]);
            iq = Integer.parseInt(arr[1]);
            Elephant e = new Elephant(i, weight, iq);
            elephants.add(e);
            i++;
        }
        //sort by weight
        Collections.sort(elephants);
        //convert to and array for my LIS helper function
        //was easier for me to manipulate an array to get LIS
        Elephant[] arr = new Elephant[elephants.size()];
        arr = elephants.toArray(arr);
        arr = LIS(arr);
        //print length of sequence
        System.out.println(arr.length);
        for (int j = 0; j < arr.length; j++)
        {
            System.out.println(arr[j].ID);
        }
    }

    static class Elephant implements Comparable<Elephant>
    {
        int ID;
        int weight;
        int IQ;

        public Elephant(int ID, int weight, int IQ)
        {

            this.ID = ID;
            this.weight = weight;
            this.IQ = IQ;
        }

        public int compareTo(Elephant other)
        {
            return this.weight - other.weight;
        }

    }

    //give LIS of decreasing elephant IQ.  if list is already sorted by increasing weight this
    //will give the LIS of increasing weight with decreasing IQs
    static Elephant[] LIS(Elephant[] elephants)
    {
        int[] length = new int[elephants.length];
        Arrays.fill(length, 1);
        int[] sub = new int[elephants.length];
        int max_length = 1;
        int max_index = 0;

        for (int i = 1; i < elephants.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if ( (elephants[i].IQ < elephants[j].IQ) &&
                        (elephants[i].weight > elephants[j].weight) &&
                        ( length[i] < length[j] + 1) )
                {
                    length[i] = length[j] + 1;
                    sub[i] = j;
                    if (length[i] > max_length)
                    {
                        max_length = length[i];
                        max_index = i;
                    }
                }
            }
        }

        Elephant[] sequence = new Elephant[max_length];
        for (int i = max_length-1; i >=0 ; i--)
        {
            sequence[i] = elephants[max_index];
            max_index = sub[max_index];
        }
        return sequence;
    }

}
/* @JUDGE_ID: 979449 10131 JAVA "Is Bigger Smarter" */
/* @END_OF_SOURCE_CODE */
