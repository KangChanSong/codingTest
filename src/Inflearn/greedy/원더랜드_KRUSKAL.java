package Inflearn.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class 원더랜드_KRUSKAL {

    static int V, E, parents[];
    static Edge[] edgeList;

    static class Edge implements Comparable<Edge>{
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        V = scanner.nextInt(); // 정점 개수
        E = scanner.nextInt(); // 간선 개수

        edgeList = new Edge[E];
        parents = new int[V + 1];

        // Edge 정보 입력
        for(int i = 0 ; i < E ; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            edgeList[i] = new Edge(a, b, c);
        }

        System.out.println(kruskal());
    }

    static int kruskal(){
        int res = 0, cnt = 0;

        // 간선 가중치 기준 오름차순 정렬
        Arrays.sort(edgeList);
        // 정점 초기화
        make();
        
        // 주어진 간선을 이어보면서
        for(Edge edge : edgeList){
            // 싸이클이 형성되지 않는다면
            if(union(edge.from, edge.to)){
                // 해당 간선을 사용
                res += edge.weight;
                if(++cnt == V-1) return res;
            }
        }
        return res;
    }

    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;
        parents[aRoot] = bRoot;
        return true;
    }

    private static int find(int a) {
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    private static void make(){
        for(int i = 1; i <= V ; i++){
            parents[i] = i;
        }
    }
}
