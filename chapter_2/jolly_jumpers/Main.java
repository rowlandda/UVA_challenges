/* @BEGIN_OF_SOURCE_CODE */
import java.util.*;

class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String[] temp = input.nextLine().split(" ");
        int[] numbers = new int[temp.length - 1];
        int n = Integer.parseInt(temp[0]);
        while (!temp.equals(""))
        {
            //create an array of ints from the string of number inputs
            for (int i = 1; i <= n; i++)
                numbers[i - 1] = Integer.parseInt(temp[i]);
            int[] answer_sequence = new int[n - 1];
            int pos = 0;
            //create an int array with 1 - n-1
            for (int i = 1; i < n; i++) {
                answer_sequence[pos] = i;
                pos++;
            }
            int[] absVals = new int[n - 1];
            //create an int array of the absval of the differences between
            for (int i = 0; i < n-1; i++)
            {
                absVals[i] = Math.abs(numbers[i] - numbers[i+1]);
            }
            Arrays.sort(absVals);
            if (isEqual(absVals, answer_sequence))
                System.out.println("Jolly");
            else
                System.out.println("Not jolly");
            if (!input.hasNext())
                break;
            temp = input.nextLine().split(" ");
            numbers = new int[temp.length - 1];
            n = Integer.parseInt(temp[0]);
        }
        System.exit(0);
    }

    //checks if two equal sized arrays contain the same set of integers
    private static boolean isEqual(int[] a, int[] b)
    {
        boolean equal = true;
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] != b[i])
            {
                equal = false;
                break;
            }
        }
        return equal;
    }

}
/* @JUDGE_ID: 979449 10038 JAVA "Jolly Jumpers" */
/* @END_OF_SOURCE_CODE */
