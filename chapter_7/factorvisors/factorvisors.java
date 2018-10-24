/* @BEGIN_OF_SOURCE_CODE */
import java.util.*;

class Main
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        while (input.hasNext())
        {
            String[] numbers = input.nextLine().split(" ");
            if ( (numbers[0] == null) || (numbers[0].equals("")) )
                break;
            long factorial = Integer.parseInt(numbers[0]);
            long number = Integer.parseInt(numbers[1]);
            if (doesDivide(factorial, number))
                System.out.println("" + number + " divides " + factorial + "!");
            else
                System.out.println("" + number + " does not divide " + factorial + "!");
        }
    }
    //find the prime factors of a given number
    //https://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number/
    static ArrayList<Long> primeFactors(long n)
    {
        ArrayList<Long> results = new ArrayList<>();
        if ( (n == 0) || (n == 1) )
        {
            results.add((long)1);
            return results;
        }
        while (n%2==0)
        {
            results.add((long)2);
            n /= 2;
        }

        // n must be odd at this point.
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            // While i divides n, print i and divide n
            while (n%i == 0)
            {
                results.add((long)i);
                n /= i;
            }
        }

        // n is a prime number greater than 2
        if (n > 2)
            results.add(n);
        return results;
    }

    //returns the number of prime factors of p in the prime factorization of n
    //http://www.algorithmist.com/index.php/Int_get_powers(n,_p)
    static int getPowers(long n, long p)
    {
        // if p is one always return 1
        if (p == 1)
            return 1;
        // never any 0s in the factors
        if (p == 0)
            return 0;
        int res = 0;
        for (long power = p ; power <= n ; power *= p)
        {
            if (power == 0)
                return res;
            res += n / power;
        }
        return res;
    }

    //returns the frequency of an integer in a sorted list of ints
    static int count(ArrayList<Long> list, long number)
    {
        int index = 0;
        long compareTo = -1;
        int count = 0;
        if (list.contains(number))
        {
           index = list.indexOf(number);
           compareTo = list.get(index);
           while (list.get(index) == compareTo)
           {
               count++;
               if (index == list.size() - 1)
                   break;
               index++;
           }
        }
        return count;
    }

    // the factorial is divisible by the number if the power of the prime factors in the number are less than the power
    // of the factorials prime factors
    static boolean doesDivide(long factorial, long number)
    {
        ArrayList<Long> primefactors = primeFactors(number);
        long compareTo = -1;
        for (int i = 0; i < primefactors.size(); i++)
        {
            // check if a new unique integer in the list
            if (compareTo != primefactors.get(i))
            {
                if ( count(primefactors, primefactors.get(i)) > getPowers(factorial, primefactors.get(i)) )
                    return false;
                compareTo = primefactors.get(i);
            }
        }
        return true;
    }
}

/* @JUDGE_ID: 979449 10139 JAVA "Factorvisors" */
/* @END_OF_SOURCE_CODE */

