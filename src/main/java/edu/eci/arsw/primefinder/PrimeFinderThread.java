package edu.eci.arsw.primefinder;

import java.util.LinkedList;
import java.util.List;

public class PrimeFinderThread extends Thread{

	
	int a,b;
	
	private List<Integer> primes;
	
	public PrimeFinderThread(int a, int b) {
		super();
                this.primes = new LinkedList<>();
		this.a = a;
		this.b = b;
	}

        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            for (int i = a; i < b; i++) {
                if (isPrime(i)) {
                    primes.add(i);
                    System.out.println(i);
                }
                if (System.currentTimeMillis() - startTime >= Control.TMILISECONDS) {
                    synchronized (Control.lock) {
                        try {
                            Control.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    startTime = System.currentTimeMillis();
                }
            }
        }
	
	boolean isPrime(int n) {
	    boolean ans;
            if (n > 2) { 
                ans = n%2 != 0;
                for(int i = 3;ans && i*i <= n; i+=2 ) {
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
