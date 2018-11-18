/* @BEGIN_OF_SOURCE_CODE */
import java.util.*;

class Main
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n;
        while (input.hasNextInt())
        {
            n = input.nextInt();
            int ring = 0;
            int k = 1;
            while (n > k)
            {
                ring++;
                k += ring*6;
            }
            //now ring is the ring number of coordinate n, k is the last cell in the ring
            int x = ring;
            int y = 0;
            //now x, y is the location of k so we modify k while modifying the coordinates
            //at the same time until k == n
            //help from http://www.questtosolve.com/browse.php?pid=10182
            while (k != n)
            {
                //going up
                while ( (k != n) && (y != -x) )
                {
                    y--;
                    k--;
                }
                //going up and left
                while ( (k != n) && (x != 0) )
                {
                    x--;
                    k--;
                }
                //going down and left
                while ( (k != n) && (y != 0) )
                {
                    x--;
                    y++;
                    k--;
                }
                //up and right
                while ( (k != n) && (y != ring) )
                {
                    y++;
                    k--;
                }
                //down and right
                while ( (k != n) && (x != 0) )
                {
                    x++;
                    k--;
                }
                //down??
                while ( (k != n) && (x != ring) )
                {
                    x++;
                    y--;
                    k--;
                }
            }
            System.out.println(x + " " + y);
        }
    }
}
/* @JUDGE_ID: 979449 10182 JAVA "Bee Maja" */
/* @END_OF_SOURCE_CODE */
