package com.amdalal.github.algorithms.sort.primes;

import org.junit.Assert;
import org.junit.Test;

import com.amdalal.github.algorithms.primes.impl.SieveOfEratosthenes;

public class TestSieveOfEratosthenes {

    @Test
    public void testSieveOfEratosthenes() {
        SieveOfEratosthenes sieve = new SieveOfEratosthenes(100);
        Assert.assertTrue(sieve.isPrime(11));
        Assert.assertTrue(sieve.isPrime(13));
        Assert.assertTrue(sieve.isPrime(53));
        Assert.assertTrue(sieve.isPrime(79));

        Assert.assertFalse(sieve.isPrime(99));
        Assert.assertFalse(sieve.isPrime(55));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test2() {
        new SieveOfEratosthenes(5).isPrime(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test3() {
        new SieveOfEratosthenes(0);
    }
}