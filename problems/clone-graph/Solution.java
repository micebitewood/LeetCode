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
            return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        while (queue.size() > 0) {
            UndirectedGraphNode n = queue.poll();
            if (!map.containsKey(n)) {
                UndirectedGraphNode n2 = new UndirectedGraphNode(n.label);
                for (UndirectedGraphNode neighbor : n.neighbors) {
                    n2.neighbors.add(neighbor);
                    queue.add(neighbor);
                }
                map.put(n, n2);
            }
        }
        for (UndirectedGraphNode key : map.keySet()) {
            UndirectedGraphNode n = map.get(key);
            ArrayList<UndirectedGraphNode> list = n.neighbors;
            n.neighbors = new ArrayList<UndirectedGraphNode>();
            for (UndirectedGraphNode neighbor : list) {
                n.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}