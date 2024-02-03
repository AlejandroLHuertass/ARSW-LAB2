package edu.eci.arsw.primefinder;

import java.util.LinkedList;
import java.util.List;

public class PrimeFinderThread extends Thread {

    int a, b, stop;

    private List<Integer> primes;

    public PrimeFinderThread(int a, int b, int TMILISECONDS) {
        super();
        this.primes = new LinkedList<>();
        this.a = a;
        this.stop = TMILISECONDS;
        this.b = b;

    }

    @Override
    public void run() {
        System.out.println("es primo? " + "a " + a + "b " + b);
        for (int i = a; i < b; i++) {

            if (isPrime(i)) {
                primes.add(i);
                System.out.println(i);
            }
        }
        System.out.println("a " + a + "b " + b + primes);

    }

    boolean isPrime(int n) {
        boolean ans;
        if (n > 2) {
            ans = n % 2 != 0;
            for (int i = 3; ans && i * i <= n; i += 2) {
                ans = n % i != 0;
            }
        } else {
            ans = n == 2;
        }
        return ans;
    }

    public List<Integer> getPrimes() {

        return primes;
    }

}
