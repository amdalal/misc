package com.amdalal.github.problems.tc;

/**
 * Problem Statement You are given two s: N and K.
 * Lun the dog is interested in strings that satisfy the following conditions:
 * The string has exactly N characters, each of which is either 'A' or 'B'. The string s has exactly K pairs
 * (i, j) (0 <= i < j <= N-1) such that s[i] = 'A' and s[j] = 'B'. If there exists a string that satisfies the
 * conditions, find and return any such string. Otherwise, return an empty string. Definition Class: AB Method:
 * createString Parameters: int, int Returns: String Method signature: String createString(int N, int K) (be sure your
 * method is public) Limits Time limit (s): 2.000 Memory limit (MB): 256 Constraints - N will be between 2 and 50,
 * inclusive. - K will be between 0 and N(N-1)/2, inclusive. Examples 0) 3 2 Returns: "ABB" This string has exactly two
 * pairs (i, j) mentioned in the statement: (0, 1) and (0, 2). 1) 2 0 Returns: "BA" Please note that there are valid
 * test cases with K = 0. 2) 5 8 Returns: "" Five characters is too short for this value of K. 3) 10 12 Returns:
 * "BAABBABAAB"
 */
public class AB {

    public String createString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        if ((n % 2 == 0 && k <= (n * n / 4)) || (n % 2 != 0 && k <= ((n + 1) * (n - 1) / 4))) {
            build(n, k, n, k, sb, 0);
        }
        return sb.toString();
    }

    private void build(int availablePositions, int target, int n, int k, StringBuilder sb, int counter) {
        if (target < availablePositions) {
            for (int i = 0; i < availablePositions - target - 1; i++) {
                sb.append("B");
            }
            sb.append("A");
            for (int i = 0; i < target; i++) {
                sb.append("B");
            }
        } else {
            sb.append("A");
            counter++;
            target = k - (n - counter) * counter + counter;
            availablePositions = availablePositions - 1;
            build(availablePositions, target, n, k, sb, counter);
        }
    }
}
