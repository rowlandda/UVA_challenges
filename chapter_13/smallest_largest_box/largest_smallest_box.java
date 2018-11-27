/* @BEGIN_OF_SOURCE_CODE */
import java.math.RoundingMode;
import java.util.*;
import java.text.DecimalFormat;

class Main
{
    static DecimalFormat df = new DecimalFormat("0.000");

    public static void main(String[] args)
    {
        df.setRoundingMode(RoundingMode.HALF_EVEN);
        Scanner input = new Scanner(System.in);
        double l, w;
        while (input.hasNext())
        {
            l = input.nextDouble();
            w = input.nextDouble();
            //volume function V = (l - 2x)(w - 2x)x
			//make the cooeffecients to the quadratic that is the derivative
            //of the volume function
            double a = 12;
            double b = (2*l) + (2*w);
            b *= -2;
            double c = l * w;
            double[] roots = quadratic(a, b, c);

            double min;
            if (l > w)
                min = w/2+1e-8;//the 1e-8 fixes round-off error for the judge
            else
                min = l/2+1e-8;

            System.out.println(df.format(roots[1]) + " " + "0.000 " + df.format(min));
            if (input.hasNext())
                input.nextLine();

        }
    }
	
	//implementation of the quadratic formula adapted from
	//https://www.sanfoundry.com/java-program-find-roots-quadratic-equation/
    static double[] quadratic(double a, double b, double c)
    {
        double[] answer = new double[2];

        double d = b * b - 4 * a * c;
        if(d > 0)
        {
            double root1 = ( - b + Math.sqrt(d))/(2*a);
            double root2 = (-b - Math.sqrt(d))/(2*a);
            answer[0] = root1;
            answer[1] = root2;
        }
        else if(d == 0)
        {
            double root1 = (-b+Math.sqrt(d))/(2*a);
            answer[0] = root1;
            answer[1] = root1;
        }
        else
        {
            throw new IllegalArgumentException("imaginary roots");
        }
        return answer;
    }

}
/* @JUDGE_ID: 979449 10215 JAVA "The Largest/Smallest Box" */
/* @END_OF_SOURCE_CODE */
