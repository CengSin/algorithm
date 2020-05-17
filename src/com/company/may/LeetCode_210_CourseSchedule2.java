package com.company.may;

import java.util.*;

/**
 * 拓扑排序
 * <p>
 * 找到所有入度为0的点，把这些点加入队列，然后
 */
class LeetCode_210_Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = createGraph(numCourses, prerequisites);

        Map<Integer, Integer> indegreeMap = calcIndegree(numCourses, graph);

        Queue<Integer> queue = new LinkedList<>();
        int[] res = new int[numCourses];
        int k = 0;

        // 查询没有前置课程的课程
        for (int i = 0; i < numCourses; i++) {
            if (!indegreeMap.containsKey(i)) {
                queue.offer(i);
                res[k++] = i;
            }
        }

        // 拓扑排序
        while (!queue.isEmpty()) {
            Integer point = queue.poll();
            for (Integer neibor : graph.get(point)) {
                indegreeMap.put(neibor, indegreeMap.get(neibor) - 1);
                if (indegreeMap.get(neibor) == 0) {
                    queue.offer(neibor);
                    res[k++] = neibor;
                }
            }
        }

        // 不存在拓扑排序
        if (k != numCourses) return new int[]{};

        return res;
    }

    /**
     * 计算每门课的前置课程的数量
     *
     * @param numCourses n门课，从0~n-1
     * @param graph      n门课的前置课程图
     * @return 每门课的前置课程的数量集合
     */
    private Map<Integer, Integer> calcIndegree(int numCourses, Map<Integer, List<Integer>> graph) {

        Map<Integer, Integer> indegreeMap = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            for (Integer neibor : graph.get(i)) {
                indegreeMap.put(neibor, indegreeMap.getOrDefault(neibor, 0) + 1);
            }
        }

        return indegreeMap;
    }

    /**
     * 通过前置课程的输入参数构造一个图
     *
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    private Map<Integer, List<Integer>> createGraph(int numCourses, int[][] prerequisites) {
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

public class LeetCode_210_CourseSchedule2 {
}
