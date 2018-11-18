/* @BEGIN_OF_SOURCE_CODE */

import java.util.*;

//help from http://www.algorithmist.com/index.php/UVa_10161
class Main
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        while (N != 0)
        {
            int K = (int) Math.floor(Math.sqrt(N));
            //steps left is N - the closest perfect square less than N
            int steps_left = N - K*K;

            //perfect square puts the ant on the x-axis if even, y-axis if odd
            if (isPerfectSquare(N) && isEven(N))
                System.out.println((int)Math.sqrt(N) + " " + 1);
            else if (isPerfectSquare(N) && !isEven(N))
                System.out.println(1 + " " + (int)Math.sqrt(N));

            //if the floor of the sqrt of N is even start at the perfect square and work
            //our way around to our location
            else if (isEven(K))
            {
                int side_size = (K+1);
                if (steps_left  <= side_size)
                    System.out.println(side_size + " " + steps_left );
                else
                    System.out.println((side_size - steps_left  + side_size) + " " + (K+1));
            }

            //if the floor is odd start on the other side and do the same
            else
            {
                if (steps_left  <= K+1)
                    System.out.println(steps_left  + " " + (K+1));
                else
                    System.out.println((K+1) + " " + (K+1 - steps_left  - K*2));
            }
            N = input.nextInt();
        }

    }

    static boolean isPerfectSquare(int n)
    {
        double sq = Math.sqrt(n);
        return (sq - Math.floor(sq) == 0);
    }

    static boolean isEven(int n)
    {
        return (n % 2 == 0);
    }
}

/* @JUDGE_ID: 979449 10161 JAVA "Ant on a Chessboard" */
/* @END_OF_SOURCE_CODE */
