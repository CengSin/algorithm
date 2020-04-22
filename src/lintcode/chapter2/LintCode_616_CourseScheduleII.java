package lintcode.chapter2;

import java.util.*;

/**
 * 排课程
 */
class LintCode_616_Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 构造一个图
        Map<Integer, List<Integer>> graph = constructGraph(numCourses, prerequisites);
        // 把图中节点的度都计算出来
        Map<Integer, Integer> indegreeMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            for (Integer neighbor : graph.get(i)) {
                if (indegreeMap.containsKey(neighbor)) {
                    indegreeMap.put(neighbor, indegreeMap.get(neighbor) + 1);
                } else {
                    indegreeMap.put(neighbor, 1);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] res = new int[numCourses];
        int k = 0;
        for (int i = 0; i < numCourses; i++) {
            if (!indegreeMap.containsKey(i)) {
                queue.offer(i);
                res[k++] = i;
            }
        }

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            for (Integer neighbor : graph.get(node)) {
                indegreeMap.put(neighbor, indegreeMap.get(neighbor) - 1);
                if (indegreeMap.get(neighbor) == 0) {
                    queue.add(neighbor);
                    res[k++] = neighbor;
                }
            }
        }
        if(k != numCourses) return new int[]{};
        return res;
    }

    private Map<Integer, List<Integer>> constructGraph(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        return graph;
    }
}

public class LintCode_616_CourseScheduleII {

}
