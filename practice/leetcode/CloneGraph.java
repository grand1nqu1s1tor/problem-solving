package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Definition for a leetcode.Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class CloneGraph {
    public Node cloneGraph(Node node) {
        // EDGE CASE
        if (node == null) {
            return null;
        }
        //Create a map mapping Old Nodes to New Nodes
        Map<Node, Node> encountered = new HashMap<>();
        return dfsClone(node, encountered);
    }

    public Node dfsClone(Node node, Map<Node, Node> encountered) {

        // Base Case : Return new node(value) mapped to the old node(key)
        if (encountered.containsKey(node))
            return encountered.get(node);

        // Clone the current node (create a new node with the same value)
        Node clonedNode = new Node(node.val);
        encountered.put(node, clonedNode); // Store the new cloned node in the map

        // recursively through the neighbors of the current leetcode.Node
        for (Node neighbor : node.neighbors) {
            // Add the cloned neighbor to the current cloned node's neighbors
            clonedNode.neighbors.add(dfsClone(neighbor, encountered));
        }
        return clonedNode;
    }
}