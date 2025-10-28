package graph;

import java.util.ArrayList;
import java.util.HashMap;
/*
// Definition for a Node.
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
*/
public class CloneGraph_133 {
    HashMap<Node,Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }
        if (visited.containsKey(node)){
            return visited.get(node);
        }
        Node cloneNode = new Node(node.val,new ArrayList<>());
        visited.put(node,cloneNode);
        for (Node neighbor : node.neighbors){
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }

    public static void main(String[] args) {
        // [[2,4],[1,3],[2,4],[1,3]]
        CloneGraph_133 cloneGraph = new CloneGraph_133();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        // neighbors
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        Node cloneNode = cloneGraph.cloneGraph(node1);
    }
}
