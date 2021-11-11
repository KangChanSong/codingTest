package Inflearn.dp;

import java.util.*;

public class 가장높은탑쌓기_오답 {

    static class Brick implements Comparable<Brick>{
        int width;
        int height;
        int weight;
        int maxPossible;
        public Brick(int width, int height, int weight) {
            this.width = width;
            this.height = height;
            this.weight = weight;
            this.maxPossible = 0;
        }

        @Override
        public int compareTo(Brick o) {
            return o.width - this.width;
        }

        @Override
        public String toString() {
            return "Brick{" +
                    "width=" + width +
                    ", height=" + height +
                    ", weight=" + weight +
                    ", maxPossible=" + maxPossible +
                    '}';
        }
    }

    static int answer;
    static void solution(ArrayList<Brick> arr){
        // 밑면의 넓이 순
        Collections.sort(arr);
        int res = recurse1(arr, 0);
        if(answer < res) answer = res;
        arr.forEach(System.out::println);
        System.out.println(answer);
    }

    private static int recurse1(ArrayList<Brick> arr, int i) {
        Brick brick = arr.get(i);
        for(int j = i+1 ; j < arr.size() ; j++){
            if(brick.weight > arr.get(j).weight){
                if(brick.maxPossible != 0) {
                    return brick.maxPossible;
                }

                brick.maxPossible = brick.height + recurse1(arr, j);
                return brick.maxPossible;
            } else {
                answer = Math.max(answer, recurse1(arr, j));
            }

        }
        answer = Math.max(answer, brick.maxPossible = brick.height);
        return brick.maxPossible;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Brick> arr = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            arr.add(new Brick(
                scanner.nextInt(),
                scanner.nextInt(),
                scanner.nextInt()
            ));
        }
        solution(arr);
    }
}
