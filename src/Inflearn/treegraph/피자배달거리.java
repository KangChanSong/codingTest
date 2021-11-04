package Inflearn.treegraph;

import java.sql.Array;
import java.util.*;

public class 피자배달거리 {

    static class House{
        int i;
        int j;
        int time;

        public House(int i, int j) {
            this.i = i;
            this.j = j;
            this.time = Integer.MAX_VALUE;
        }

        public void setCityDeliveryTime(List<Pizza> pizzas) {
            pizzas.forEach(pizza-> {
                int sum = Math.abs(pizza.i - this.i) + Math.abs(pizza.j - this.j);
                time = Math.min(sum, time);
            });
        }

    }

    static class Pizza{
        int i, j;
        public Pizza(int i , int j){
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Pizza{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

    static List<Pizza> pizzas = new ArrayList<>();
    static List<House> houses = new ArrayList<>();

    static int[][] city;
    static int limit;
    static int cityDeliveryTime = Integer.MAX_VALUE;

    static void solution() {
        List<Pizza> survivals = new ArrayList<>();
        dfs(0, survivals);
    }

    private static void dfs(int i, List<Pizza> survivals) {
        if(survivals.size() >= limit){
            int sum = 0;
            int min = Integer.MAX_VALUE;
            for(int x = 0 ; x < houses.size() ; x++){
                House house = houses.get(x);
                house.time = Integer.MAX_VALUE;
                houses.get(x).setCityDeliveryTime(survivals);
                min = Math.min(min, house.time);
                min = Math.min(min, house.time);
                sum += house.time;
            }
            cityDeliveryTime = Math.min(cityDeliveryTime, sum);
            survivals.remove(pizzas.get(i-1));
            return;
        }
        if(i > pizzas.size()-1 ) {
            survivals.remove(pizzas.get(i-1));
            return;
        }

        survivals.add(pizzas.get(i));
        dfs(i+1, survivals);
        survivals.remove(pizzas.get(i));
        dfs(i+1 , survivals);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        limit = scanner.nextInt();
        city = new int[n][n];
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                city[i][j] = scanner.nextInt();
                if(city[i][j] == 2) pizzas.add(new Pizza(i, j));
                if(city[i][j] == 1) houses.add(new House(i, j));
            }
        }
        solution();
        System.out.println(cityDeliveryTime);
    }
}
