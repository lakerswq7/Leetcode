package search.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> newNodes = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        nodes.add(node);
        newNodes.put(node, new UndirectedGraphNode(node.label));
        
        // construct nodes and clone nodes
        int start = 0;
        while (start < nodes.size()) {
            for (UndirectedGraphNode neighbor : nodes.get(start).neighbors) {
                if (!newNodes.containsKey(neighbor)) {
                    nodes.add(neighbor);
                    newNodes.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }
            }
            start++;
        }
        
        // clone neighbors
        for (UndirectedGraphNode curNode : nodes) {
            UndirectedGraphNode newNode = newNodes.get(curNode);
            for (UndirectedGraphNode neighbor : curNode.neighbors) {
                newNode.neighbors.add(newNodes.get(neighbor));
            }
        }
        return newNodes.get(node);
    }
}
class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
