/* @BEGIN_OF_SOURCE_CODE */

import java.util.*;

public class Main {

    public static void main(String[] args)
    {
       Scanner input = new Scanner(System.in);
       //store all the results in an arraylist to iterate thru later
       ArrayList<String> results = new ArrayList<>();
       String inputString = input.nextLine();
       int n = Integer.parseInt(inputString);
       int m = 0;
       while (n != 0)
       {
           String[] correct = new String[n];
           //get correct answers
           for (int i = 0; i < n; i++) {
               inputString = input.nextLine();
               correct[i] = inputString;
           }
           //get contestant answers
           m = Integer.parseInt(input.nextLine());
           String[] answers = new String[m];
           for (int i = 0; i < m; i++) {
               inputString = input.nextLine();
               answers[i] = inputString;
           }
           //check if answers are exactly the same strings
           if (isEqual(correct, answers))
               results.add("Accepted");
           //otherwise check for presentation error
           else {
               if (isPresError(correct, answers))
                   results.add("Presentation Error");
               //must be wrong
               else
                   results.add("Wrong Answer");
           }
           inputString = input.nextLine();
           n = Integer.parseInt(inputString);
       }
       int runNum = 1;
       for (int i = 0; i < results.size(); i++) {
           System.out.println("Run #" + runNum + ": " + results.get(i));
           runNum++;
       }
    }

    //returns true only if the answers are exactly the same strings
    private static boolean isEqual(String[] a, String[] b)
    {
        if (a.length != b.length) { return false; }

        for (int i = 0; i < a.length; i++)
        {
            if ( !a[i].equals(b[i]) ) { return false; }
        }
        return true;
    }

    //uses a string builder to string all the correct answers and submitted answers into two
    //respective strings.  then strips everything that wasn't a number to check for
    //presentation error
    private static boolean isPresError(String[] a, String[] b)
    {
        StringBuilder sbA = new StringBuilder();
        StringBuilder sbB = new StringBuilder();
        for (int i = 0; i < a.length; i++)
            sbA.append(a[i]);
        for (int i = 0; i < b.length; i++)
            sbB.append(b[i]);
        String stringA = sbA.toString();
        String stringB = sbB.toString();
        stringA = stringA.replaceAll("[^0-9]", "");
        stringB = stringB.replaceAll("[^0-9]", "");
        if (!stringA.equals(stringB)) { return false; }
        return true;
    }
}

/* @JUDGE_ID: 979449 10188 JAVA "Automated Judge Script" */
/* @END_OF_SOURCE_CODE */
