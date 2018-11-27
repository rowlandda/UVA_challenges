/* @BEGIN_OF_SOURCE_CODE */
import java.text.DecimalFormat;
import java.util.*;

class Main
{

    static DecimalFormat df = new DecimalFormat("0.000");

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        while (input.hasNext())
        {
            int size = input.nextInt();

            double gx = input.nextDouble();
            double gy = input.nextDouble();
            Point gopher = new Point(gx, gy);

            double dx = input.nextDouble();
            double dy = input.nextDouble();
            Point dog = new Point(dx, dy);

            Point[] holes = new Point[size];
            for (int i = 0; i < size; i++)
            {
                double x = input.nextDouble();
                double y = input.nextDouble();
                Point hole = new Point(x, y);
                holes[i] = hole;
            }

            boolean updated = false;
            int index = -1;

            for (int i = 0; i < size; i++)
            {
                if ( (canEscape(dog, gopher, holes[i])) && (!updated) )
                {
                    index = i;
                    updated = true;
                }
            }

            if (index == -1)
            {
                System.out.println("The gopher cannot escape.");
            }
            else
            {
                double x = holes[index].x;
                double y = holes[index].y;
                System.out.println("The gopher can escape through the hole at ("
                        + df.format(x) + "," + df.format(y) + ").");
            }
            //burn endl characters if there is more data
            if (input.hasNext())
            {
                input.nextLine();
            }
            if (input.hasNext())
            {
                input.nextLine();
            }
        }
    }

    //distance between 2 points
    static double distance(double x1, double y1, double x2, double y2)
    {
        double x_dist = x2 - x1;
        double y_dist = y2 - y1;
        double dist = Math.sqrt(Math.pow(x_dist, 2) + Math.pow(y_dist, 2));
        return dist;
    }

    //returns true if the dogs distance from the hole is greater than twice that
    //of the gopher
    static boolean canEscape(Point dog, Point gopher, Point hole)
    {
        double dog_dist = distance(dog.x, dog.y, hole.x, hole.y);
        double gopher_dist = distance(gopher.x, gopher.y, hole.x, hole.y);
        return (dog_dist >= (gopher_dist*2));
    }

    static class Point
    {
        double x;
        double y;

        Point(double x, double y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
/* @JUDGE_ID: 979449 10310 JAVA "Dog and Gopher" */
/* @END_OF_SOURCE_CODE */
