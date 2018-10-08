/* @BEGIN_OF_SOURCE_CODE */
import java.util.*;

class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        long number1 = 0;
        int cases = input.nextInt();
        int iterations = 1;
        for (int i = 0; i < cases; i++)
        {
            if (!input.hasNextInt())
                break;
            number1 = input.nextInt();
            long number2 = reverseDigits(number1);
            long sum = number1 + number2;
            while (!isPalindrome(sum) && (iterations < 1001))
            {
                number1 = number1 + number2;
                number2 = reverseDigits(number1);
                sum = number1 + number2;
                iterations++;
            }
            System.out.println("" + iterations + " " + (number1 + number2));
            iterations = 1;
        }

    }

    static boolean isPalindrome(long number)
    {
        StringBuilder sb = new StringBuilder();
        String string1, string2;
        sb.append(String.valueOf(number));
        string1 = sb.toString();
        string2 = sb.reverse().toString();
        if (string1.equals(string2))
            return true;
        return false;
    }

    static long reverseDigits(long number)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(number));
        String string = sb.reverse().toString();
        long result = Integer.parseInt(string);
        return result;
    }
}
/* @JUDGE_ID: 979449 10018 JAVA "Reverse and Add" */
/* @END_OF_SOURCE_CODE */
