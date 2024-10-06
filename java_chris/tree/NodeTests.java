package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NodeTests {

    static class State {
        Node node;
        int depth;
        public State(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public static void traverse(Node root){
        if (root == null) return;
        System.out.println("Node val: "+ root.val);
        for (Node child : root.children){
            traverse(child);
        }

    }

    public static void levelOrderTraverse_1(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node cur = q.poll();
            System.out.println("Node val: "+cur.val);
            q.addAll(cur.children);
        }
    }

    public static void levelOrderTraverse_2(Node root){
        Queue<Node> q = new LinkedList<>();
        int level = 0;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node cur = q.poll();
                System.out.println("level: "+ level + ", Node val: "+cur.val);
                q.addAll(cur.children);
            }
            level++;
        }
    }

    public static void levelOrderTraverse_3(Node root){
        Queue<State> q = new LinkedList<>();
        State rootState = new State(root, 0);
        int level = 0;
        q.add(rootState);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                State cur = q.poll();
                System.out.println("level: "+ cur.depth + ", Node val: "+ cur.node.val);
                for (Node child : cur.node.children){
                    State childState = new State(child, level+1);
                    q.add(childState);
                }
            }
            level++;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1,new ArrayList<>());
        root.children.add(new Node(2,new ArrayList<>()));
        root.children.add(new Node(3,new ArrayList<>()));
        root.children.add(new Node(4,new ArrayList<>()));
        root.children.get(0).children.add(new Node(5,new ArrayList<>()));
        root.children.get(0).children.add(new Node(6,new ArrayList<>()));
        root.children.get(0).children.add(new Node(7,new ArrayList<>()));
//        traverse(root);
//        levelOrderTraverse_1(root);
//        levelOrderTraverse_2(root);
        levelOrderTraverse_3(root);
    }
}
