package com.amdalal.github.problems.tc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class Entry {
    String userId;
    String productId;

    public Entry(String userId, String productId) {
        this.userId = userId;
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Entry{" + "userId='" + userId + '\'' + ", productId='" + productId + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Entry entry = (Entry) o;
        return Objects.equals(userId, entry.userId) && Objects.equals(productId, entry.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, productId);
    }
}

public class Analyzer {

    public static void main(String[] args) {
        String[] l1 = new String[2];
        l1[0] = "u1$p1";
        l1[1] = "u1$p2";
        String[] l2 = new String[2];
        l2[0] = "u2$p1";
        l2[1] = "u1$p2";
        String[] l3 = new String[2];
        l3[0] = "u2$p1";
        l3[1] = "u1$p3";
        String[] l4 = new String[2];
        l4[0] = "u1$p2";
        l4[1] = "u1$p3";
        List<String[]> lst = new ArrayList<>();
        lst.add(l1);
        lst.add(l2);
        lst.add(l3);
        lst.add(l4);
        Analyzer a = new Analyzer();
        System.out.println(a.analyze(lst));
    }

    private Map<Entry, Integer> visitsData = new HashMap<>();

    public List<Entry> analyze(List<String[]> data) {
        List<Entry> output = new ArrayList<>();
        int dayCount = 0;
        for (String[] strArr : data) {
            dayCount++;
            for (String log : strArr) {
                Entry e = prepareEntry(log);
                Integer lastFoundDay = visitsData.get(e);
                if (lastFoundDay == null) {
                    visitsData.put(e, dayCount);
                } else if (lastFoundDay != -1) {
                    int dayDiff = dayCount - lastFoundDay;
                    if (dayDiff == 1) {
                        output.add(e);
                        visitsData.put(e, -1);
                    } else if (dayDiff > 1) {
                        visitsData.put(e, dayCount);
                    }
                }
            }
        }
        return output;
    }

    private Entry prepareEntry(String log) {
        String[] arr = log.split("\\$");
        Entry e = new Entry(arr[0], arr[1]);
        return e;
    }
}
