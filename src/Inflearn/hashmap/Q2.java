package Inflearn.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q2 {

    private static String solution(String s1, String s2){
        Map<Character, Integer> m1 = createMap(s1);
        Map<Character, Integer> m2 = createMap(s2);
        return m1.equals(m2) ? "YES" : "NO";
    }

    private static Map<Character, Integer> createMap(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < chars.length ; i++){
            if(map.get(chars[i]) == null){
                map.put(chars[i], 1);
            } else {
                map.put(chars[i], map.get(chars[i]) + 1);
            }
        }

        return map;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s1 = scanner.next();
        String s2 = scanner.next();

        System.out.println(solution(s1, s2));
    }
}
