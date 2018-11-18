/* @BEGIN_OF_SOURCE_CODE */
import java.util.*;

//high level help from http://www.algorithmist.com/index.php/UVa_10249
public class Main
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int teams, tables;
        while (true)
        {
            teams = input.nextInt();
            tables = input.nextInt();
            if (tables == 0 && teams == 0)
                break;
            if (tables == 0 || teams == 0)
            {
                System.out.println("0");
                break;
            }
            Team[] team_array = new Team[teams];
            Table[] table_array = new Table[tables];
            //values represent the number of people in each team
            for (int i = 0; i < teams; i++)
            {
                Team t = new Team(i, input.nextInt());
                team_array[i] = t;
            }
            //array of the tables with capacity info and table number
            for (int i = 0; i < tables; i++)
            {
                int capacity = input.nextInt();
                Table t = new Table(i + 1, capacity);
                table_array[i] = t;
            }
            printSeating(team_array, table_array);//TODO
        }

    }

    static class Team implements Comparable<Team>
    {
        int number;
        int size;
        int[] seating;

        public Team(int number, int size)
        {
            this.number = number;
            this.size = size;
            seating = new int[size];
        }

        //copy constructor
        public Team(Team copy)
        {
            this.number = copy.number;
            this.size = copy.size;
            this.seating = copy.seating;
        }

        public void setSeating(int[] seating)
        {
            this.seating = seating;
        }

        @Override
        public int compareTo(Team other)
        {
            return other.size - this.size;
        }
    }

    //helper to seat teams and print out results properly
    static void printSeating(Team[] team_array, Table[] table_array)//TODO
    {
        boolean isPossible = true;
        Team[] copy = new Team[team_array.length];
        for (int i = 0; i < team_array.length; i++)
        {
            Team t = new Team(team_array[i]);
            copy[i] = t;
        }
        Arrays.sort(copy);
        for (int i = 0; i < copy.length; i++)
        {
            Arrays.sort(table_array);
            if (copy[i].seating.length <= table_array.length)
            {
                for (int j = 0; j < copy[i].seating.length; j++)
                {
                    int[] arr = copy[i].seating;
                    arr[j] = table_array[j].table_num;
                    table_array[j].addPerson();
                    //if any table capacity drops below 0 the arrangment is impossible
                    if (table_array[j].capacity < 0)
                        isPossible = false;
                }
            }
            else
                isPossible = false;
        }
        if (!isPossible)
            System.out.println("0");
        else
        {
            System.out.println("1");
            for (int i = 0; i < team_array.length; i++)
            {
                int index = copy[i].number;
                Arrays.sort(copy[i].seating);
                team_array[index].setSeating(copy[i].seating);
            }
            for (int i = 0; i < team_array.length; i++)
            {
                for (int j = 0; j < team_array[i].seating.length; j++)
                    if (j < team_array[i].seating.length - 1)
                        System.out.print(team_array[i].seating[j] + " ");
                    else
                        System.out.println(team_array[i].seating[j]);
            }
        }
    }

    //take a team array and sort by team number
    static class Sortbyteam implements Comparator<Team>
    {
        public int compare(Team a, Team b)
        {
            return a.number - b.number;
        }
    }


    static class Table implements Comparable<Table>
    {
        int table_num;
        int capacity;
        int seated;

        public Table(int table_num, int capacity)
        {
            this.table_num = table_num;
            this.capacity = capacity;
            this.seated = 0;
        }

        public void addPerson()
        {
            seated++;
            capacity--;
        }

        @Override
        public int compareTo(Table other)
        {
            return other.capacity - this.capacity;
        }
    }
}
/* @JUDGE_ID: 979449 10249 JAVA "The Grand Dinner" */
/* @END_OF_SOURCE_CODE */
