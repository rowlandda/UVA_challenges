/* @BEGIN_OF_SOURCE_CODE */
import java.util.*;

//https://math.stackexchange.com/questions/468148/how-many-squares-in-the-m-times-n-grid
class Main
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        long n;
        long s2, r2, s3, r3, s4, r4;
        while (input.hasNextLong())
        {
            n = input.nextLong();
            s2 = 0;
            for (int i = 1; i <= n; i++)
                s2 += i*i;
            //rectangle formula minus the squares because the judge doesn't
            // consider squares rectangles
            r2 = ( ((n * n) + n) * ((n * n) + n) ) / 4 - s2;
            //https://math.stackexchange.com/questions/759998/how-to-find-how-many-cubes-are-in-a-n-by-n-by-n-cube
            s3 = 0;
            for (int i = 1; i <= n; i++)
                s3 += i*i*i;
            r3 = ((n * n) + n) / 2 - 1;
            r3 *= s3;
            s4 = 0;
            for (int i = 1; i <= n; i++)
                s4 += i*i*i*i;
            r4 = (s3 * s3) - s4;
            System.out.println(s2 + " " + r2 + " " + s3 +
                    " " + r3 + " " + s4 + " " + r4);
        }
    }

}
/* @JUDGE_ID: 979449 10177 JAVA "2/3/4" */
/* @END_OF_SOURCE_CODE */
