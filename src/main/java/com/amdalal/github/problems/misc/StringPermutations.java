package com.amdalal.github.problems.misc;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (String s : printSubStrings("abcdefg")) {
            System.out.println(s);
        }
        System.out.println("time: " + (System.currentTimeMillis() - start) + " ms");
    }

    public static List<String> printSubStrings(String input) {
        List<String> output = new ArrayList<>();
        for (char c : input.toCharArray()) {
            List<String> combinations = new ArrayList<>();
            combinations.add(String.valueOf(c));
            for (String comb : output) {
                combinations.add(comb + String.valueOf(c));
            }
            output.addAll(combinations);
        }
        return output;
    }

    public static List<String> printPermutations(String input) {
        List<String> combinations = new ArrayList<>();
        int length = input.length();
        if (length == 0) {
            combinations.add("");
            return combinations;
        }
        for (int i = 0; i < length; i++) {
            String left = input.substring(0, i);
            String right = input.substring(i + 1, length);
            for (String comb : printPermutations(left + right)) {
                combinations.add(input.charAt(i) + comb);
            }
        }
        return combinations;
    }
}
