/* @BEGIN_OF_SOURCE_CODE */

import java.util.*;

class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        //will contain all of the outputs in string form
        ArrayList<String> outputs = new ArrayList<>();
        while (input.hasNextLine())
        {
            String parseThis = input.nextLine();
            //make sure its not an empty line
            if (parseThis.equals(""))
                break;
            int cases = Integer.parseInt(parseThis);
            if (cases < 1)
                break;
            //create a string representation of the time blocks (i.e. two times per "block". a start
            // and an end
            ArrayList<String> time_blocks = new ArrayList<>();
            for (int i = 0; i < cases; i++)
            {
                String item = input.nextLine();
                String[] item_arr = item.split(" ");
                StringBuilder sb = new StringBuilder();
                sb.append(item_arr[0]);
                sb.append(" ");
                sb.append(item_arr[1]);
                time_blocks.add(sb.toString());
            }
            //go ahead an sort the time blocks to find overlapping times
            Collections.sort(time_blocks);
            //create an arraylist of all the indvidual times
            ArrayList<Time> times = new ArrayList<>();
            for (int i = 0; i < cases; i++)
            {
                String[] item_arr = time_blocks.get(i).split(" ");
                times.add(new Time(item_arr[0]));
                times.add(new Time(item_arr[1]));
            }
            //need to add an 18:00 to the end for this api to calculate intervals correctly
            times.add(new Time("18:00"));
            //if the first time is not 10:00, need to account for the gap at the beginning of schedule
            if (!times.get(0).toString().equals("10:00"))
            {
                Time ten = new Time("10:00");
                times.add(0,ten);
                times.add(0, ten);
                cases++;
            }
            //fix overlaps
            int j = 1;
            for (int i = 0; i < cases-1; i++)
            {
                if ((times.get(j+1).total_minutes) < (times.get(j).total_minutes) )
                {
                    times.get(j+1).total_minutes = times.get(j).total_minutes;
                    if ( (times.get(j+1).total_minutes) > (times.get(j+2).total_minutes) )
                        times.get(j+2).total_minutes = times.get(j+1).total_minutes;
                }
                j+=2;
            }
            Time[] naptimes = new Time[cases];
            int x = 1;
            for (int i = 0; i < cases; i++)
            {
                Time t = times.get(x+1).subtract(times.get(x));
                naptimes[i] = t;
                x+=2;
            }
            //make a copy of naptimes to find the location of the longest interval
            Time[] naptimes_copy = naptimes.clone();
            Arrays.sort(naptimes_copy);
            //finding the index of the starting time with some fuzzy math
            int index = 0;
            while (naptimes[index].total_minutes != naptimes_copy[cases-1].total_minutes)
                index++;
            //naptimes_copy[cases -1] is the max nap time and times.get(index*2 +1) is the start time
            int max_nap_time = naptimes_copy[cases - 1].total_minutes;
            String time_string = times.get(index*2 + 1).toString();
            int hours = max_nap_time / 60;
            int minutes = max_nap_time % 60;
            String result;
            if (hours == 0)
            {
                result = time_string + " and will last for " + minutes + " minutes.";
            }
            else
            {
                result = time_string + " and will last for " + hours + " hours and " + minutes + " minutes.";
            }
            outputs.add(result);
        }
        int i = 1;
        for (String line : outputs)
        {
            System.out.println("Day #" + i + ": the longest nap starts at " + line);
            i++;
        }
        System.exit(0);
    }

    static class Time implements Comparable<Time>
    {
        int total_minutes;

        public Time(int mins)
        {
            this.total_minutes = mins;
        }
        //takes a string in format 12:12 and creates a new time object
        public Time(String time_string)
        {
            String[] time_arr = time_string.split(":");
            int hour = Integer.parseInt(time_arr[0]);
            int minutes = Integer.parseInt(time_arr[1]);
            this.total_minutes = (60 * hour) + minutes;
        }
        //creates a new time object from the difference of this.Time and other.Time
        public Time subtract(Time other)
        {
            Time time = new Time(this.total_minutes - other.total_minutes);
            return time;
        }

        @Override
        public int compareTo(Time other)
        {
            return this.total_minutes - other.total_minutes;
        }

        @Override
        public String toString()
        {
            int hours = total_minutes / 60;
            int minutes = total_minutes % 60;
            //if minutes less than 10 we need to insert a 0 char to look correct
            if (minutes < 10)
                return "" + hours + ":0" + minutes;
            return "" + hours + ":" + minutes;
        }

    }
}
/* @JUDGE_ID: 979449 10191 JAVA "Longest Nap" */
/* @END_OF_SOURCE_CODE */
