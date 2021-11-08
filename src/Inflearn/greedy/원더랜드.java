package Inflearn.greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 원더랜드 {

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
        V = scanner.nextInt(); // 도시 개수
        E = scanner.nextInt(); // 도로 개수

        adj = new ArrayList[V+1];
        for(int i = 0; i <= V ; i++) adj[i] = new ArrayList<>();

        for(int i = 0; i < E ; i++){
            int city1 = scanner.nextInt();
            int city2 = scanner.nextInt();
            int weight = scanner.nextInt();
            adj[city1].add(new Node(city2, weight));
            adj[city2].add(new Node(city1, weight));
        }

        System.out.println(prim());
    }

    static long prim(){
        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        long res = 0;
        int cnt = 0;

        pq.add(new Node(1, 0));
        while (!pq.isEmpty()){
            Node edge = pq.poll();
            // 이미 확인한 정점이면 pass
            if(visited[edge.to]) continue;

            res += edge.weight;
            visited[edge.to] = true;

            //모든 노드를 방문했다면 return
            if(++cnt == V) return res;

            for(int i = 0 ; i < adj[edge.to].size() ; i++){
                // 연결된 노드들 중 방문하지 않은 노드 찾기.
                Node next =adj[edge.to].get(i);
                if(visited[next.to]) continue;
                pq.add(next);
            }
        }

        return res;
    }
}
