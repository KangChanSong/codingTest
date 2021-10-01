package Inflearn.StackAndQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Q3 {
    private static List<Stack<Integer>> convert(int[][] arr){
        List<Stack<Integer>> list = new ArrayList<>();
        for(int i = 0; i < arr.length ; i++){

            Stack<Integer> stack = new Stack<>();

            for(int j = arr.length-1 ; j >= 0 ; j--){
                int x = arr[j][i];
                if(x != 0){
                    stack.push(x);
                }

            }

            list.add(stack);
        }

        return list;
    }
    private static int solution(int[][] board, int[] moves){

        List<Stack<Integer>> list = convert(board);

        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for(int i = 0 ; i < moves.length ; i++){
            Stack<Integer> s = list.get(moves[i] - 1);
            if(!s.isEmpty()){
                int picked = s.pop();
                int curr = 0;
                if(!stack.isEmpty()) curr = stack.pop();
                System.out.println(curr);
                if(picked != curr){
                    stack.push(curr);
                    stack.push(picked);
                } else {
                    count++;
                }
            }
        }


        return count;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[][] board = makeBoard(scanner);
        int[] moves = makeMoves(scanner);
        System.out.println(solution(board, moves));
    }

    private static int[][] makeBoard(Scanner scanner){
        int n = scanner.nextInt();
        int[][] board = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        return board;
    }

    private static int[] makeMoves(Scanner scanner){
        int n = scanner.nextInt();
        int[] moves = new int[n];
        for(int i = 0 ; i < n ; i++){
            moves[i] = scanner.nextInt();
        }
        return moves;
    }

}
