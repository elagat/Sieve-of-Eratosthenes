/*
 A program that uses the Sieve of Eratosthenes to compute an array of prime numbers under a certain number maxNum.
 The Sieve of Eratosthenes starts with 2 and filters out its multiples up to maxNum, then continues
 with the multiples of the following numbers.

 Emily Lagattolla June 2019
 */

public class sieve {

  public static void main(String[] args) {
    int maxNum = Integer.parseInt(args[0]) + 1;

    // Declare the boolean array mySieve.
    boolean[] mySieve = new boolean[maxNum];

    initialize(mySieve);
    sieve(mySieve);
    printSieve(mySieve);
  }

  // Initialize mySieve boolean array to true, where true indicates "is prime."
  public static void initialize(boolean[] mySieve) {
    for (int i = 0; i < mySieve.length; i++) {
      mySieve[i] = true;
    }
  }

  // Compute the list of prime numbers via the algorithm.
  public static void sieve(boolean[] mySieve) {

    mySieve[0] = false;
    mySieve[1] = false;

    for(int divisor = 2; divisor < mySieve.length; divisor++) {

      // Only execute the i loop if the current divisor is prime.
      // If it were composite, we would have already seen it and its multiples.
      if (mySieve[divisor] == true) {
        for (int i = 2; i * divisor < mySieve.length; i++) {
          mySieve[divisor * i] = false;
        }
      }
    }
  }


  public static void printSieve(boolean[] mySieve) {

    for (int i = 1; i < mySieve.length; i++) {
      if (mySieve[i] == true) {
        System.out.print(i + " ");
      }
    }
  }
}
