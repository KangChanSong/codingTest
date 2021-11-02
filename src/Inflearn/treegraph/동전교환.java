package Inflearn.treegraph;

import java.util.*;

class Node{
    int sum;
    int level;
    public Node(int sum, int level){
        this.sum = sum;
        this.level = level;
    }
}

public class 동전교환 {

    static Integer[] coins;
    static int t;
    static int bfs(){
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(0, 0);
        queue.add(root);
        while (true){
            Node node = queue.poll();
            if(node.sum == t) return node.level;
            for(int i = 0; i < coins.length ; i++){
                queue.add(new Node(node.sum + coins[i], node.level+1));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        coins = new Integer[n];
        for(int i = 0 ; i < coins.length ; i++){
            coins[i] = scanner.nextInt();
        }
        Arrays.sort(coins, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? -1 : 1;
            }
        });
        t = scanner.nextInt();
        System.out.println(bfs());
    }
}
