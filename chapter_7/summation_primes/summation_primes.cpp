/* UVa problem 10168 "Summation of Four Primes" */

#include <iostream>
#include <vector>
#include <cstdlib>
#include <cmath>
#include <cstring>

using namespace std;

//generate an array of prime numbers from 2 - n using sieve of
// eratosthenes
//https://www.geeksforgeeks.org/sieve-of-eratosthenes/
bool * primes(int n)
{
    // Create a boolean array "prime[0..n]" and initialize
    // all entries it as true. A value in prime[i] will
    // finally be false if i is Not a prime, else true.
    bool* isPrime = new bool[n+1];
    for (int i = 0; i < n+1; i++)
        isPrime[i] = true;

    for(int p = 2; p*p <=n; p++)
    {
        // If prime[p] is not changed, then it is a prime
        if(isPrime[p])
        {
            // Update all multiples of p
            for(int i = p*2; i <= n; i += p)
                isPrime[i] = false;
        }
    }
    return isPrime;
}

//prints out the two non-trivial prime numbers
void getPrimes(int n, bool *isPrime)
{
    //all even numbers start with sequence 2, 2
    if (n % 2 == 0)
        n -= 4;
    //all odd numbers start with 2,3
    else
        n -= 5;

    for (int i = n/2; i >= 2; i--)
    {
        if (isPrime[i] && isPrime[n-i])
        {
           printf("%d %d", i, n -i);
           return;
        }
    }
}

int main()
    {
        //use sieve to make a cache of primes
        bool* isPrime = primes(10000001);
        int n;
        while ( cin >> n )
        {
            // two is smallest prime so anything less than 8 is impossible
            if (n < 8)
                cout << "Impossible." << endl;
            else
            {
                //even numbers
                if (n % 2 == 0) {
                    cout << "2 2 ";
                    getPrimes(n, isPrime);
                    cout << endl;
                }
                //odd
                else
                {
                    cout << "2 3 ";
                    getPrimes(n, isPrime);
                    cout << endl;
                }
            }
        }
        return 0;
    }
