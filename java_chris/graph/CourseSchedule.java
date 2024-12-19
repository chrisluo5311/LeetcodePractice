package graph;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {

    static boolean[] onPath;
    static boolean[] visited;
    static boolean hasCycle = false;

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        return !hasCycle;
    }

    public static void traverse(List<Integer>[] graph, int v) {
        if (hasCycle) {
            return;
        }
        if (onPath[v]) {
            hasCycle = true;
            return;
        }
        if (visited[v]) {
            return;
        }
        onPath[v] = true;
        visited[v] = true;
        for (int node : graph[v]) {
            traverse(graph, node);
        }
        onPath[v] = false;
    }

    public static List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int [] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }

        return graph;
    }

    public static void main(String[] args) {
        boolean canFinish = canFinish(2, new int[][]{{0,1},{1,0}});
        System.out.println("canFinish = " + canFinish);
    }
}
