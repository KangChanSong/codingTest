package BakeJoon.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Location{
    // x, y 좌표를 담는 클래스
    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    int row, col;
}

public class 미로탐색 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static int[][] isVisit; // 거리를 담는 배열
    static int n, m;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][m+1];
        isVisit = new int[n+1][m+1];

        // 입력 값을 배열에 초기화
        for(int i= 1; i <= n ; i++){
            String input = br.readLine();
            for(int j = 1; j <= m ; j++){
                arr[i][j] = input.charAt(j - 1) - '0';
            }
        }
        bfs();
    }

    private static void bfs() {
        Queue<Location> queue = new LinkedList<>();
        // 큐에 시작접 추가
        queue.add(new Location(1, 1));

        // 상하좌우 칸을 표현
        int[] xArr = {-1, 0, 1, 0};
        int[] yArr = {0, 1, 0, -1};

        isVisit[1][1] = 1;

        while (!queue.isEmpty()){
            Location location = queue.poll();
            int row = location.row;
            int col = location.col;

            // 상하좌우 4방향 노드에 대한 작업
            for(int i = 0 ; i < 4 ; i ++){
                int x = row + xArr[i];
                int y = col + yArr[i];

                if(checkLocation(x, y)){
                    // 큐에 인접 노드 추가
                    queue.add(new Location(x, y));
                    // 추가한 노드까지의 거리 = 현재 노드까지의 거리
                    isVisit[x][y]= isVisit[row][col]  + 1;
                }
            }
        }
        System.out.println(isVisit[n][m]);
    }

    static boolean checkLocation(int row, int col){
        // 노드가 범위 밖일때
        if(row < 1 || row > n || col < 1 || col > m) return false;
        // 이미 방문한 노드일 때
        if(isVisit[row][col] != 0 || arr[row][col] == 0) return false;
        return true;
    }

}