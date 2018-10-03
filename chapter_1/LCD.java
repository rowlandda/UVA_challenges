/* @BEGIN_OF_SOURCE_CODE */
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.StringBuilder;

//change class name to "Main" for judge
class Main
{
	public static void main(String[] args)
	{
		ArrayList<char[][]> container = new ArrayList<char[][]>();
		Scanner input = new Scanner(System.in);
		String numbers = input.nextLine();
		//trim the spaces the grader throws at you
		//learned from 
		//https://stackoverflow.com/questions/5455794/removing-whitespace-from-strings-in-java
		numbers = numbers.replaceAll("\\s","");
		//sneaky way to cast the char  as  int
		int size = numbers.charAt(0) - '0';
		int startOfNumber = 1;
		//this is if the input is wanting size to be 10
		if (numbers.substring(0,2).equals("10"))
		{
			size = 10;
			startOfNumber = 2;
		}
		while ( !numbers.substring(0,2).equals("00"))
		{
			//check to see if the judge wants the chars to be size 10 and 
			//adjust indexes accordingly
			if ((numbers.substring(0,2).equals("10") && (numbers.length() > 2)))
			{
				startOfNumber = 2;
				size = 10;
				for (int i = 2; i < numbers.length(); i++)
				{
					char[][] number = make8(size);
					makeNum(number, size, numbers.charAt(startOfNumber));
					container.add(number);
					startOfNumber++;
				}
			}
			//loop for any other size than 10
			else
			{
				for (int i = 1; i < numbers.length(); i++)
				{
					char[][] number = make8(size);
					makeNum(number, size, numbers.charAt(startOfNumber));
					container.add(number);
					startOfNumber++;
				}
			}
			printNums(container, size);
			//get another line of input and reset parameters and indexes
			numbers = input.nextLine();
			numbers = numbers.replaceAll("\\s","");
			startOfNumber = 1;
			size = numbers.charAt(0) - '0';
			container = new ArrayList<char[][]>();
		}
		System.exit(0);
	}

	//returns and returns a char[][] array resembling the number 8 in LCD style
	private static char[][]  make8(int s)
	{
		char[][] eight = new char[2*s + 3][s + 2];
		int rows = eight.length;
		int cols = eight[0].length;
		//fill with " "'s
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
				eight[i][j] = ' ';
		}		

		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				//fill in '-'s
				if ( ( (i == 0) && (j != 0 && j != (s + 1)) ) ||
				     ( (i == (s + 1)) && (j != 0 && j != (s + 1)) ) ||
				     ( (i == (rows - 1)) && (j != 0 && j != (s + 1)) ) )
				   
				   eight[i][j] = '-';

				//fill in '|'s
				if ( (j == 0 || j == (cols - 1)) && 
						((i != 0)  && (i != (s + 1)) && (i != (rows - 1)) ) ) 

					eight[i][j] = '|';
			}
		}
		return eight;
	}

	//takes a char of a number and changes an "8" array to the supplied number
	private static void makeNum(char[][] arr, int size, char num)
	{
		int rows = arr.length;
		int cols = arr[0].length;
		switch(num)
		{
			case '0':
				for (int j = 0; j < cols; j++)
					arr[size + 1][j] = ' ';
				break;

			case '1':
				for (int i = 0; i < rows; i++)
				{
					for (int j = 0; j < cols - 1; j++)
						arr[i][j] = ' ';	
				}
				break;

			case '2':
				for (int i = 1; i < rows - 1; i++)
				{
					for (int j = 0; j < cols; j++)
					{
						if ( ( i < (size + 1) && (i > 0) ) && (j == 0) )
							arr[i][j] = ' ';
						if ( (i > size) && (j == (cols - 1)) )
							arr[i][j] = ' ';	
					}
				}
				break;

			case '3':
				for (int i = 0; i < rows; i++)
					arr[i][0] = ' ';
				break;

			case '4':
				for (int i = 0; i < rows; i++)
				{
					for (int j = 0; j < cols; j++)
					{
						if ( (i == 0) || (i == (rows - 1)) )
							arr[i][j] = ' ';
						if ( (j == 0) && (i > size) )
							arr[i][j] = ' ';	
					}
				}
				break;

			case '5':
				for (int i = 0; i < rows; i++)
				{
					for (int j = 0; j < cols; j++)
					{
						if ( (j == 0) && (i > size) )
							arr[i][j] = ' ';
						if ( (j == (cols - 1)) && (i <= size) )
							arr[i][j] = ' ';
					}
				}
				break;

			case '6':
				for (int i = 0; i <= size; i++)
					arr[i][cols - 1] = ' ';
				break;
				
			case '7':
				for (int i = 0; i < rows; i++)
				{
					for (int j = 0; j < cols; j++)
					{
						if ( (i > 0) && (j < cols-1) )
							arr[i][j] = ' ';
					}
				}
				break;
				
			case '8':
				break;

			case '9':
				for (int i = 0; i < rows; i++)
				{
					for (int j = 0; j < cols; j++)
					{
						if ( (i > size) )
						{
							arr[i][0] = ' ';
						}
					}
				}
				break;

		}
	}

	//prints the numbers from an array list of char[][] arrays to screen
	public static void printNums(ArrayList<char[][]> container, int size)
	{
		int height = (2 * size) + 3;
		for (int i = 0; i < height; i++)
		{
			System.out.println(makeString(container, i));
		}
		System.out.println();

	}

	//helper method for printNums...
	//takes a row number and builds a string from the contents of that row
	//number from each array in the container
	public static String makeString(ArrayList<char[][]> container, int row)
	{
		StringBuilder line = new StringBuilder();
		for (char[][] arr : container)
		{
			for (int j = 0; j < arr[row].length; j++)
				line.append(arr[row][j]);
			line.append(' ');
		}
		//trim off last space
		line.deleteCharAt(line.length() - 1);
		String finalstring = line.toString();
		return finalstring;
	}

}

/* @JUDGE_ID: 979449 706 JAVA "LCD numbers" */
/* @END_OF_SOURCE_CODE */

