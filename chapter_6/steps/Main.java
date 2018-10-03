/* @BEGIN_OF_SOURCE_CODE */
import java.util.*;

class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[1000000];
        arr[0] = 0;
        arr[1] = 1;
        //array index is the number of steps, value is the max integer achievable with that many steps
        for (int i = 2; i < arr.length; i++)
        {
            arr[i] = arr[i-1] + (i+1)/2;
        }
        int x , y;
        int difference;
        int cases = Integer.parseInt(input.nextLine());
        for (int i = 0; i < cases; i++)
        {
           x = input.nextInt();
           y = input.nextInt();
           difference = y - x;
           int index = findSteps(arr, difference);
           System.out.println(index);
        }

    }
    //returns the least amount of steps to achieve distance x
    static int findSteps(int arr[], int x)
    {
        int index = 0;
        while (arr[index] < x)
            index++;
        if (arr[index] >= x)
            return index;
        return index+1;
    }
}

/* @JUDGE_ID: 979449 846 JAVA "Steps" */
/* @END_OF_SOURCE_CODE */
