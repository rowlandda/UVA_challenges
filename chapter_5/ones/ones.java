/* @BEGIN_OF_SOURCE_CODE */
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        BigInteger ones = BigInteger.ONE;
        int num_ones = 1;
        while (input.hasNextLine())
        {
            String int_input = input.nextLine();
            BigInteger number = new BigInteger(int_input);
            //check if the current ones number is evenly divisible by the number
            while (ones.mod(number).intValue() != 0)
            {
                //if not divisible we add another 1 to the ones number
                ones = (ones.multiply(BigInteger.TEN));
                ones = ones.add(BigInteger.ONE);
                //increment ones counter;
                num_ones++;
            }
            System.out.println(num_ones);
            //reset counter and ones number
            num_ones = 1;
            ones = BigInteger.ONE;
        }

    }
}
/* @JUDGE_ID: 979449 10127 JAVA "Ones" */
/* @END_OF_SOURCE_CODE */
