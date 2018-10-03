/* @BEGIN_OF_SOURCE_CODE */

import java.util.*;

class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String inputString = "";
        while (!inputString.equals("0 0"))
        {
            int[] array1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] array2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] raw_addition = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int carries = 0;
            StringBuilder sb = new StringBuilder();
            sb.append(input.nextLine());
            if (sb.toString().equals("0 0"))
                break;
            //reverse the strings to put the most significant digits on the left instead of right
            sb.reverse();
            inputString = sb.toString();
            String[] two_ints = inputString.split(" ");
            //convert the digits to individual ints in two seperate arrays
            for (int i = 0; i < two_ints[1].length(); i++)
                array1[i] = Integer.parseInt(String.valueOf(two_ints[1].charAt(i)));
            for (int i = 0; i < two_ints[0].length(); i++)
                array2[i] = Integer.parseInt(String.valueOf(two_ints[0].charAt(i)));
            for (int i = 0; i < 9; i++)
            {
                raw_addition[i] = array1[i] + array2[i];
                if (raw_addition[i] > 9)
                {
                    carries++;
                    array2[i+1]+= raw_addition[i] / 10;
                }
            }
            if (carries < 2)
            {
                if (carries == 0)
                {
                    System.out.println("No carry operation.");
                }
                else{
                    System.out.println("1 carry operation.");
                }
            }
            if (carries > 1)
                System.out.println("" + carries + " carry operations.");
        }

    }
}

/* @JUDGE_ID: 979449 10035 JAVA "" */
/* @END_OF_SOURCE_CODE */
