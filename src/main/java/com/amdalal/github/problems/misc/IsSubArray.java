package com.amdalal.github.problems.misc;

public class IsSubArray {

    public static void main(String args[]) throws Exception {
        int[] arr1 = { 1, 2, 3, 4, 5, 6 };
        int[] arr2 = { 2, 3, 4, 5 };
        System.out.println(find(arr1, arr2));
    }

    private static int find(int[] arr1, int[] arr2) {
        int secondIndex = 0;
        int firstIndex = -1;
        for (int i = 0; i < arr1.length; i++) {
            if (firstIndex == -1) {
                firstIndex = i;
            }
            if (arr1[i] == arr2[secondIndex]) {
                if (secondIndex == arr2.length - 1) {
                    return firstIndex;
                }
                secondIndex++;
            } else {
                secondIndex = 0;
                firstIndex = -1;
            }
        }
        return firstIndex;
    }

}
