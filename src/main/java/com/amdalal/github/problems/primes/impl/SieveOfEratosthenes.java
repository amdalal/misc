package com.amdalal.github.problems.primes.impl;

import com.amdalal.github.problems.primes.Primes;

/**
 * All numbers are prime unless proven otherwise.
 */
public class SieveOfEratosthenes implements Primes {

    private int max;

    private boolean[] primes;

    public SieveOfEratosthenes(int max) {
        if (max <= 1) {
            throw new IllegalArgumentException();
        }
        this.max = max;
        this.primes = new boolean[max + 1];
        for (int i = 0; i <= max; i++) {
            primes[i] = true;
        }

        for (int i = 2; i * i <= max; i++) {
            for (int j = 2 * i; j <= max; j = j + i) {
                primes[j] = false;
            }
        }
    }

    @Override
    public boolean isPrime(final int numberToTest) {
        if (numberToTest > max) {
            throw new IllegalArgumentException();
        }
        return primes[numberToTest];
    }
}


