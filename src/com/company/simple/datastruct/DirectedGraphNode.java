package com.company.simple.datastruct;

import java.util.ArrayList;

/**
 * Graph Data Struct
 */
public class DirectedGraphNode {

    public int label;

    public ArrayList<DirectedGraphNode> neighbors;

    public DirectedGraphNode(int label) {
        this.label = label;
        this.neighbors = new ArrayList<>();
    }
}
