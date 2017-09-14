package com.amdalal.github.problems.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clone an undirected graph
 */
public class CloneGraph {

    public static void main(String[] args) {
        CloneGraph s = new CloneGraph();
        UndirectedGraphNode ten = new UndirectedGraphNode(10);
        UndirectedGraphNode twenty = new UndirectedGraphNode(20);
        UndirectedGraphNode thirty = new UndirectedGraphNode(30);

        ten.neighbors.add(twenty);
        ten.neighbors.add(thirty);

        twenty.neighbors.add(ten);
        twenty.neighbors.add(thirty);

        thirty.neighbors.add(ten);
        thirty.neighbors.add(twenty);

        UndirectedGraphNode snew = s.cloneGraph(ten);
        System.out.println("done");
    }

    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        Map<Integer, UndirectedGraphNode> seen = new HashMap<>();
        return clone(node, seen);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> seen) {
        if (node == null)
            return null;
        if (!seen.containsKey(node.label)) {
            UndirectedGraphNode clonedNode = new UndirectedGraphNode(node.label);
            seen.put(node.label, clonedNode);
            for (int i = 0; i < node.neighbors.size(); i++) {
                UndirectedGraphNode neighbor = node.neighbors.get(i);
                UndirectedGraphNode clonedNeighbor = clone(neighbor, seen);
                clonedNeighbor.neighbors.add(clonedNode);
                clonedNode.neighbors.add(clonedNeighbor);
            }
            return clonedNode;
        } else {
            return seen.get(node.label);
        }
    }

    static class UndirectedGraphNode {
        int                       label;
        List<UndirectedGraphNode> neighbors = new ArrayList<>();

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }
}