/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return node;
        Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        while (queue.size() > 0) {
            UndirectedGraphNode temp = queue.poll();
            UndirectedGraphNode newTemp = new UndirectedGraphNode(temp.label);
            set.add(temp);
            for (UndirectedGraphNode neighbor: temp.neighbors) {
                newTemp.neighbors.add(neighbor);
                if (!set.contains(neighbor)) {
                    queue.add(neighbor);
                    set.add(neighbor);
                }
            }
            temp.neighbors.add(newTemp);
        }
        queue.add(node);
        set = new HashSet<UndirectedGraphNode>();
        while (queue.size() > 0) {
            UndirectedGraphNode temp = queue.poll();
            set.add(temp);
            UndirectedGraphNode newTemp = temp.neighbors.get(temp.neighbors.size() - 1);
            ArrayList<UndirectedGraphNode> neighbors = newTemp.neighbors;
            newTemp.neighbors = new ArrayList<UndirectedGraphNode>();
            for (UndirectedGraphNode neighbor: neighbors) {
                if (!set.contains(neighbor)) {
                    queue.add(neighbor);
                    set.add(neighbor);
                }
                UndirectedGraphNode newNeighbor = neighbor.neighbors.get(neighbor.neighbors.size() - 1);
                newTemp.neighbors.add(newNeighbor);
            }
        }
        queue.add(node);
        UndirectedGraphNode newNode = node.neighbors.get(node.neighbors.size() - 1);
        set = new HashSet<UndirectedGraphNode>();
        while (queue.size() > 0) {
            UndirectedGraphNode temp = queue.poll();
            set.add(temp);
            for (int i = 0; i < temp.neighbors.size() - 1; i++) {
                UndirectedGraphNode neighbor = temp.neighbors.get(i);
                if (!set.contains(neighbor)) {
                    queue.add(neighbor);
                    set.add(neighbor);
                }
            }
            temp.neighbors.remove(temp.neighbors.size() - 1);
        }
        return newNode;
    }
}