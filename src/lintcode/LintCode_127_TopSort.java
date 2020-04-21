package lintcode;

import com.company.simple.datastruct.DirectedGraphNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class LintCode_127_Solution {

    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // 使用map来统计所有neighbor的入度
        Map<DirectedGraphNode, Integer> midNode = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (midNode.containsKey(neighbor)) {
                    midNode.put(neighbor, midNode.get(neighbor) + 1);
                } else {
                    midNode.put(neighbor, 1);
                }
            }
        }
        // 遍历图的所有结点，找到map中不存在的节点就是入度为0的节点
        // 加入队列
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!midNode.containsKey(node)) {
                queue.offer(node);
                res.add(node);
            }
        }
        // 把队列中的入度为0的点弹出，并吧他们邻居节点的入度-1，一旦出现新的入度为0的节点，则加入队列
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neighbor : node.neighbors) {
                midNode.put(neighbor, midNode.get(neighbor) - 1);
                if (midNode.get(neighbor) == 0) {
                    queue.offer(neighbor);
                    res.add(neighbor);
                }
            }
        }

        return res;
    }

    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSortWrongAnswer(ArrayList<DirectedGraphNode> graph) {
        if (graph == null || graph.size() == 0) return new ArrayList<>();
        // write your code here
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        Set<DirectedGraphNode> visited = new HashSet<>();

        // 统计所有入度为0的点
        for (DirectedGraphNode node : graph) {
            if (node.neighbors.size() == 0 && !visited.contains(node)) {
                queue.offer(node);
                visited.add(node);
            }
        }

        // 将队列中的点一次从队列中取出，并将其邻居的点的入度-1，一旦发现新的入度为0的点，则放入队列，直到队列为空
        ArrayList<DirectedGraphNode> path = new ArrayList<>();
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            path.add(node);
            for (DirectedGraphNode gNode : graph) {
                // 入度-1
                if (gNode.neighbors.contains(node)) {
                    gNode.neighbors.remove(node);
                    if (gNode.neighbors.size() == 0 && !visited.contains(gNode)) {
                        queue.offer(gNode);
                        visited.add(gNode);
                    }
                }
            }
            if (path.size() == graph.size()) {
                break;
            }
        }

        return path;
    }
}

public class LintCode_127_TopSort {

    public static void main(String[] args) {
        LintCode_127_Solution solution = new LintCode_127_Solution();
        DirectedGraphNode startNode = new DirectedGraphNode(0);

        DirectedGraphNode node1 = new DirectedGraphNode(1);
        node1.neighbors.add(startNode);

        DirectedGraphNode node2 = new DirectedGraphNode(2);
        node2.neighbors.add(startNode);

        DirectedGraphNode node3 = new DirectedGraphNode(3);
        node3.neighbors.add(startNode);

        DirectedGraphNode node4 = new DirectedGraphNode(4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node2);
        node4.neighbors.add(node3);

        DirectedGraphNode node5 = new DirectedGraphNode(5);
        node5.neighbors.add(node1);
        node5.neighbors.add(node2);
        node5.neighbors.add(node3);

        ArrayList<DirectedGraphNode> nodes = (ArrayList<DirectedGraphNode>) Stream.of(startNode, node1, node2, node3, node4, node5).collect(Collectors.toList());

        ArrayList<DirectedGraphNode> directedGraphNodes = solution.topSort(nodes);
        for (DirectedGraphNode directedGraphNode : directedGraphNodes) {
            System.out.println(directedGraphNode.label);
        }
    }


}
