package lintcode.chapter2;

import com.company.simple.datastruct.UndirectedGraphNode;

import java.util.*;

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>();
 *     }
 * }
 */
class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        // write your code here
        Set<UndirectedGraphNode> nodes = getNodes(node);

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        for (UndirectedGraphNode undirectedGraphNode : nodes) {
            map.put(undirectedGraphNode, new UndirectedGraphNode(undirectedGraphNode.label));
        }

        for (UndirectedGraphNode n : nodes) {
            UndirectedGraphNode undirectedGraphNode = map.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                undirectedGraphNode.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    private Set<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);

        Set<UndirectedGraphNode> visited = new HashSet<>();
        visited.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode nod = queue.poll();
            for (UndirectedGraphNode neighbor : nod.neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return visited;
    }
}

public class LintCode_137_CloneGraph {
}
