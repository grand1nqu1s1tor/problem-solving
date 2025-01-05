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
        // We are given node of an undirected graph
        // We have to create a clone of it
        // Nodes in the graph have a list of a neighbors

        Map<Node, Node> oldToNew = new HashMap<>();
        dfs(node, oldToNew);
        return oldToNew.get(node);
    }

    public void dfs(Node oldNode, Map<Node, Node> map) {
        if (oldNode == null)
            return;

        // If we have cloned the node already
        if (map.containsKey(oldNode))
            return;

        Node newNode = new Node(oldNode.val);
        map.put(oldNode, newNode);

        // Explore neighbors of the old node
        for (Node neighbor : oldNode.neighbors) {
            dfs(neighbor, map);


            //Most Confusing Line
            newNode.neighbors.add(map.get(neighbor));

        }
    }
}

/*
Steps for Cloning a Graph Using DFS:

1. Process the Current Node:
   - At the current node, create a new node (clone) with the same value.
   - Add an entry in the map to track the original node and its clone:
     map.put(originalNode, clonedNode);

2. Process Neighbors Recursively:
   - Loop through the neighbors of the current node.
   - For each neighbor:
     - Check if the neighbor is already cloned (exists in the map).
     - If not cloned, recursively call dfs on the neighbor to create its clone.

3. Link Neighbors to the Clone:
   - Once all neighbors are processed, add their clones (from the map)
     to the neighbor list of the cloned node created in Step 1.

Why This Works:
- The map ensures that each node is cloned exactly once.
- The recursion ensures that all nodes and their connections (neighbors) are cloned deeply.
*/