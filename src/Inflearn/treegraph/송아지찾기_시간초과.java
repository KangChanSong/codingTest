package Inflearn.treegraph;

import java.util.*;

public class 송아지찾기_시간초과 {

    static int destination;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        destination = scanner.nextInt();
        solution(start);
    }

    static void solution(int start){
        System.out.println(bfs(start));
    }

    static int bfs(int n){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 0));
        boolean flag = true;
        Node result = null;
        while (flag){
            Node node = queue.poll();
            if(node.isMarked == false){
                node.isMarked = true;
                queue.add(new Node(node.data - 1, node.level + 1));
                queue.add(new Node(node.data + 1 , node.level + 1));
                queue.add(new Node(node.data + 5, node.level +1));
            }
            if(node.data == destination){
                flag = false;
                result = node;
            }
        }

        return result.level;
    }

    static class Node{
        int data;
        int level;
        boolean isMarked;
        Node(int data, int level){
            this.data = data;
            this.level = level;
            isMarked = false;
        }
    }
}
