package com.amdalal.github.problems.dp;

public class Stairs {

    public static int numberOfWays(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1];
            if (i >= 2) {
                cache[i] += Math.max(cache[i - 2], 1);
            }
            if (i >= 3) {
                cache[i] += Math.max(cache[i - 3], 1);
            }
        }
        return cache[n];
    }
}
