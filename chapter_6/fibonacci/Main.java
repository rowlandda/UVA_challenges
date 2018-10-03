/* @BEGIN_OF_SOURCE_CODE */
import java.math.BigInteger;
import java.util.*;

class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        int count = 0;
        while (!inputString.equals("0 0"))
        {
            String[] num_strings = inputString.split(" ");
            BigInteger start = new BigInteger(num_strings[0]);
            BigInteger end = new BigInteger(num_strings[1]);
            //check if starting number is a fibonacci and adjust count
            if (isFib(start))
                count++;
            start = nextFib(start);
            while (start.compareTo(end) <= 0)
            {
                count++;
                start = nextFib(start);
            }
            inputString = input.nextLine();
            System.out.println("" + count);
            count = 0;
        }
    }

    static BigInteger nextFib(BigInteger start)
    {
        BigInteger one = BigInteger.ONE;
        BigInteger two = BigInteger.ONE;
        BigInteger result = BigInteger.ONE;
        while (two.compareTo(start) <= 0)
        {
            result = one.add(two);
            one = two;
            two = result;
        }
        return result;
    }

    static boolean isFib(BigInteger number)
    {
        BigInteger one = BigInteger.ONE;
        BigInteger two = BigInteger.ONE;
        BigInteger result = BigInteger.ONE;
        while (two.compareTo(number) < 0)
        {
            result = one.add(two);
            one = two;
            two = result;
        }
        return (two.compareTo(number) == 0);


    }
}
/* @JUDGE_ID: 979449 10183 JAVA "How Many Fibs" */
/* @END_OF_SOURCE_CODE */
