/* @BEGIN_OF_SOURCE_CODE */
import java.util.*;

public class Main
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int cases = Integer.parseInt(input.nextLine());
        int[] results = new int[cases];
        for (int i = 0; i < cases; i++)
        {
            int relatives = input.nextInt();
            int[] streetNums = new int[relatives];
            for (int j = 0; j < relatives; j++)
                streetNums[j] = input.nextInt();
            Arrays.sort(streetNums);
			//median location after sort will be vitos location
			int median = relatives/2;
			int vitos_house = streetNums[median];
			//add up all distances
			int total = 0;
			for (int j = 0; j < relatives; j++)
				total += Math.abs(streetNums[j] - vitos_house);
			
			results[i] = total;			
			
        }
        for (Integer distance : results)
            System.out.println(distance);
    }
}
/* @JUDGE_ID: 979449 10041 JAVA "Vito's Family" */
/* @END_OF_SOURCE_CODE */
