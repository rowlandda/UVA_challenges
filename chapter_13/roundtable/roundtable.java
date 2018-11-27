/* @BEGIN_OF_SOURCE_CODE */
import java.text.DecimalFormat;
import java.util.*;

class Main
{
    static DecimalFormat df = new DecimalFormat("0.000");

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        double a, b, c, r, tri_area, s;
        while (input.hasNext())
        {
            a = input.nextDouble();
            b = input.nextDouble();
            c = input.nextDouble();
            s = (a + b + c) / 2;
            tri_area = heron(a, b, c);
            //http://mathworld.wolfram.com/Incircle.html
            if (s > 0.0000001)
                r = tri_area / s;
            else
                r = 0;
            System.out.println("The radius of the round table is: " + df.format(r));
            if (input.hasNext())
                input.nextLine();
        }
    }

    //https://www.mathsisfun.com/geometry/herons-formula.html
    static double heron(double a, double b, double c)
    {
        double s = (a + b + c) / 2;
        return Math.sqrt(s*(s - a)*(s - b)*(s - c));
    }
}
/* @JUDGE_ID: 979449 10195 JAVA "The Knights of the Round Table" */
/* @END_OF_SOURCE_CODE */
