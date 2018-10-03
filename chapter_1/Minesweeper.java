/* @BEGIN_OF_SOURCE_CODE */
import java.util.ArrayList;
import java.util.Scanner;

//change class name to "Main" for judge
class Main
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		//create an arraylist to hold all the 2d array gameboards
  		ArrayList<char[][]> container = new ArrayList<char[][]>();
		int rows = input.nextInt();
		int cols = input.nextInt();
		//user input loops until the user tries to create a 0x0 grid
		while (input.hasNext())
		{
			char[][] gameboard = makeBoard(rows, cols);
			getUserInput(gameboard, rows, cols, input);
			transformBoard(gameboard, rows, cols);
			container.add(gameboard);
			rows = input.nextInt();
			cols = input.nextInt();
			//terminating condition of while loop
			if ((rows == 0) && (cols == 0))
				break;
		}
		//print all the boards according to problem spec
		int fieldnum = 1;
		for (char[][] arr : container)
		{
			outputPretty(arr, fieldnum);
			//only have a line break between the fields not at the end
			if (fieldnum < container.size())
				System.out.println();			
			fieldnum++;
		}
		
		System.exit(0);					
	}
	
	//return an array representing the game board. made 2 col and 2 rows larger
	//to prevent array out of bounds behavior later when checking mine location
	private static char[][] makeBoard(int rows, int cols)
	{
		char[][] gameboard = new char[rows+2][cols+2];
		for (int i = 0; i < rows+2; i++)
		{
			for (int j = 0; j < cols+2; j++)
				gameboard[i][j] = '.';
		}
		return gameboard;
	}

	//get and store user input in the gameboard char array
	private static void 
		getUserInput(char[][] gameboard, int rows, int cols, Scanner input)
	{
		for (int i = 0; i <= rows ; i++)
		{
			String update = input.nextLine();
			for (int j = 0 ; j < update.length() ; j++)
			{
				gameboard[i][j+1] = update.charAt(j);
			}
		}
	}

	//change the gameboard to show the number of mines
	private static void transformBoard(char[][] gameboard, int rows, int cols)
	{
		int mines = 0;
		for (int i = 1; i <= rows ; i++ )
		{
			for (int j = 1 ; j <= cols ; j++)
			{
				//check every adjacent position for a mine and 
				//update the count if indicated
				if (gameboard[i+1][j] == '*')
					mines++;
				if (gameboard[i-1][j] == '*')
					mines++;
				if (gameboard[i][j+1] == '*')
					mines++;
				if (gameboard[i][j-1] == '*')
					mines++;
				if (gameboard[i+1][j+1] == '*')
					mines++;
				if (gameboard[i+1][j-1] == '*')
					mines++;
				if (gameboard[i-1][j-1] == '*')
					mines++;
				if (gameboard[i-1][j+1] == '*')
					mines++;
				//cast number of mines to a char for insertion
				// into gameboard array
				char num = Character.forDigit(mines, 10);
				//this checks to see if the location is a mine and in that case
				//we do nothing and leave it as a mine
				if (gameboard[i][j] == '*')
					;
				//otherwise we update the location with the number of adjacent
				//mines
				else
					gameboard[i][j] = num;
				mines = 0;
			}
		}
	}		

	//output made to problem specifications
	private static void outputPretty(char[][] gameboard, int fieldnum)
	{
		System.out.println("Field #" + fieldnum + ":");	
		int rows = gameboard.length;
		int cols = gameboard[0].length;
		for (int i = 1; i < rows - 1; i++)
		{
			for (int j = 1; j < cols - 1 ; j++)
			{
				System.out.print(gameboard[i][j]);
			}
			System.out.println();
		}
	}
}


/* @JUDGE_ID: 979449 10189 JAVA "Minesweeper" */
/* @END_OF_SOURCE_CODE */

