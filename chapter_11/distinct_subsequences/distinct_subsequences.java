/* @BEGIN_OF_SOURCE_CODE */
import java.math.BigInteger;
import java.util.*;

class Main
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String X, Z;
        int cases = input.nextInt();
        input.nextLine();
        for (int i = 0; i < cases; i++)
        {
            X = input.nextLine();
            Z = input.nextLine();
            System.out.println(findSubsequenceCount(X, Z).toString());
        }
    }

    //https://www.geeksforgeeks.org/count-distinct-occurrences-as-a-subsequence/
    //modified with big integer for the large values required in the problem
    //counts the number of unique occurances of Z in X
    static BigInteger findSubsequenceCount(String X, String Z)
    {
        int m = Z.length();
        int n = X.length();

        // T can't appear as a subsequence in S
        if (m > n)
            return BigInteger.ZERO;

        // mat[i][j] stores the count of
        // occurrences of T(1..i) in S(1..j).
        BigInteger mat[][] = new BigInteger[m + 1][n + 1];

        //empty string can't have subsequence
        for (int i = 1; i <= m; i++)
            mat[i][0] = BigInteger.ZERO;

        // Initializing first row with all 1s.
        // An empty string is subsequence of all.
        for (int j = 0; j <= n; j++)
            mat[0][j] = BigInteger.ONE;

        // Fill mat[][] in bottom up manner
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If last characters don't match,
                // then value is same as the value
                // without last character in S.
                if (Z.charAt(i - 1) != X.charAt(j - 1))
                    mat[i][j] = mat[i][j - 1];

                    // Else value is obtained considering two cases.
                    // a) All substrings without last character in S
                    // b) All substrings without last characters in
                    // both.
                else
                    mat[i][j] = mat[i][j - 1].add(mat[i - 1][j - 1]);
            }
        }

        return mat[m][n];
    }
}
/* @JUDGE_ID: 979449 10069 JAVA "Distinct Subsequences" */
/* @END_OF_SOURCE_CODE */

