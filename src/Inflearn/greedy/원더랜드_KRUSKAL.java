package Inflearn.greedy;

import java.util.Arrays;
import java.util.Scanner;

// Greedy 알고리즘.
// 작은 값부터 tree 가 만들어질때까지 축 탐색하면 됨
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

        Arrays.sort(edgeList);
        make();

        for(Edge edge : edgeList){
            if(union(edge.from, edge.to)){
                res += edge.weight;
                cnt ++;
            }
            if(cnt >= V-1) break;
        }

        return res;
    }

    private static void make() {
        for(int i = 1 ; i <= V ; i++){
            parents[i]= i;
        }
    }

    static boolean union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa == fb) return false;
        parents[fa] = fb;
        return true;
    }

    private static int find(int a) {
        if(a == parents[a]) return a;
        else return parents[a] = find(parents[a]);
    }
}
