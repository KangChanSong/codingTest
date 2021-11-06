package Inflearn.greedy;

import java.util.*;

public class 씨름선수 {

    static class Player{
        int height;
        int weight;
        public Player(int height, int weight){
            this.height = height;
            this.weight = weight;
        }
    }

    static int solution(List<Player> players){
        // 키와 몸무게가 모두 A 지원자보다 크지 않으면
        // A 지원자는 선발된다.
        // 최대 몇명?
        int size = players.size();
        Set<Player> losers = new HashSet<>();

        // 키가 가장 큰 선수를 뽑는다.
        // 선발되지 못하는 선수를 고른다.
        // 키가 두번째로 큰 선수를 뽑는다.
        // 선발되지 못하는 선수를 고른다.
        // 반    복
        while (players.size() > 0){
            Player tallest = getTallest(players);
            for(Player player : players){
                if(player.weight < tallest.weight) {
                    losers.add(player);
                }
            }
        }
        return size - losers.size();
    }


    private static Player getTallest(List<Player> players) {
        Player tallest = new Player(0, 0);
        for(Player player : players){
            if(player.height > tallest.height) tallest = player;
        }
        players.remove(tallest);
        return tallest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Player> players = new LinkedList<>();
        for(int i = 0 ; i < n ; i ++){
            int height = scanner.nextInt();
            int weight = scanner.nextInt();
            players.add(new Player(height, weight));
        }

        System.out.println(solution(players));
    }
}
