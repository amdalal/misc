package com.amdalal.github;

import java.util.StringJoiner;

public abstract class ResultHolder {

    private static StringJoiner resultJoiner = new StringJoiner("-");

    public static void clear() {
        resultJoiner = new StringJoiner("-");
    }

    public static String getResult() {
        return resultJoiner.toString();
    }

    public static void append(String str) {
        resultJoiner.add(str);
    }
}
