package lintcode.chapter2;

import java.util.*;

/**
 * 判断是否有且仅有一个能从 seqs重构出来的序列，并且这个序列是org, queue最多只能由一个节点，否则就说明图中有分支，返回false
 */
class LintCode_605_Solution {
    /**
     * @param org:  a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        Map<Integer, Set<Integer>> graph = constructGraph(seqs);

        Map<Integer, Integer> indegreeMap = constructIndegree(graph);

        return topSort(org, graph, indegreeMap);
    }

    private boolean topSort(int[] org, Map<Integer, Set<Integer>> graph, Map<Integer, Integer> indegreeMap) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> nodes = graph.keySet();
        for (Integer node : nodes) {
            if (indegreeMap.containsKey(node))
                continue;
            queue.offer(node);
        }

        int index = 0;
        while (queue.size() == 1) {
            Integer node = queue.poll();
            for (Integer neighbor : graph.get(node)) {
                indegreeMap.put(neighbor, indegreeMap.get(neighbor) - 1);
                if (indegreeMap.get(neighbor) == 0)
                    queue.add(neighbor);
            }
            if (index >= org.length || org[index] != node) return false;
            index++;
        }

        return index == org.length;
    }

    private Map<Integer, Integer> constructIndegree(Map<Integer, Set<Integer>> graph) {
        Map<Integer, Integer> indegreeMap = new HashMap<>();
        Set<Integer> nodes = graph.keySet();
        for (Integer node : nodes) {
            for (Integer neighbor : graph.get(node)) {
                if (indegreeMap.containsKey(neighbor)) {
                    indegreeMap.put(neighbor, indegreeMap.get(neighbor) + 1);
                } else {
                    indegreeMap.put(neighbor, 1);
                }
            }
        }
        return indegreeMap;
    }

    private Map<Integer, Set<Integer>> constructGraph(int[][] seqs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < seqs.length; i++) {
            for (int j = 0; j < seqs[i].length; j++) {
                if (!graph.containsKey(seqs[i][j])) graph.put(seqs[i][j], new HashSet<>());
            }
        }
        for (int[] seq : seqs) {
            for (int i = 1; i < seq.length; i++) {
                graph.get(seq[i - 1]).add(seq[i]);
            }
        }
        return graph;
    }
}

public class LintCode_605_SequenceReconstruction {

    public static void main(String[] args) {
        LintCode_605_Solution solution = new LintCode_605_Solution();
        System.out.println(solution.sequenceReconstruction(new int[]{5, 3, 2, 4, 1}, new int[][]{
                {5, 3, 2, 4}, {4, 1}, {1}, {3}, {2, 4}, {1, 1000000000}
        }));
    }

}
