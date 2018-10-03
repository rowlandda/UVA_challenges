/* @BEGIN_OF_SOURCE_CODE */
import java.util.*;

class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int numCases = 0;
        numCases = Integer.parseInt(input.nextLine());
        //first line is blank
        String inputString = input.nextLine(); //blank line
        ArrayList<Contestant[]> allCases = new ArrayList<>();
        for (int i = 0; i < numCases; i++)
        {
            int id, problem, time;
            char status;
            String[] nums;
            Contestant[] group = new Contestant[101];
            Arrays.fill(group, new Contestant(187));
            while (input.hasNext())
            {
                inputString = input.nextLine();
                if (inputString.equals(""))   { break; }
                inputString = inputString.trim();
                nums = inputString.split(" ");
                if (nums.length != 4) { break; }
                id = Integer.parseInt(nums[0]);
                problem = Integer.parseInt(nums[1]);
                time = Integer.parseInt(nums[2]);
                status = nums[3].charAt(0);
                if (group[id].getID() == 187)
                    group[id] = new Contestant(id);
                else
                    ;
                group[id].addScore(problem, time, status);
            }
            Arrays.sort(group);
            allCases.add(group);
        }
        for (int i = 0; i < allCases.size(); i++)
        {
            for (int j = 0; j < 101; j++)
            {
                if (allCases.get(i)[j].getID() != 187)
                    System.out.println(allCases.get(i)[j].toString());
            }
            if (i < allCases.size() - 1)
                System.out.println();
        }

    }

    static class Contestant implements Comparable<Contestant>
    {
        boolean[] solved = new boolean[10];
        boolean[] incomplete = new boolean[10];
        int[] penaltyTime = new int[10];
        int id;
        int totalTime = 0;
        int numSolved = 0;

        public Contestant (int id)
        {
            this.id = id;
            Arrays.fill(incomplete, false);
            Arrays.fill(solved, false);
            Arrays.fill(penaltyTime, 0);
        }

        public int getID() {return id;}
        public int getNumSolved() {return numSolved;}
        public int getTime() {return totalTime;}

        public  void addScore(int problem, int time, char status)
        {
            if (solved[problem])
                return;
            if ( (incomplete[problem]) && (status == 'I') )
                penaltyTime[problem] += 20;
            if ((!incomplete[problem]) && (status == 'I') )
            {
                incomplete[problem] = true;
                penaltyTime[problem] += 20;
            }
            if ( (!solved[problem] && status == 'C') ||
                    (incomplete[problem] && status == 'C') )
            {
                solved[problem] = true;
                numSolved++;
                totalTime += time;
                totalTime += penaltyTime[problem];
            }
        }

        @Override
        public int compareTo(Contestant c)
        {
            if (this.numSolved == c.getNumSolved())
            {
                if (this.totalTime == c.getTime())
                    return this.id - c.getID();
                return this.totalTime - c.getTime();
            }
            return c.numSolved - this.getNumSolved();
        }
        @Override
        public String toString()
        {
            return "" + id + " " + numSolved + " " + totalTime;
        }

    }
}
/* @JUDGE_ID: 979449 10258 JAVA "Contest Scoreboard" */
/* @END_OF_SOURCE_CODE */
