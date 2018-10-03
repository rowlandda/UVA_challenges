/* @BEGIN_OF_SOURCE_CODE */
import java.util.*;
import java.math.*;

class Main
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        //set up initial conditions
        BigInteger zero = BigInteger.ONE;
        BigInteger one = new BigInteger("2");
        BigInteger two = new BigInteger("5");
        BigInteger result;
        BigInteger[] arr = new BigInteger[1001];
        arr[0] = zero; arr[1] = one; arr[2] = two;
        //recurrence is third order An = 2*A(n-1) + A(n-2) + A(n-3)
        for (int i = 3; i < 1001; i++)
        {
            result = arr[i-1].multiply(new BigInteger("2")).add(arr[i-2]).add(arr[i-3]);
            arr[i] = result;
        }
        int n;
        while (input.hasNext())
        {
            n = input.nextInt();
            if (n == 0)
                System.out.println("1");
            else if (n == 1)
                System.out.println("2");
            else if (n == 2)
                System.out.println("5");
            else
                System.out.println(arr[n].toString());
        }
    }
}

/* @JUDGE_ID: 979449 10198 JAVA "Counting" */
/* @END_OF_SOURCE_CODE */
