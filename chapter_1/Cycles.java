/* @BEGIN_OF_SOURCE_CODE */
import java.util.Scanner;

//change class name to Main for the Judge
class Main
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		//keep looping until non-int input
		while (input.hasNextInt())
		{
			int x = input.nextInt();
			int y = input.nextInt();
			int max = findMax(x, y);
			//output results
			System.out.println(x + " " + y + " " + max);
		}
		System.exit(0);
	}

	//helper method to count the number of iterations of the 3n + 1 algorithm
	//neccessary to arrive at 1
	private static int cycles(int i)
	{
		if (i <= 1) return 1;
		int count = 1;
		while (i != 1)
		{
			if (i % 2 == 0)
			{
				i /= 2;
				count++;
			}
			else
			{
				i *= 3;
				i++;
				count++;
			}
		}
		return count;
	}

	//helper method to find the max number of cycles of all numbers between
	//the two integers passed to the function
	private static int findMax(int x, int y)
	{
		//the second number is less than the first reverse the order
		if (x > y)
		{
			int temp = x;
			x = y;
			y = temp;
		}
		int max = 0;
		for (int i = x; i <= y; i++)
		{
			if (cycles(i) > max) max = cycles(i);
		}
		return max;
	}
}
/* @JUDGE_ID: 979449 100 JAVA "3n + 1 Problem" */
/* @END_OF_SOURCE_CODE */
