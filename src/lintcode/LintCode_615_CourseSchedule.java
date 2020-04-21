package lintcode;

import java.util.*;

class LintCode_615_Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) return true;

        // 构造一个图，判断图中有没有拓扑排序即可
        Map<Integer, List<Integer>> graph = createGraph(numCourses, prerequisites);

        // 构造点的入度map
        Map<Integer, Integer> simpleMap = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            for (Integer neighbor : graph.get(i)) {
                if (simpleMap.containsKey(neighbor)) {
                    simpleMap.put(neighbor, simpleMap.get(neighbor) + 1);
                } else {
                    simpleMap.put(neighbor, 1);
                }
            }
        }

        // 寻找图中入度为0的节点 加入队列
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!simpleMap.containsKey(i)) {
                queue.offer(i);
                visited.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            for (Integer neighbor : graph.get(node)) {
                simpleMap.put(neighbor, simpleMap.get(neighbor) - 1);
                if (simpleMap.get(neighbor) == 0) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return visited.size() == numCourses;
    }

    private Map<Integer, List<Integer>> createGraph(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        return graph;
    }
}

public class LintCode_615_CourseSchedule {

    public static void main(String[] args) {
        LintCode_615_Solution solution = new LintCode_615_Solution();
        System.out.println(solution.canFinish(2, new int[][]{{1, 0}}));
    }

}
