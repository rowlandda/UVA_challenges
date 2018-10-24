/* @BEGIN_OF_SOURCE_CODE */

import java.util.*;

class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int[] pegs = new int[60];
        Arrays.fill(pegs, 0);
        pegs[0] = 0;
        pegs[1] = 1;
        for (int i = 2; i < 60; i++)
            pegs[i] = howManyBalls(i);
        //for some reason every even peg number is too big by one
        for (int i = 2; i < 60; i+=2)
            pegs[i]--;
        int cases = Integer.parseInt(input.nextLine());
        for (int i = 0; i < cases; i++)
        {
            int n = input.nextInt();
            System.out.println(pegs[n]);
        }
    }

    static int howManyBalls(int num_pegs)
    {
        int balls = 1;
        //array values update to the value of the top ball
        int[] pegs = new int[num_pegs];
        Arrays.fill(pegs, 0);
        pegs[0] = 1;
        boolean didsomething = true;
        while (didsomething)
        {
            for (int i = 1; i < num_pegs; i++)
            {
                //check for a perfect square possibility first
                if (isPerfectSquare(pegs[i]+balls))
                {
                    didsomething = true;
                    balls++;
                    pegs[i] = balls;
                    //make sure to start looking at the beginning of the pegs
                    //after this
                    i = -1;
                }
                //then check if peg is empty
                else if (pegs[i] == 0)
                {
                    didsomething = true;
                    balls++;
                    pegs[i] = balls;
                    i = -1;
                }
                //means we couldn't find a perfect square or empty peg so we are
                //done
                else if (i == num_pegs -1)
                    didsomething = false;

            }
        }
        return balls;
    }

    static boolean isPerfectSquare(int n)
    {
        if (n == 0)
            return false;
        int sq = (int) Math.sqrt((double)n);
        return (sq*sq) == n;
    }
}
/* @JUDGE_ID: 979449 10276 JAVA "Hanoi Tower Troubles Again!" */
/* @END_OF_SOURCE_CODE */
