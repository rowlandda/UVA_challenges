/* @BEGIN_OF_SOURCE_CODE */
import java.util.*;

public class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        HashMap<Character, Character> cipher = new HashMap<>();
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String nums = "1234567890";
        String other = " -=[]\\;',./";
        String alphaShift = "AVXSWDFGUHJKNBIOQEARYCQZTZ";
        String numsShift = "`123456789";
        String otherShift = " 0-P[]L;M,.";
        for (int i = 0; i < alpha.length(); i++)
            cipher.put(alpha.charAt(i), alphaShift.charAt(i));
        for (int i = 0; i < nums.length(); i++)
            cipher.put(nums.charAt(i), numsShift.charAt(i));
        for (int i = 0; i < other.length(); i++)
            cipher.put(other.charAt(i), otherShift.charAt(i));

        String inputLine = "";
        while (input.hasNextLine())
        {
            StringBuilder sb = new StringBuilder();
            inputLine = input.nextLine();
            for (int i = 0; i < inputLine.length(); i++)
                sb.append(cipher.get(inputLine.charAt(i)));
            System.out.println(sb.toString());
        }

    }
}
/* @JUDGE_ID: 979449 10082 JAVA "WERTYU" */
/* @END_OF_SOURCE_CODE */