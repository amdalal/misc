package com.amdalal.github.problems.misc;

public class CommonAncestor {

    public static Node find(Node a, Node b) {
        int ha = findDepth(a);
        int hb = findDepth(b);
        Node taller = b, shorter = a;
        if (ha > hb) {
            taller = a;
            shorter = b;
        }
        return find(taller, Math.max(ha, hb), shorter, Math.min(ha, hb));
    }

    private static int findDepth(Node n) {
        int depth = 0;
        while (n.parent != null) {
            depth++;
            n = n.parent;
        }
        return depth;
    }

    private static Node find(Node taller, int tallerHeight, Node shorter, int shorterHeight) {
        Node n1 = taller;
        Node n2 = shorter;
        for (int i = 0; i < (tallerHeight - shorterHeight); i++) {
            n1 = n1.parent;
        }
        while (!n1.equals(n2)) {
            n1 = n1.parent;
            n2 = n2.parent;
        }
        return n1;
    }
}
