#include <iostream>
#include <cstdlib>
#include <cmath>
#include <algorithm>

using namespace std;

int MAX_DISTANCE_SQUARED = 100000000;

struct Point
{
    double x, y;
};

bool sortX(Point a, Point b)
{
    if (a.x == b.x)
        return a.y < b.y;
    return a.x < b.x;
}


//doesn't do the sqrt operation to save CPU time
double distance(Point a, Point b)
{
    double dx = a.x - b.x;
    double dy = a.y - b.y;
    dx *= dx;
    dy *= dy;
    return dx + dy;
}


int main()
{
    int N;
    double x, y;
    while(scanf("%d",&N))
    {
        if (N == 0)
            break;
        Point points [N];
        for (int i = 0; i < N; i++)
        {
            cin >> x;
            cin >> y;
            Point p{};
            p.x = x;
            p.y = y;
            points[i] = p;
        }
        sort(points, points+N, &sortX);
        double dist = MAX_DISTANCE_SQUARED;
        double shortest = dist;
        if (N > 1)
        {
            Point a{}, b{};
            int i = 0;
            double x_min;
            while (i < N)
            {
                x_min = points[i].x;
                int j = i;
                while (j < N -1)
                {
                    a = points[i];
                    b = points[j+1];
                    //if our x-dist traveled is greater than max then quit looking
                    if (a.x - x_min > 10000)
                    {
                        break;
                    }
                    else
                    {
                        dist = distance(a, b);
                        if (dist < shortest)
                            shortest = dist;
                    }
                    j++;
                }
                i++;
            }
        }
        dist = shortest;

        if (dist >= MAX_DISTANCE_SQUARED)
            cout << "INFINITY" << endl;
        else
        {
            dist = sqrt(dist);
            printf("%.4lf\n", dist);
        }
    }
    return 0;
}

