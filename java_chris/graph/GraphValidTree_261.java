package graph;

import java.util.*;

public class GraphValidTree_261 {

    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjacentList = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adjacentList.add(new ArrayList<>());
        }

        for (int[] edge: edges){
            adjacentList.get(edge[0]).add(edge[1]);
            adjacentList.get(edge[1]).add(edge[0]);
        }
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> parents = new HashMap<>();
        stack.push(0);
        parents.put(0,-1);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int neighbor : adjacentList.get(node)){
                if (parents.get(node) == neighbor){
                    continue;
                }
                if (parents.containsKey(neighbor)){
                    return false;
                }
                stack.push(neighbor);
                parents.put(neighbor, node);
            }
        }
        return parents.size() == n;
    }
}
