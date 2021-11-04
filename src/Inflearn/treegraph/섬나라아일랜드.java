package Inflearn.treegraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 섬나라아일랜드 {

    static int[][] arr;
    static int[][] dp;
    static int answer = 0;

    static int[] dx = {-1, 0, 1, 0, 1, -1, 1, -1};
    static int[] dy = {0, -1, 0, 1, 1, 1, -1, 1};

    static void solution(){
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr.length ; j++){
                if(arr[i][j] == 1 && dp[i][j] == 0){
                    answer++;
                    dp[i][j] = 1;
                    bfs(i, j);
                }
            }
        }
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private static void bfs(int i, int j) {

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        while (!queue.isEmpty()){
            Point point = queue.poll();
            for(int n = 0 ; n < dx.length ; n++){
                int x = point.x + dx[n];
                int y = point.y + dy[n];
                if(x >= 0 && x < arr.length && y >= 0 && y < arr.length && arr[x][y] == 1 && dp[x][y] == 0){
                    queue.add(new Point(x, y));
                    dp[x][y] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arr = new int[n][n];
        dp = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        solution();
        System.out.println(answer);
    }
}
