/*
A program that uses the Sieve of Eratosthenes to compute an array of prime numbers under a certain number maxNum.
The Sieve of Eratosthenes starts with 2 and filters out its multiples up to maxNum, then continues
with the multiples of the following numbers.

Emily Lagattolla June 2019
*/

java.math.BigInteger

BigInteger maxNum = 5000

public static void main(maxNum) {

  // Declare the boolean array mySieve.
  boolean[] mySieve = new boolean[maxNum];

  initialize(mySieve);
  sieve(mySieve);
  printSieve(mySieve);

  // Initialize mySieve boolean array to true, where true indicates "is prime."
  public void initialize(mySieve) {
    for (BigInteger i = 0; i < maxNum; i++) {
      mySieve[i] = true;
    }
  }

  // Compute the list of prime numbers via the algorithm.
  public void sieve(mySieve) {

    // By definition, 1 is not prime.
    mySieve[0] = false;

    // Set divisor = 2 since we have already hard coded 1 as composite.
    for(BigInteger divisor = 2; divisor < maxNum; divisor++) {

      // Only execute the i loop if the current divisor is prime.
      // If it were composite, we would have already seen it and its multiples.
      // The index of [divisor - 1] evaluates to the divisor itself.
      if (mySieve[divisor - 1] == true) {
        for (BigInteger i = 0; i < (maxNum / divisor); i++) {
          // The index of [divisor + (divisor * (i + 1)) - 1] evaluates to the next in the line of multiples.
          mySieve[divisor + (divisor * (i + 1)) - 1] = false;
        }
      }
    }
  }

  // Create a new array for only the prime numbers and print it.
  public void printSieve(mySieve) {
    BigInteger[] primes = new BigInteger[];

    for (BigInteger i = 0; i < maxNum; i++) {
      if (mySieve[i] == true) {
        primes.add(i + 1);
      }
    }

    System.out.println(primes);
  }
}
