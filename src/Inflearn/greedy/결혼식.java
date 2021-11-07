package Inflearn.greedy;
import java.util.*;

public class 결혼식 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][73];
        for(int i = 0 ; i < n ; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            arr[i][x] = 1; // arrive
            arr[i][y] = -1; // leave
        }

        System.out.println(solution(arr));
    }

    private static int solution(int[][] arr) {

        int answer = 0;
        int cnt = 0;
        for(int i = 0 ; i <= 72 ; i++){
            for(int x = 0 ; x < arr.length ; x++){
                int i1 = arr[x][i];
                if(i1 == -1) cnt--;
                if(i1 == 1) cnt++;
            }
            answer = Math.max(cnt, answer);
        }

        return answer;
    }
}