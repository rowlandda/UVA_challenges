/* UVa 10110 "Light, More Light */

#include <iostream>
#include <math.h>
#include <cstdlib>

using namespace std;

bool isPerfectSquare(long n)
{
    double a = sqrt(n);
    long b = (long) a;
    return a == b;
}

int main()
{
    long n;
    cin >> n;
    while (n != 0)
    {
        //if there is an odd number of factors
        if (isPerfectSquare(n))
            cout << "yes" << endl;
        else
            cout << "no" << endl;
        cin >> n;
    }
    return 0;
}

