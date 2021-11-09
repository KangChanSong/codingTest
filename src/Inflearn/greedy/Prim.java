package Inflearn.greedy;

import java.util.*;

public class Prim {

    static int V, E;
    static ArrayList<Node>[] adj;
    static class Node implements Comparable<Node>{
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        V = scanner.nextInt();
        E = scanner.nextInt();

        adj = new ArrayList[V + 1];
        for(int i = 1 ; i <= V ; i++) adj[i] = new ArrayList<>();

        for(int i = 0 ; i < E ; i++){
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            int weight = scanner.nextInt();
            adj[node1].add(new Node(node2, weight));
            adj[node2].add(new Node(node1, weight));
        }

        System.out.println(prim());
    }

    static long prim(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V+1];

        int res = 0;

        pq.offer(new Node(1, 0));
        while (!pq.isEmpty()){
            Node edge = pq.poll();
            if(visited[edge.to]) continue;

            res += edge.weight;
            visited[edge.to] = true;

            for(int i = 0 ; i < adj[edge.to].size() ; i++){
                Node next = adj[edge.to].get(i);
                if(visited[next.to] == false) pq.add(next);
            }
        }

        return res;
    }
}
