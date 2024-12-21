package classic_algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Greedy_Maze_Cost {

    Integer[][] maze; // cost lookup table
    PriorityQueue<Node> pq;
    Integer[][] maze_best; // unexplored(null) + confirmed cost

    static class Node {
        Integer row;
        Integer col;
        Integer cost;
        public Node(Integer row, Integer col) {
            this.row = row;
            this.col = col;
        }
    }

    static class myComp implements Comparator<Node> {
        @Override
        public int compare(Node node1, Node node2) {
            return node1.cost.compareTo(node2.cost);
        }
    }

    public Greedy_Maze_Cost(Integer[][] maze) {
        this.maze = maze;
        this.pq = new PriorityQueue<Node>(20,new myComp());
        this.maze_best = new Integer[maze.length][maze[0].length];
    }

    public int go_maze(int row_start, int col_start, int row_target, int col_target) {
        Node start = new Node(row_start, col_start);
        start.cost = this.maze[row_start][col_start];
        Node target = new Node(row_target, col_target);
        this.pq.add(start);
        return go_maze(start, target);
    }

    public int go_maze(Node start, Node target) {
        while (!pq.isEmpty()) {
            Node curr_node = pq.poll();

            if (this.maze_best[curr_node.row][curr_node.col] != null) {
                continue;
            }
            // confirm min cost
            this.maze_best[curr_node.row][curr_node.col] = curr_node.cost;

            // explore next node
            if (curr_node.row - 1 >= 0) {
                Node up = new Node(curr_node.row -1, curr_node.col);
                up.cost = curr_node.cost + this.maze[up.row][up.col];
                pq.add(up);
            }
            if (curr_node.row + 1 < maze.length) {
                Node down = new Node(curr_node.row + 1, curr_node.col);
                down.cost = curr_node.cost + this.maze[down.row][down.col];
                pq.add(down);
            }
            if (curr_node.col - 1 >= 0) {
                Node left = new Node(curr_node.row, curr_node.col - 1);
                left.cost = curr_node.cost + this.maze[left.row][left.col];
                pq.add(left);
            }
            if (curr_node.col + 1 < maze[0].length) {
                Node right = new Node(curr_node.row, curr_node.col + 1);
                right.cost = curr_node.cost + this.maze[right.row][right.col];
                pq.add(right);
            }
        }
        return this.maze_best[target.row][target.col];
    }

    public static void main(String[] args) {
        Integer[][] maze = {
                {1,3,1,2,9},
                {7,3,4,9,9},
                {1,7,5,5,3},
                {2,3,4,2,5}
        };
        Greedy_Maze_Cost gm = new Greedy_Maze_Cost(maze);
        int row_start = 0;
        int col_start = 0;
        int row_target = 3;
        int col_target = 4;
        int min_cost = gm.go_maze(row_start, col_start, row_target, col_target);
        System.out.println("Maze min cost is: "+min_cost);
    }
}
